package org.cimmyt.srv.sm.service;

import org.cimmyt.srv.sm.model.SampleBatch;
import org.cimmyt.srv.sm.to.CropTO;
import org.cimmyt.srv.sm.to.SampleBatchTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class SampleBatchTOToSampleBatch implements Converter<SampleBatchTO, SampleBatch> {
    @Override
    public SampleBatch convert(SampleBatchTO source) {
        SampleBatch target = new SampleBatch();
        target.setDescription(source.getDescription());
        target.setId(source.getId());
        target.setCreationTimestamp(Timestamp.from(Instant.now()));
        return target;
    }
}
