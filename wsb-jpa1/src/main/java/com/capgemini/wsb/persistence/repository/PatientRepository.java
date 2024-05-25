package com.capgemini.wsb.persistence.repository;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    // Dodatkowe metody związane z operacjami na pacjentach można zdefiniować tutaj
}
