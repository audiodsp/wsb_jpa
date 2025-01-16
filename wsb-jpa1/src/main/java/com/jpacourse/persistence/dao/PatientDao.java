package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    PatientEntity findPatientByLastname(String lastname);
    PatientEntity findPatientById(Long ID);
    List<PatientEntity> findPatientsByVisitCount(Integer visitCount);
    VisitEntity createVisit(Long patientId, Long doctorId, LocalDateTime visitDate, String visitDescription);
    PatientEntity updatePatient(PatientEntity patient);
    List<PatientEntity> findPatientWithChronicDiseasesAndOlderThan(LocalDate birthdate);
}