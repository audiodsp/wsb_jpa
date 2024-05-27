package com.capgemini.wsb.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.dto.PatientTO;

import java.util.stream.Collectors;

@Component
public class PatientMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private VisitMapper visitMapper;

    public PatientTO toTO(PatientEntity entity) {
        if (entity == null) {
            return null;
        }

        PatientTO to = new PatientTO();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setTelephoneNumber(entity.getTelephoneNumber());
        to.setEmail(entity.getEmail());
        to.setPatientNumber(entity.getPatientNumber());
        to.setDateOfBirth(entity.getDateOfBirth());
        to.setAge(entity.getAge());
        to.setAddress(addressMapper.toTO(entity.getAddress()));
        to.setVisits(entity.getVisits().stream()
                .map(visitMapper::toTO)
                .collect(Collectors.toList()));

        return to;
    }

    public PatientEntity toEntity(PatientTO to) {
        if (to == null) {
            return null;
        }

        PatientEntity entity = new PatientEntity();
        entity.setId(to.getId());
        entity.setFirstName(to.getFirstName());
        entity.setLastName(to.getLastName());
        entity.setTelephoneNumber(to.getTelephoneNumber());
        entity.setEmail(to.getEmail());
        entity.setPatientNumber(to.getPatientNumber());
        entity.setDateOfBirth(to.getDateOfBirth());
        entity.setAge(to.getAge());
        entity.setAddress(addressMapper.toEntity(to.getAddress()));
        entity.setVisits(to.getVisits().stream()
                .map(visitMapper::toEntity)
                .collect(Collectors.toList()));

        return entity;
    }
}
