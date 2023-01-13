package com.example.lab_4_andreev_zaimov.repository;

import com.example.lab_4_andreev_zaimov.model.DBChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<DBChange, Long> {
}
