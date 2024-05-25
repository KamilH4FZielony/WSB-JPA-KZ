package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.MedicalTreatmentTO;

public interface MedicalTreatmentService {
    public MedicalTreatmentTO findById(final Long id);
}