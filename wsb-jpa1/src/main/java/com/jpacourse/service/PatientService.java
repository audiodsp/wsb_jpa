package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
<<<<<<< HEAD
import com.jpacourse.persistence.entity.PatientEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;

public interface PatientService {
    PatientTO findById(final Long ID);
    void deleteById(final Long ID);
=======
import java.util.List;
=======
>>>>>>> 26f19f0 (lab3)

public interface PatientService {
    PatientTO findById(final Long ID);
    void deleteById(final Long ID);
<<<<<<< HEAD
    PatientTO createPatient(final PatientTO patientTO);
    PatientTO updatePatient(final PatientTO patientTO);
>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)
}
=======
}
>>>>>>> 26f19f0 (lab3)
