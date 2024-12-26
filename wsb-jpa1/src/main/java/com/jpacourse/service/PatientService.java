package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.PatientEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;

public interface PatientService {
    PatientTO findById(final Long ID);
    void deleteById(final Long ID);
}
