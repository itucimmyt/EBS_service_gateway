package org.cimmyt.srv.sm.service;

import org.cimmyt.srv.sm.to.CropTO;

import java.util.Set;

public interface CatalogService {
    Set<CropTO> findCrops();
}
