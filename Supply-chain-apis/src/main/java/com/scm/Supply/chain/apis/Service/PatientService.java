package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.MedicalHistory;
import com.scm.Supply.chain.apis.Entity.Patient;
import com.scm.Supply.chain.apis.Repo.MedicalHistoryRepository;
import com.scm.Supply.chain.apis.Repo.PatientRepository;

@Service
public class PatientService {
	
    private final PatientRepository patientRepository;
    
    private final MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, MedicalHistoryRepository medicalHistoryRepository) {
        this.patientRepository = patientRepository;
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatientById(Long id) throws Exception {
        return patientRepository.findById(id)
                .orElseThrow(() -> new Exception("Patient not found with id: " + id));
    }

    public Patient getPatientByEmail(String email) throws Exception {
        return patientRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Patient not found with email: " + email));
    }

    public MedicalHistory addMedicalHistory(Long patientId, MedicalHistory medicalHistory) throws Exception {
        Patient patient = getPatientById(patientId);
        medicalHistory.setPatient(patient);
        return medicalHistoryRepository.save(medicalHistory);
    }

    public List<MedicalHistory> getPatientMedicalHistory(Long patientId) {
        return medicalHistoryRepository.findByPatientId(patientId);
    }
}
