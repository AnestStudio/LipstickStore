package org.anest.mystore.component;

import jakarta.annotation.PostConstruct;
import org.anest.mystore.entity.CommonValue;
import org.anest.mystore.repository.CommonValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Configuration: Used for general configuration settings of the application.
 * Settings: Used for settings specific to a component or module.
 * DefaultValues: Used for initial default values.
 */
@Component
public class DefaultValues {

    private final CommonValueRepository commonValueRepository;

    public static Map<String, String> properties;

    @Value("${common.value.type.default.value}")
    private String type;

    @Autowired
    public DefaultValues(CommonValueRepository commonValueRepository) {
        this.commonValueRepository = commonValueRepository;
    }

    @PostConstruct
    public void loadData() {
        List<CommonValue> list = commonValueRepository.findByType(type);
        properties = list.stream()
                .collect(Collectors.toMap(CommonValue::getKey, CommonValue::getValue));
    }
}
