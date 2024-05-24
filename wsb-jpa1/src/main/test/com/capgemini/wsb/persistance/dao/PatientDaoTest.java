import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    public void testFindPatientsByLastName() {
        // Przygotowanie danych testowych
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patientDao.save(patient);

        // Wywołanie metody do testowania
        List<PatientEntity> patients = patientDao.findPatientsByLastName("Doe");

        // Aserty
        assertEquals(1, patients.size());
        assertEquals("Doe", patients.get(0).getLastName());
    }

    @Test
    public void testFindPatientsByLastVisitDate() {
        // Przygotowanie danych testowych
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("Jane");
        patient.setLastName("Smith");
        patient.setLastVisitDate(LocalDate.now().minusDays(30)); // Ostatnia wizyta 30 dni temu
        patientDao.save(patient);

        // Wywołanie metody do testowania
        List<PatientEntity> patients = patientDao.findPatientsByLastVisitDate(LocalDate.now().minusDays(31));

        // Aserty
        assertEquals(1, patients.size());
        assertEquals("Smith", patients.get(0).getLastName());
    }

    @Transactional
    @Test
    public void testFindPatientsWithMoreThanXVisitss() {
        int X = 2; // Dla przykładu, przyjmujemy X = 2
        prepareTestData(X);

        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanXVisits(X);

        // Aserty
        assertEquals(1, patients.size());
    }

    @Test
    @Transactional
    public void testFindPatientsWithMoreThanXVisits() {
        // Przygotowanie danych testowych
        PatientEntity patient1 = new PatientEntity();
        patient1.setFirstName("John");
        patient1.setLastName("Doe");
        patient1.setTelephoneNumber("123456789");
        patient1.setEmail("john.doe@example.com");
        patient1.setPatientNumber("P001");
        patient1.setDateOfBirth(LocalDate.of(1980, 5, 15));

        PatientEntity patient2 = new PatientEntity();
        patient2.setFirstName("Jane");
        patient2.setLastName("Smith");
        patient2.setTelephoneNumber("987654321");
        patient2.setEmail("jane.smith@example.com");
        patient2.setPatientNumber("P002");
        patient2.setDateOfBirth(LocalDate.of(1975, 8, 20));

        // Zapisanie pacjentów do bazy danych
        patientDao.save(patient1);
        patientDao.save(patient2);

        // Znalezienie pacjentów z więcej niż 1 wizytą
        List<PatientEntity> patientsWithMoreThanOneVisit = patientDao.findPatientsWithMoreThanXVisits(1);

        // Sprawdzenie wyników
        assertNotNull(patientsWithMoreThanOneVisit);
        assertEquals(1, patientsWithMoreThanOneVisit.size());
        assertEquals("John", patientsWithMoreThanOneVisit.get(0).getFirstName());
        assertEquals("Doe", patientsWithMoreThanOneVisit.get(0).getLastName());
        assertEquals("john.doe@example.com", patientsWithMoreThanOneVisit.get(0).getEmail());
    }

    // Przygotowanie danych do testu X wizyt
    private void prepareTestData(int X) {
        PatientEntity patient1 = new PatientEntity();
        patientDao.save(patient1);

        // Założmy, że pacjent 1 miał X+1 wizyt
        for (int i = 0; i < X + 1; i++) {
        }
    }

    @Transactional
    @Test
    public void testFindPatientsByLastVisitBefore() {
        // Przygotowanie danych testowych
        PatientEntity patient1 = new PatientEntity();
        patient1.setFirstName("John");
        patient1.setLastName("Doe");
        patient1.setLastVisitDate(LocalDate.of(2022, 1, 1));
        patientDao.save(patient1);

        PatientEntity patient2 = new PatientEntity();
        patient2.setFirstName("Jane");
        patient2.setLastName("Smith");
        patient2.setLastVisitDate(LocalDate.of(2023, 6, 15));
        patientDao.save(patient2);

        PatientEntity patient3 = new PatientEntity();
        patient3.setFirstName("Alice");
        patient3.setLastName("Johnson");
        patient3.setLastVisitDate(LocalDate.of(2024, 3, 30));
        patientDao.save(patient3);

        // Wywołanie testowanej metody
        LocalDate date = LocalDate.of(2023, 1, 1);
        List<PatientEntity> patients = patientDao.findPatientsByLastVisitBefore(date);

        // Sprawdzenie wyników
        assertEquals(1, patients.size());
        assertTrue(patients.contains(patient1));
        assertTrue(!patients.contains(patient2));
        assertTrue(!patients.contains(patient3));
    }

    @Transactional
    @Test
    public void testFindPatientsByDateOfBirthBefore() {
        // given
        LocalDate dateOfBirth = LocalDate.of(1985, 1, 1);

        // when
        List<PatientEntity> patients = patientDao.findPatientsByDateOfBirthBefore(dateOfBirth);

        // then
        assertEquals(2, patients.size()); // Oczekujemy dwóch pacjentów, których data urodzenia jest wcześniejsza niż
                                          // podana
    }
}
