package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void testShouldDeletePatientAndCascadeDeleteVisits() {
        // given
        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("John");
        doctor.setLastName("Doe");
        doctor.setTelephoneNumber("123456789");
        doctor.setEmail("john.doe@example.com");
        doctor.setDoctorNumber("D123");
        doctor.setSpecialization(Specialization.GP);
        doctorDao.save(doctor);
        doctorDao.save(doctor);

        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Alice");
        patient.setLastName("Smith");
        patient.setTelephoneNumber("987654321");
        patient.setEmail("alice.smith@example.com");
        patient.setPatientNumber("P123");
        patient.setDateOfBirth(LocalDate.of(1990, 1, 1));

        VisitEntity visit = new VisitEntity();
        visit.setDoctor(doctor);
        visit.setPatient(patient);
        visit.setTime(LocalDate.now().atStartOfDay());

        patient.setVisits(Collections.singletonList(visit));

        patientDao.save(patient);

        Long patientId = patient.getId();
        Long visitId = visit.getId();
        Long doctorId = doctor.getId();

        // when
        patientService.deletePatientById(patientId);

        // then
        assertThat(patientDao.findOne(patientId)).isNull();
        assertThat(visitDao.findOne(visitId)).isNull();
        assertThat(doctorDao.findOne(doctorId)).isNotNull();
    }


    @Test
    public void testFindPatientById() {
        // Assuming PatientService has a method to find a patient by ID
        PatientTO patient = patientService.findById(1L);

        // Assert that the retrieved patient's details match the expected values
        assertEquals("Jane", patient.getFirstName());
        assertEquals("Doe", patient.getLastName());
        assertEquals("jane.doe@example.com", patient.getEmail());
        // Add more assertions as needed
    }

    @Test
    public void testFindVisitsByPatientId() {
        // Przygotowanie danych testowych
        Long patientId = 1L;

        // Wywołanie metody do testowania
        List<VisitTO> visits = patientService.findVisitsByPatientId(patientId);

        // Aserty
        assertEquals(1, visits.size());
        VisitTO visit = visits.get(0);
        assertEquals("Annual Checkup", visit.getDescription());
        assertEquals(LocalDateTime.of(2024, 5, 20, 10, 0), visit.getTime());
        assertEquals(1L, visit.getDoctorId()); 
        assertEquals(1L, visit.getPatientId()); 
    }
}


