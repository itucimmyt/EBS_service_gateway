package org.cimmyt.srv.sm.service;

import org.cimmyt.srv.sm.model.Crop;
import org.cimmyt.srv.sm.to.CropTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class CropConverter implements Converter<Crop, CropTO> {
    @Override
    public CropTO convert(Crop source) {
        return new CropTO(source.getId(),source.getName());
    }
}
