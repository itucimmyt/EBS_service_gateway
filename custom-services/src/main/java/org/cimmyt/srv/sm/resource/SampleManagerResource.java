package org.cimmyt.srv.sm.resource;

import org.cimmyt.srv.common.to.ResponseStatusMessage;
import org.cimmyt.srv.sm.to.CropTO;
import org.cimmyt.srv.sm.to.SampleBatchTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

public interface SampleManagerResource {

    public Set<CropTO> findCrops();

    public ResponseStatusMessage addRequestsToBatch(SampleBatchTO sampleBatch);
}
