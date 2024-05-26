package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ComponentScan(basePackages = "com.capgemini.wsb.persistence.dao")  // Ensure your DAO package is scanned
class PatientDaoFindByLastNameTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    void testFindByLastName() {
        String lastName = "Kowalski";

        PatientEntity patient1 = new PatientEntity();
        patient1.setFirstName("John");
        patient1.setLastName(lastName);
        patient1.setAge(30);
        patient1.setDateOfBirth(LocalDate.of(1990, 1, 1));
        patient1.setEmail("example1@example.com");
        patient1.setPatientNumber("PN001");
        patient1.setTelephoneNumber("123456789");

        PatientEntity patient2 = new PatientEntity();
        patient2.setFirstName("Jane");
        patient2.setLastName(lastName);
        patient2.setAge(25);
        patient2.setDateOfBirth(LocalDate.of(1995, 1, 1));
        patient2.setEmail("example2@example.com");
        patient2.setPatientNumber("PN002");
        patient2.setTelephoneNumber("987654321");

        patientDao.save(patient1);
        patientDao.save(patient2);

        List<PatientEntity> foundPatients = patientDao.findByLastName(lastName);

        assertEquals(2, foundPatients.size());
        assertEquals(patient1.getLastName(), foundPatients.get(0).getLastName());
        assertEquals(patient2.getLastName(), foundPatients.get(1).getLastName());
    }
}