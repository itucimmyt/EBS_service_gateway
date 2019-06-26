package org.cimmyt.srv.sm.resource.impl;

import org.cimmyt.srv.common.to.ResponseStatusMessage;
import org.cimmyt.srv.sm.resource.SampleManagerResource;
import org.cimmyt.srv.sm.service.CatalogService;
import org.cimmyt.srv.sm.service.SampleManagerService;
import org.cimmyt.srv.sm.to.CropTO;
import org.cimmyt.srv.sm.to.SampleBatchTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("sm")
class SampleManagerResourceImpl implements SampleManagerResource {

    CatalogService catalogService;
    SampleManagerService sampleManagerService;

    @Autowired
    public SampleManagerResourceImpl(CatalogService catalogService, SampleManagerService sampleManagerService) {
        this.catalogService = catalogService;
        this.sampleManagerService = sampleManagerService;
    }

    @Override
    @GetMapping("crops")
    public Set<CropTO> findCrops() {
        return catalogService.findCrops();
    }

    @Override
    @PostMapping("sample-batches")
    public ResponseStatusMessage addRequestsToBatch(@RequestBody SampleBatchTO sampleBatch) {

        sampleManagerService.createSampleBatch(sampleBatch);

        return new ResponseStatusMessage();
    }
}
