package com.aytdm.springbootjooq.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Country {
    String code;
    String name;
    String continent;
    String region;
    Double surfaceArea;
    Integer indepYear;
    Integer population;
    Double lifeExpectancy;
    Double gnp;
    Double gnpOld;
    String localName;
    String governmentForm;
    String headOfState;
    Integer capital;
    String code2;
}
