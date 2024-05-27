package com.capgemini.wsb.persistance.dao;
import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.repository.PatientRepository;
import com.capgemini.wsb.repository.VisitRepository;
import com.capgemini.wsb.repository.DoctorRepository;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.dto.PatientTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
@Transactional
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    public void testDeletePatient() {
        Long patientId = 1L;
        Long doctorCountBefore = doctorRepository.count();

        patientService.deletePatient(patientId);

        assertFalse(patientRepository.findById(patientId).isPresent());
        assertTrue(visitRepository.findAllByPatientId(patientId).isEmpty());
        assertEquals(doctorCountBefore, doctorRepository.count());
    }

    @Test
    public void testGetPatientById() {
        Long patientId = 1L;

        PatientTO patientTO = patientService.getPatientById(patientId);

        assertNotNull(patientTO);
        assertEquals(patientId, patientTO.getId());
        assertEquals("Alice", patientTO.getFirstName());
        assertEquals("Brown", patientTO.getLastName());
        assertEquals(34, patientTO.getAge());
        assertNotNull(patientTO.getVisits());
        assertFalse(patientTO.getVisits().isEmpty());
        assertEquals(1L, patientTO.getVisits().get(0).getId());
        assertEquals("John", patientTO.getVisits().get(0).getDoctor().getFirstName());
    }
}
