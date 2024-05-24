import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DoctorDaoTest {

    @Autowired
    private DoctorDao doctorDao;

    @Test
    public void testFindDoctorsBySpecialization() {
        // Przygotowanie danych testowych
        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Emily");
        doctor.setLastName("Smith");
        doctor.setSpecialization("PEDIATRICIAN");
        doctorDao.save(doctor);

        // Wywołanie metody do testowania
        List<DoctorEntity> doctors = doctorDao.findDoctorsBySpecialization("PEDIATRICIAN");

        // Aserty
        assertEquals(1, doctors.size());
        assertEquals("Smith", doctors.get(0).getLastName());
    }
}
