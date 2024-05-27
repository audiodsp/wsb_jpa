package com.capgemini.wsb.mapper;


import org.springframework.stereotype.Component;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.dto.MedicalTreatmentTO;

@Component
public class MedicalTreatmentMapper {
    public MedicalTreatmentTO toTO(MedicalTreatmentEntity entity) {
        if (entity == null) {
            return null;
        }

        MedicalTreatmentTO to = new MedicalTreatmentTO();
        to.setId(entity.getId());
        to.setDescription(entity.getDescription());
        to.setType(entity.getType());

        return to;
    }

    public MedicalTreatmentEntity toEntity(MedicalTreatmentTO to) {
        if (to == null) {
            return null;
        }

        MedicalTreatmentEntity entity = new MedicalTreatmentEntity();
        entity.setId(to.getId()); // Dodanie ID
        entity.setDescription(to.getDescription());
        entity.setType(to.getType());

        return entity;
    }
}
