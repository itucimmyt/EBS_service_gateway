package org.cimmyt.srv.sm.service.impl;

import org.apache.tomcat.jni.Error;
import org.cimmyt.srv.sm.model.Request;
import org.cimmyt.srv.sm.model.SampleBatch;
import org.cimmyt.srv.sm.model.repo.RequestRepository;
import org.cimmyt.srv.sm.model.repo.SampleBatchRepository;
import org.cimmyt.srv.sm.service.SampleManagerService;
import org.cimmyt.srv.sm.to.SampleBatchTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED)
class SampleManagerServiceImpl implements SampleManagerService {

    private static Logger LOG = LoggerFactory.getLogger(SampleManagerServiceImpl.class);

    private static final int STATUS_REQ_CREATED = 1;
    private static final int STATUS_REQ_ACCEPTED = 2;
    private static final int STATUS_REQ_IN_BATCH = 3;

    RequestRepository requestRepository;
    SampleBatchRepository sampleBatchRepo;
    ConversionService conversionService;

    @Autowired
    public SampleManagerServiceImpl(RequestRepository requestRepository, SampleBatchRepository sampleBatchRepo
            ,ConversionService conversionService) {
        this.requestRepository = requestRepository;
        this.sampleBatchRepo = sampleBatchRepo;
        this.conversionService = conversionService;
    }

    @Override
    public int createSampleBatch(SampleBatchTO sampleBatch) {
        SampleBatch savedSampleBatch = sampleBatchRepo.save( conversionService.convert(sampleBatch, SampleBatch.class));

        Set<Integer> requestIds = sampleBatch.getRequests().stream()
                .map(r -> r.getId())
                .collect(Collectors.toSet());

        List<Request> requests = requestRepository.findAllById(requestIds);

        if( ! allRequestsAreAccepted(requests)) {
            throw new RuntimeException("All requests must be ACCEPTED");
        }

        LOG.info("Batch Saved: {}",savedSampleBatch);

        int result = requestRepository.updateSampleBatch(savedSampleBatch.getId(), requestIds, STATUS_REQ_IN_BATCH);

        return result;
    }

    private boolean allRequestsAreAccepted(List<Request> requests) {
        return ! requests.stream()
                .filter(r -> r.getStatusId() != STATUS_REQ_ACCEPTED)
                .findFirst()
                .isPresent();
    }
}
