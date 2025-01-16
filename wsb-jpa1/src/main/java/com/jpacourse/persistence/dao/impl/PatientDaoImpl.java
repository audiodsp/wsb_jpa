package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public VisitEntity createVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String visitDescription) {
        PatientEntity patientEntity = em.find(PatientEntity.class, patientId);
        DoctorEntity doctorEntity = em.find(DoctorEntity.class, doctorId);
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setPatient(patientEntity);
        visitEntity.setDoctorEntity(doctorEntity);
        visitEntity.setDescription(visitDescription);
        visitEntity.setTime(visitDate);

        patientEntity.getVisits().add(visitEntity);
        em.persist(visitEntity);
        em.merge(patientEntity);

        return visitEntity;
    }

    @Override
    public List<PatientEntity> findPatientWithChronicDiseasesAndOlderThan(LocalDate birthdate) {
        return em.createQuery("FROM PatientEntity WHERE doesHaveChronicDisease = true AND dateOfBirth < :birthdate", PatientEntity.class)
                .setParameter("birthdate", birthdate)
                .getResultList();

    }

    @Override
    public PatientEntity findPatientByLastname(String lastname) {
        return em.createQuery("FROM PatientEntity WHERE lastName = :lastname", PatientEntity.class)
                .setParameter("lastname", lastname)
                .getSingleResult();
    }

    @Override
    public PatientEntity findPatientById(Long ID) {
        return em.createQuery("FROM PatientEntity WHERE id = :ID", PatientEntity.class)
                .setParameter("ID", ID)
                .getSingleResult();
    }


    @Override
    public List<PatientEntity> findPatientsByVisitCount(Integer visitCount) {
        return em.createQuery(
                        "SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :visitCount", PatientEntity.class)
                .setParameter("visitCount", visitCount)
                .getResultList();
    }

    @Override
    public PatientEntity updatePatient(PatientEntity patient) {
        try {
            em.merge(patient);
        } catch (OptimisticLockException e) {
            throw new IllegalStateException("Patient has been modified by someone else");
        }
        return patient;
    }
}