package com.estelar.menuservice.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FoodRequestDTO {

    @NotNull
    private String title;

    private String description;

}
