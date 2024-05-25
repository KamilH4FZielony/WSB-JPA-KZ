package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface PatientService {
    PatientTO findById(Long id);
    void deleteById(Long id);
    List<VisitTO> findVisitsByPatientId(Long patientId);
}
