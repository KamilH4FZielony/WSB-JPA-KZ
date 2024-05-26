package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    private final EntityManager entityManager;

    public PatientDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreThanXVisits(int visitsCount) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :visitsCount", PatientEntity.class);
        query.setParameter("visitsCount", visitsCount);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findByCustomField(String field, Object value, String condition) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p." + field + " " + condition + " :value", PatientEntity.class);
        query.setParameter("value", value);
        return query.getResultList();

    }
    @Override
    public Optional<PatientEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(PatientEntity.class, id));
    }
}
