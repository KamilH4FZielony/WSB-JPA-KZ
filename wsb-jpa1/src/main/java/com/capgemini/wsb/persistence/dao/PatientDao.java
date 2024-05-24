package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.time.LocalDate;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    List<PatientEntity> findPatientsWithMoreThanXVisits(int numberOfVisits);
    List<PatientEntity> findPatientsByLastVisitBefore(LocalDate date);
    List<PatientEntity> findPatientsByDateOfBirthBefore(LocalDate dateOfBirth);
}
