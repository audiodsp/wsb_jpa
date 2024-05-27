package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.repository.VisitRepository;
import com.capgemini.wsb.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public List<VisitEntity> findAllVisitsByPatientId(Long patientId) {
        return visitRepository.findAllByPatientId(patientId);
    }
}