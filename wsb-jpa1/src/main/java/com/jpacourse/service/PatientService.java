package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.PatientEntity;

import java.time.LocalDate;
import java.util.List;

public interface PatientService {
    PatientTO findById(final Long ID);
    void deleteById(final Long ID);
    List<PatientEntity> getAllPatients();
    PatientTO createPatient(final PatientTO patientTO);
    PatientTO updatePatient(final PatientTO patientTO);
    PatientTO findByLastname(final String lastname);
    List<PatientEntity> findByMoreAppointmentsAmount(final int moreAppointmentsAmount);
    List<PatientEntity> findByChronicDiseaseAndOlderThan(final LocalDate birthdate);
}
