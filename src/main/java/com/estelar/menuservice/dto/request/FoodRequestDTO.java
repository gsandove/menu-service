package com.estelar.menuservice.dto.request;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
@EqualsAndHashCode
public class FoodRequestDTO {

    private String title;
    private String description;

}
