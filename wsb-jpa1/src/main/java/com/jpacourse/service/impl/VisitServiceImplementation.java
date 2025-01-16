package com.jpacourse.service.impl;

import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class VisitServiceImplementation  implements VisitService {

    private final VisitDao visitDao;

    @Autowired
    public VisitServiceImplementation(VisitDao visitDao) {
        this.visitDao = visitDao;
    }

    @Override
    public List<VisitEntity> visitsByPatientID(int patientID) {
        return visitDao.findVisitsByPatientID(patientID);
    }
}
