import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VisitDaoTest {

    @Autowired
    private VisitDao visitDao;

    @Test
    public void testFindAllVisitsByPatientId() {
        // Przygotowanie danych testowych
        VisitEntity visit1 = new VisitEntity();
        visit1.setDescription("Annual Checkup");
        visit1.setTime(LocalDateTime.now());
        visitDao.save(visit1);

        // Wywołanie metody do testowania
        List<VisitEntity> visits = visitDao.findAllVisitsByPatientId(1L);

        // Aserty
        assertEquals(1, visits.size());
        assertEquals("Annual Checkup", visits.get(0).getDescription());
    }
}
