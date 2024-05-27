package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testFindByLastName() {
        List<PatientEntity> patients = patientRepository.findByLastName("Brown");
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        assertEquals(2, patients.size());
    }

    @Test
    public void testFindPatientsWithMoreThanXVisits() {
        List<PatientEntity> patients = patientRepository.findPatientsWithMoreThanXVisits(1L);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        assertEquals(2, patients.size());
    }

    @Test
    public void testFindPatientsByAgeGreaterThan() {
        List<PatientEntity> patients = patientRepository.findPatientsByAgeGreaterThan(35);
        assertNotNull(patients);
        assertFalse(patients.isEmpty());
        assertEquals(1, patients.size());
    }
}
