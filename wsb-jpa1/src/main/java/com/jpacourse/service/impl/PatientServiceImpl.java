package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

import javax.transaction.Transactional;
=======
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;
import java.util.List;
>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao, PatientMapper patientMapper) {
        this.patientDao = patientDao;
        this.patientMapper = patientMapper;
    }

    @Override
    public PatientTO findById(Long ID) {
        final PatientEntity patientEntity = patientDao.findOne(ID);
        return patientMapper.mapToTO(patientEntity);
    }
<<<<<<< HEAD
=======

    @Override
    public List<PatientEntity> getAllPatients() {
        return patientDao.findAll();
    }

    @Override
    public PatientTO createPatient(PatientTO patientTO) {
        if (patientTO.getId() == null) {
            throw new IllegalArgumentException("Patient must have an ID");
        }
        PatientEntity patient = patientMapper.mapToEntity(patientTO);
        return patientMapper.mapToTO(patientDao.save(patient));
    }

    @Override
    public PatientTO updatePatient(PatientTO patientTO) {
        if (patientTO.getId() == null) {
            throw new IllegalArgumentException("Patient must have an ID");
        }
        final PatientEntity patient = patientMapper.mapToEntity(patientTO);
        return patientMapper.mapToTO(patientDao.save(patient));
    }

    @Transactional
    @Override
    public void deleteById(Long ID) {
        patientDao.delete(ID);
    }

>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)
}
