package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.stream.Collectors;

public class PatientMapper {
    public static PatientTO mapToDTO(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }
        final PatientTO patientDTO = new PatientTO();
        patientDTO.setId(patientEntity.getId());
        patientDTO.setFirstName(patientEntity.getFirstName());
        patientDTO.setLastName(patientEntity.getLastName());
        patientDTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientDTO.setEmail(patientEntity.getEmail());
        patientDTO.setPatientNumber(patientEntity.getPatientNumber());
        patientDTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientDTO.setLastVisitDate(patientEntity.getLastVisitDate());
        patientDTO.setVisits(patientEntity.getVisits().stream()
                .map(VisitMapper::mapToDTO)
                .collect(Collectors.toList()));
        return patientDTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientDTO) {
        if (patientDTO == null) {
            return null;
        }
        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientDTO.getId());
        patientEntity.setFirstName(patientDTO.getFirstName());
        patientEntity.setLastName(patientDTO.getLastName());
        patientEntity.setTelephoneNumber(patientDTO.getTelephoneNumber());
        patientEntity.setEmail(patientDTO.getEmail());
        patientEntity.setPatientNumber(patientDTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientDTO.getDateOfBirth());
        patientEntity.setLastVisitDate(patientDTO.getLastVisitDate());
        // Map visits
        patientEntity.setVisits(patientDTO.getVisits().stream()
                .map(VisitMapper::mapToEntity)
                .collect(Collectors.toList()));
        return patientEntity;
    }
}
