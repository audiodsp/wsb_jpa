package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.repository.PatientRepository;
import com.capgemini.wsb.repository.VisitRepository;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.dto.PatientTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public List<PatientTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patientMapper::toTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientTO getPatientById(Long id) {
        return patientRepository.findById(id)
                .map(patientMapper::toTO)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public PatientTO createPatient(PatientTO patientTO) {
        PatientEntity patientEntity = patientMapper.toEntity(patientTO);
        patientEntity = patientRepository.save(patientEntity);
        return patientMapper.toTO(patientEntity);
    }

    @Override
    public PatientTO updatePatient(Long id, PatientTO patientTO) {
        if (!patientRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        PatientEntity patientEntity = patientMapper.toEntity(patientTO);
        patientEntity.setId(id);
        patientEntity = patientRepository.save(patientEntity);
        return patientMapper.toTO(patientEntity);
    }

    @Override
    @Transactional
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        visitRepository.deleteAllByPatientId(id);
        patientRepository.deleteById(id);
    }
}
