package com.example.lab_3_zaimov_andreev.repository;

import com.example.lab_3_zaimov_andreev.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
}
