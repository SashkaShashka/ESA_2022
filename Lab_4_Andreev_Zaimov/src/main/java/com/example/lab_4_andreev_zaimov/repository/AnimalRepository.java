package com.example.lab_4_andreev_zaimov.repository;

import com.example.lab_4_andreev_zaimov.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
}
