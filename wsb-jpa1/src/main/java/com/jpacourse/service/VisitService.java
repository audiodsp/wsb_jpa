package com.jpacourse.service;

import com.jpacourse.persistence.entity.VisitEntity;

import java.util.List;

public interface VisitService {
    List<VisitEntity> visitsByPatientID(int patientID);
}
