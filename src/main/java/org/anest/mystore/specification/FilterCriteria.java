package org.anest.mystore.specification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class FilterCriteria {

    private String key;
    private String operation;
    private Object value;
}

