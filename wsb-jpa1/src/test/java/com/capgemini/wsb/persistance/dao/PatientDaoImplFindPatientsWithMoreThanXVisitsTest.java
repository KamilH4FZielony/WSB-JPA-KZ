package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.impl.PatientDaoImpl;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PatientDaoImplFindPatientsWithMoreThanXVisitsTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PatientDaoImpl patientDao;

    @Test
    void testFindPatientsWithMoreThanXVisits() {
        // Określ minimalną liczbę wizyt
        int visitsCount = 2; // Zakładając, że chcemy znaleźć pacjentów z więcej niż 1 wizytą

        // Wywołaj metodę, aby pobrać pacjentów z więcej niż X wizytami
        List<PatientEntity> foundPatients = patientDao.findPatientsWithMoreThanXVisits(visitsCount);

        // Znamy dane w bazie danych, więc możemy tworzyć asercje w oparciu o te dane
        // Na przykład, "John Doe" i "Jane Doe" powinni mieć po 1 wizycie.
        // "Alice Smith" i "Michael Johnson" powinni mieć po 0 wizyt.
        // W związku z tym spodziewamy się 0 pacjentów z więcej niż 1 wizytą.
        assertEquals(0, foundPatients.size());

        entityManager.close();
    }
}

