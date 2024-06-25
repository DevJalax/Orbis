package com.scm.Supply.chain.apis.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Prescription {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String patientName;
    
    private String doctorName;
    
    private LocalDate prescribedDate;
    
    private LocalDate expirationDate;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PrescriptionItem> prescriptionItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public LocalDate getPrescribedDate() {
		return prescribedDate;
	}

	public void setPrescribedDate(LocalDate prescribedDate) {
		this.prescribedDate = prescribedDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public List<PrescriptionItem> getPrescriptionItems() {
		return prescriptionItems;
	}

	public void setPrescriptionItems(List<PrescriptionItem> prescriptionItems) {
		this.prescriptionItems = prescriptionItems;
	}
    
}
