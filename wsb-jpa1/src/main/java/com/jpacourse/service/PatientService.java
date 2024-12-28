package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.PatientEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;

public interface PatientService {
    PatientTO findById(final Long ID);
    void deleteById(final Long ID);
=======
import java.util.List;

public interface PatientService {
    PatientTO findById(final Long ID);
    List<PatientEntity> getAllPatients();
    void deleteById(final Long ID);
    PatientTO createPatient(final PatientTO patientTO);
    PatientTO updatePatient(final PatientTO patientTO);
>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)
}
