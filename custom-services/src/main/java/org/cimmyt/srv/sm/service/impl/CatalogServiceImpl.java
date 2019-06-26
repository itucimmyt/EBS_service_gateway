package org.cimmyt.srv.sm.service.impl;

import org.cimmyt.srv.sm.model.repo.CropRepository;
import org.cimmyt.srv.sm.service.CatalogService;
import org.cimmyt.srv.sm.to.CropTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CatalogServiceImpl implements CatalogService {

    private CropRepository cropRepo;
    private ConversionService converter;

    @Autowired
    public CatalogServiceImpl(CropRepository cropRepo, ConversionService converter) {
        this.cropRepo = cropRepo;
        this.converter = converter;
    }

    @Override
    public Set<CropTO> findCrops() {
        return cropRepo.findAll().stream()
                .map(c -> converter.convert(c, CropTO.class))
                .collect(Collectors.toSet());
    }
}
