package com.jpacourse.dto;

import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {
    private Long id;
    private String description;
    private LocalDateTime time;
    private String doctorsFirstName;
    private String doctorsLastName;
    private List<String> treatmentTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDoctorFirstName() {
        return doctorsFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorsFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorsLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorsLastName = doctorLastName;
    }

    public List<String> getTreatmentTypes() {
        return treatmentTypes;
    }

    public void setTreatmentTypes(List<String> treatmentTypes) {
        this.treatmentTypes = treatmentTypes;
    }
}