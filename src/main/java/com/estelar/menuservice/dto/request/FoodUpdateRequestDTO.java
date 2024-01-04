package com.estelar.menuservice.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode
public class FoodUpdateRequestDTO extends FoodRequestDTO {
    private Long id;
}
