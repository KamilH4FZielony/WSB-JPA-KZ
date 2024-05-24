package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController
{

    private final PatientService PatientService;


    public PatientController(PatientService PatientService) {
        this.PatientService = PatientService;
    }

    @GetMapping("/patient/{id}")
    PatientTO findBaId(@PathVariable final Long id) {
        final PatientTO Patient = PatientService.findById(id);
        if(Patient != null)
        {
            return Patient;
        }
        throw new EntityNotFoundException(id);
    }
}