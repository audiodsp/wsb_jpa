package com.jpacourse.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(nullable = false)
    private LocalDateTime time;

    @ManyToOne // Relacja dwustronna z Patient
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

//    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL) // Relacja dwustronna z MedicalTreatment
//    private List<MedicalTreatmentEntity> treatments;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_id", nullable = false)
    private DoctorEntity doctorEntity;

    @ManyToMany
    @JoinTable(
            name = "VISIT_MEDICAL_TREATMENT", // Name of the join table
            joinColumns = @JoinColumn(name = "VISIT_id"), // Column for visit_id in the join table
            inverseJoinColumns = @JoinColumn(name = "MEDICAL_TREATMENT_id") // Column for medical_treatment_id in the join table
    )
    private List<MedicalTreatmentEntity> treatments = new ArrayList<>();

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

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public DoctorEntity getDoctorEntity() {
        return doctorEntity;
    }

    public void setDoctorEntity(DoctorEntity doctorEntity) {
        this.doctorEntity = doctorEntity;
    }

    public List<MedicalTreatmentEntity> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<MedicalTreatmentEntity> treatments) {
        this.treatments = treatments;
    }
}
