package com.jpacourse.persistance.service;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import com.jpacourse.service.VisitService;
import com.jpacourse.service.impl.PatientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Test
    public void findVisitsByPatientsId() {
        List<VisitEntity> visits = visitService.visitsByPatientID(1);
        assertNotNull(visits);
        assertFalse(visits.isEmpty(), "There should be visits for this patient");

        VisitEntity visit = visits.get(0);
        assertEquals(1, visit.getPatient().getId());
    }
}
