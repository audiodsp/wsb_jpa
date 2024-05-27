package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;

import java.util.List;

public interface PatientService {
    List<PatientTO> getAllPatients();
    PatientTO getPatientById(Long id);
    PatientTO createPatient(PatientTO patientTO);
    PatientTO updatePatient(Long id, PatientTO patientTO);
    void deletePatient(Long id);
}
