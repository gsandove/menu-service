package com.estelar.menuservice.dto.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Setter
@Getter
@EqualsAndHashCode
public class FoodResponseDTO {

    private Long id;
    private String title;
    private String description;
    private Date createdAt;
}
