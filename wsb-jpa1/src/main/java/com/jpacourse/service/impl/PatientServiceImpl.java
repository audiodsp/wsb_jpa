package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;

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

    @Transactional
    @Override
    public void deleteById(Long ID) {
        patientDao.delete(ID);
    }
}
