package com.capgemini.wsb.service;

import com.capgemini.wsb.persistence.entity.VisitEntity;
import java.util.List;

public interface VisitService {
    List<VisitEntity> findAllVisitsByPatientId(Long patientId);
}