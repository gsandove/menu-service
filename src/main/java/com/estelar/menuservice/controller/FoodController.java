package com.estelar.menuservice.controller;

import com.estelar.menuservice.dto.request.FoodRequestDTO;
import com.estelar.menuservice.dto.request.FoodUpdateRequestDTO;
import com.estelar.menuservice.dto.response.FoodResponseDTO;
import com.estelar.menuservice.service.FoodService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/foods")
public class FoodController {

    private FoodService service;

    public FoodController(FoodService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<FoodResponseDTO>> findAll(){
        log.info("GET /foods");
        List<FoodResponseDTO> foodResponseDTOS = this.service.findAll();
        return ResponseEntity.ok(foodResponseDTOS);
    }

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody FoodRequestDTO request){
        log.info("POST /foods");
        Boolean isSuccess = this.service.save(request);
        return ResponseEntity.status(isSuccess? HttpStatus.OK.value() : HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(isSuccess);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@Validated @RequestBody FoodUpdateRequestDTO request){
        log.info("PUT /foods");
        Boolean isSuccess = this.service.update(request);
        return ResponseEntity.status(isSuccess? HttpStatus.OK.value() : HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(isSuccess);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam Long id){
        log.info("DELETE /foods");
        Boolean isSuccess = this.service.delete(id);
        return ResponseEntity.status(isSuccess? HttpStatus.OK.value() : HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(isSuccess);
    }
}
