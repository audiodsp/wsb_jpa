package com.jpacourse.persistence.entity;

import com.jpacourse.persistence.enums.TreatmentType;

<<<<<<< HEAD
import javax.persistence.*;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	private TreatmentType type;

<<<<<<< HEAD
	@ManyToOne
	@JoinColumn(name = "VISIT_id", nullable = false)
	private VisitEntity visit;

=======
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

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

<<<<<<< HEAD
	public VisitEntity getVisit() {
		return visit;
	}

	public void setVisit(VisitEntity visit) {
		this.visit = visit;
	}
}
=======
}
>>>>>>> 73c4b2f (Edit PatientController, PatientServiceImp, PatientService and application.properties)
