package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VisitMapper {

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private MedicalTreatmentMapper treatmentMapper;

    public VisitTO toTO(VisitEntity entity) {
        if (entity == null) {
            return null;
        }

        VisitTO to = new VisitTO();
        to.setId(entity.getId());
        to.setDescription(entity.getDescription());
        to.setTime(entity.getTime());
        to.setDoctor(doctorMapper.toTO(entity.getDoctor()));
        to.setTreatment(treatmentMapper.toTO(entity.getTreatment()));

        return to;
    }

    public VisitEntity toEntity(VisitTO to) {
        if (to == null) {
            return null;
        }

        VisitEntity entity = new VisitEntity();
        entity.setId(to.getId()); // Dodanie ID
        entity.setDescription(to.getDescription());
        entity.setTime(to.getTime());
        entity.setDoctor(doctorMapper.toEntity(to.getDoctor()));
        entity.setTreatment(treatmentMapper.toEntity(to.getTreatment()));

        return entity;
    }
}
