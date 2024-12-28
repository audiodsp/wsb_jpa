package com.jpacourse.persistence.entity;

<<<<<<< HEAD
import javax.persistence.*;
=======
>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
import javax.persistence.*;

>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)
@Entity
@Table(name = "VISIT")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(nullable = false)
    private LocalDateTime time;

<<<<<<< HEAD
    @ManyToOne // Relacja dwustronna z Doctor
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;

    @ManyToOne // Relacja dwustronna z Patient
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL) // Relacja dwustronna z MedicalTreatment
    private List<MedicalTreatmentEntity> treatments;
=======

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

>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)

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

<<<<<<< HEAD
    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public List<MedicalTreatmentEntity> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<MedicalTreatmentEntity> treatments) {
        this.treatments = treatments;
    }
}
=======
}
>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)
