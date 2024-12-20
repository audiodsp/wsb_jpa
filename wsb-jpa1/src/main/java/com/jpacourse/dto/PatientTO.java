package com.jpacourse.dto;

import com.jpacourse.persistence.entity.VisitEntity;

import java.io.Serializable;
import java.time.LocalDate;

public class PatientTO implements Serializable {
    private Long id;
    private String firstName, lastName, telephoneNumber, email, patientNumber;
    private Boolean doesHaveChronicDiseases;
    private LocalDate dateOfBirth;
    private VisitEntity visits;

    public Boolean getDoesHaveChronicDiseases() {
        return doesHaveChronicDiseases;
    }

    public void setDoesHaveChronicDiseases(Boolean doesHaveChronicDiseases) {
        this.doesHaveChronicDiseases = doesHaveChronicDiseases;
    }

    public VisitEntity getVisits() {
        return visits;
    }

    public void setVisits(VisitEntity visits) {
        this.visits = visits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
