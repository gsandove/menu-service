package com.estelar.menuservice.service;

import com.estelar.menuservice.dto.request.FoodRequestDTO;
import com.estelar.menuservice.dto.request.FoodUpdateRequestDTO;
import com.estelar.menuservice.dto.response.FoodResponseDTO;

import java.util.List;

public interface FoodService {

    List<FoodResponseDTO> findAll();

    FoodResponseDTO findById(Long id);

    Boolean save(FoodRequestDTO foodRequest);

    Boolean update(FoodUpdateRequestDTO foodUpdateRequest);

    Boolean delete(Long id);
}
