package com.estelar.menuservice.service.impl;

import com.estelar.menuservice.domain.Food;
import com.estelar.menuservice.dto.request.FoodRequestDTO;
import com.estelar.menuservice.dto.request.FoodUpdateRequestDTO;
import com.estelar.menuservice.dto.response.FoodResponseDTO;
import com.estelar.menuservice.repository.FoodRepository;
import com.estelar.menuservice.service.FoodService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    private FoodRepository repository;

    public FoodServiceImpl(FoodRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FoodResponseDTO> findAll() {
        return this.repository.findAllByDeletedAtIsNull().stream()
                .map(e-> FoodResponseDTO.builder()
                        .id(e.getId())
                        .title(e.getTitle())
                        .description(e.getDescription())
                        .createdAt(e.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public FoodResponseDTO findById(Long id) {
        Optional<Food> food = this.repository.findById(id);
        if(food.isPresent() == false)
            return null;

        return FoodResponseDTO.builder()
                .id(food.get().getId())
                .title(food.get().getTitle())
                .description(food.get().getDescription())
                .createdAt(food.get().getCreatedAt())
                .build();
    }

    @Override
    public Boolean save(FoodRequestDTO foodRequest) {
        Food saveEntity = this.repository.save(Food.builder()
                .title(foodRequest.getTitle())
                .description(foodRequest.getDescription())
                .createdAt(new Date())
                .userCreated("default")
                .build());

        return saveEntity != null;
    }

    @Override
    public Boolean update(FoodUpdateRequestDTO foodUpdateRequest) {
        Optional<Food> entityOpt = this.repository.findById(foodUpdateRequest.getId());
        if(entityOpt.isPresent() == false)
            return false;

        Food entity = entityOpt.get();
        entity.setTitle(foodUpdateRequest.getTitle());
        entity.setDescription(foodUpdateRequest.getDescription());

        return this.repository.save(entity) != null;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Food> entityOpt = this.repository.findById(id);

        if(entityOpt.isPresent() == false)
            return false;

        Food entity = entityOpt.get();
        entity.setDeletedAt(new Date());
        entity.setUserDeleted("default");

        return this.repository.save(entity) != null;
    }
}
