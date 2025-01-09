package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
<<<<<<< HEAD
<<<<<<< HEAD
import com.jpacourse.persistence.entity.VisitEntity;

import java.time.LocalDateTime;

public interface PatientDao extends Dao<PatientEntity, Long>{
    VisitEntity createVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String visitDescription);
}
=======

public interface PatientDao extends Dao<PatientEntity, Long>  { }
>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)
=======
import com.jpacourse.persistence.entity.VisitEntity;

import java.time.LocalDateTime;

public interface PatientDao extends Dao<PatientEntity, Long> {
    PatientEntity findPatientByLastname(String lastname);
    PatientEntity findPatientById(Long ID);
    VisitEntity createVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String visitDescription);
}
>>>>>>> 26f19f0 (lab3)
