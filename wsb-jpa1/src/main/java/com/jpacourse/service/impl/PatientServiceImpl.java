package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientDao patientDao;

    @Autowired
    public  PatientServiceImpl(PatientDao patientDao){
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO findById(Long ID) {
        return null;
    }
}
