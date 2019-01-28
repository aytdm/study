package com.aytdm.springbootjooq.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class City {
    Integer id;
    String name;
    String countryCode;
    String district;
    Integer population;
}
