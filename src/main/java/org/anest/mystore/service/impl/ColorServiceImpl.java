package org.anest.mystore.service.impl;

import org.anest.mystore.entity.Color;
import org.anest.mystore.repository.ColorRepository;
import org.anest.mystore.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;

    @Autowired
    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public List<Color> findAll() {
        return colorRepository.findAll(Sort.by(Sort.Direction.ASC, "colorName"));
    }
}
