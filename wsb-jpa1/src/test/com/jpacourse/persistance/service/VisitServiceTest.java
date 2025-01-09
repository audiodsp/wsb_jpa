package com.jpacourse.persistance.service;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.service.impl.PatientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class VisitServiceTest {

    @Autowired
    private PatientServiceImpl patientService;

    @Test
    public void findVisitsByPatientsId() {
        List<VisitTO> patientVisits = patientService.findById(1L).getVisits();
        System.out.println(patientVisits.get(1).getDescription());
    }
}
