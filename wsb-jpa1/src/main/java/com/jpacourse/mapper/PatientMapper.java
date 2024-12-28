package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.PatientEntity;
import org.springframework.stereotype.Component;

@Component
public class
PatientMapper {
    public PatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null) return null;

        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientTO.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setDoesHaveChronicDiseases(patientEntity.getDoesHaveChronicDisease());

        return patientTO;

    }

    public PatientEntity mapToEntity(final PatientTO patientTO) {
        if (patientTO == null) return null;

        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setDoesHaveChronicDisease(patientTO.getDoesHaveChronicDiseases());

        return patientEntity;
    }
}