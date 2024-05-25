package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.impl.PatientDaoImpl;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class PatientDaoImplfindByCustomFieldTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PatientDaoImpl patientDao;

    @Test
    void testFindByCustomField() {
        // Given
        String field = "age";
        int value = 30;
        String condition = ">=";

        PatientEntity patient1 = new PatientEntity();
        patient1.setAge(35);
        patient1.setFirstName("Jane");
        patient1.setLastName("Doe");
        patient1.setPatientNumber("P456");
        patient1.setTelephoneNumber("987654321");

        PatientEntity patient2 = new PatientEntity();
        patient2.setAge(25);
        patient2.setFirstName("John");
        patient2.setLastName("Doe");
        patient2.setPatientNumber("P123");
        patient2.setTelephoneNumber("123456789");

        // When
        entityManager.persist(patient1);
        entityManager.persist(patient2);

        entityManager.flush();
        entityManager.clear();

        List<PatientEntity> foundPatients = patientDao.findByCustomField(field, value, condition);

        // Then
        assertEquals(9, foundPatients.size());
        for (PatientEntity patient : foundPatients) {
            assertTrue(patient.getAge() >= 30);
        }
    }
}

