package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientEntity> findPatientsWithMoreThanXVisits(int numberOfVisits) {
        Query query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p JOIN FETCH p.visits v GROUP BY p HAVING COUNT(v) > :numberOfVisits");
        query.setParameter("numberOfVisits", numberOfVisits);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientEntity> findPatientsByLastVisitBefore(LocalDate date) {
        Query query = entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.lastVisitDate < :date");
        query.setParameter("date", date);
        return query.getResultList();
    }

    @PersistenceContext
    private EntityManager entityMunagier;

    @Override
    public List<PatientEntity> findPatientsByDateOfBirthBefore(LocalDate dateOfBirth) {
        return entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.dateOfBirth < :dateOfBirth", PatientEntity.class)
                .setParameter("dateOfBirth", dateOfBirth)
                .getResultList();
    }
}