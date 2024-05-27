package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.VisitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Test
    public void testFindAllVisitsByPatientId() {
        List<VisitEntity> visits = visitService.findAllVisitsByPatientId(1L);
        assertNotNull(visits);
        assertFalse(visits.isEmpty());
        assertEquals(2, visits.size());
    }
}
