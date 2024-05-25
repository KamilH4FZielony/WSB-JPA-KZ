package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;
import java.util.Optional;

public interface PatientDao extends Dao<PatientEntity, Long> {

    List<PatientEntity> findByLastName(String lastName);
    List<PatientEntity> findPatientsWithMoreThanXVisits(int visitsCount);
    List<PatientEntity> findByCustomField(String field, Object value, String condition);
    Optional<PatientEntity> findById(Long id);
}
