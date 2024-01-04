package com.estelar.menuservice.repository;

import com.estelar.menuservice.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByDeletedAtIsNull();
}
