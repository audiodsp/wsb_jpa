package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.TreatmentType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Test
    void findPatientByLastname() {
        PatientEntity patientEntity = patientDao.findPatientByLastname("Ipsum");
        assertThat(patientEntity).isNotNull();
        assertThat(patientEntity.getFirstName().equals("Karen")).isTrue();
    }

    @Test
    void findPatientById() {
        PatientEntity patientEntity = patientDao.findOne(1L);
        assertThat(patientEntity).isNotNull();
        assertThat(patientEntity.getLastName().equals("Ipsum")).isTrue();
    }

    @Test
    void getPatientsWithMoreAppointmentsThanGivenNumber() {

        List<PatientEntity> patientEntities = patientDao.findPatientsByVisitCount(3);
        assertThat(patientEntities).isNotNull();
        assertThat(patientEntities.get(0).getFirstName().equals("Karen")).isTrue();
        assertThat(patientEntities.size()).isEqualTo(1);
    }

    @Test
    @Transactional
    void createVisit() {
        //given
        LocalDateTime visitDate = LocalDateTime.now();
        DoctorEntity doctor = doctorDao.findOne(1L);
        PatientEntity patient = patientDao.findOne(1L);
        MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
        medicalTreatmentEntity.setType(TreatmentType.RTG);
        medicalTreatmentEntity.setDescription("LOREM IPSUM");
        List<MedicalTreatmentEntity> treatments = new ArrayList<>();
        treatments.add(medicalTreatmentEntity);

        assertThat(patient).isNotNull();
        assertThat(doctor).isNotNull();
        int patientVisitsCount = patient.getVisits().size();

        //when
        VisitEntity result = new VisitEntity();
        result.setDescription("LOREM IPSUM");
        result.setTime(visitDate);
        result.setPatient(patient);
        result.setDoctorEntity(doctor);
        result.setTreatments(treatments);

        assertThat(result).isNotNull();
        assertThat(patient.getVisits().size()).isEqualTo(patientVisitsCount);
        assertThat(result.getPatient().getId()).isEqualTo(patient.getId());
        assertThat(result.getDoctorEntity().getId()).isEqualTo(doctor.getId());
        assertThat(result.getDescription()).isEqualTo("LOREM IPSUM");
        assertThat(result.getTime()).isEqualTo(visitDate);
    }

    @Test
    void getPatientVisits() {
        PatientEntity patientEntity = patientDao.findPatientById(1L);
        List<VisitEntity> visits = patientEntity.getVisits();

        assertThat(visits).isNotNull();
        assertThat(visits).isNotEmpty();
    }

    @Test
    void getPatientsWithChronicDiseaseAndOlderThan() {
        List<PatientEntity> patients = patientDao.findPatientWithChronicDiseasesAndOlderThan(LocalDate.of(2001, 1, 1));

        assertThat(patients.getFirst().getFirstName().equals("Karen"));
        assertThat(patients).isNotNull();
        assertThat(patients).isNotEmpty();
    }

    @Test
    void testOptimisticLocking() {
        PatientEntity patientEntity = patientDao.getOne(1L);

        PatientEntity patientEntity2 = patientDao.getOne(1L);
        patientEntity2.setFirstName("Carla");
//
        patientDao.updatePatient(patientEntity);

        Thread thread1 = new Thread(() -> {
            patientEntity.setLastName("Sophie");
            patientDao.updatePatient(patientEntity);
        });

        Thread thread2 = new Thread(() -> {
            patientEntity2.setLastName("Selena");
            patientDao.updatePatient(patientEntity2);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertThrows(IllegalStateException.class, () -> {
            patientDao.updatePatient(patientEntity);
        });
    }
}
