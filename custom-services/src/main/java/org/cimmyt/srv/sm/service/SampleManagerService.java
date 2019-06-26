package org.cimmyt.srv.sm.service;

import org.cimmyt.srv.sm.to.SampleBatchTO;

import java.util.Set;

public interface SampleManagerService {
    int createSampleBatch(SampleBatchTO sampleBatch);
}
