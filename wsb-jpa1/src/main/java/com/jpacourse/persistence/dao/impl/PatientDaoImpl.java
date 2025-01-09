package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
<<<<<<< HEAD
<<<<<<< HEAD
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public VisitEntity createVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String visitDescription) {
        PatientEntity patientEntity = em.find(PatientEntity.class, patientId);
        DoctorEntity doctorEntity = em.find(DoctorEntity.class, doctorId);
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setPatient(patientEntity);
        visitEntity.setDoctor(doctorEntity);
        visitEntity.setDescription(visitDescription);
        visitEntity.setTime(visitDate);

        patientEntity.getVisits().add(visitEntity);
        em.persist(visitEntity);
        em.merge(patientEntity);

        return visitEntity;
    }
}
=======
=======
import com.jpacourse.persistence.entity.DoctorEntity;
>>>>>>> 26f19f0 (lab3)
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
<<<<<<< HEAD
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao{ }
>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)
=======
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
        visitEntity.setDoctor(doctorEntity);
        visitEntity.setDescription(visitDescription);
        visitEntity.setTime(visitDate);

        patientEntity.getVisits().add(visitEntity);
        em.persist(visitEntity);
        em.merge(patientEntity);

        return visitEntity;
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
}
>>>>>>> 26f19f0 (lab3)
