package com.capgemini.wsb.Service;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.impl.PatientDaoImpl;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional // Ensure the test runs within a transaction
class PatientServiceImplFindPatientByIdTest {

    @PersistenceContext
    private EntityManager entityManager; // Inject EntityManager

    @Autowired
    private PatientDaoImpl patientDaoImpl;

    @Autowired
    private PatientDao patientDao;

    @Test
    void testFindPatientById() {
        // Given
        Long patientId = 1L;

        // Mock PatientEntity
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientId);
        patientEntity.setFirstName("John");
        patientEntity.setLastName("Doe");
        patientEntity.setTelephoneNumber("123456789");
        patientEntity.setEmail("john.doe@example.com");
        patientEntity.setPatientNumber("P123");
        patientEntity.setDateOfBirth(LocalDate.of(1980, 1, 1));
        patientEntity.setAge(41);

        // Merge the entity
        PatientEntity mergedEntity = entityManager.merge(patientEntity);

        // When
        Optional<PatientEntity> resultOptional = patientDaoImpl.findById(patientId);

        // Then
        assertTrue(resultOptional.isPresent());
        PatientEntity result = resultOptional.get();
        assertEquals(patientId, result.getId());
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals("123456789", result.getTelephoneNumber());
        assertEquals("john.doe@example.com", result.getEmail());
        assertEquals("P123", result.getPatientNumber());
        assertEquals(LocalDate.of(1980, 1, 1), result.getDateOfBirth());
        assertEquals(41, result.getAge().intValue());
    }
}
