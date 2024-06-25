package com.scm.Supply.chain.apis.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.MedicalHistory;
import com.scm.Supply.chain.apis.Entity.Patient;
import com.scm.Supply.chain.apis.Service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) throws Exception {
        Patient patient = patientService.getPatientById(id);
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Patient> getPatientByEmail(@PathVariable String email) throws Exception {
        Patient patient = patientService.getPatientByEmail(email);
        return ResponseEntity.ok(patient);
    }

    @PostMapping("/{patientId}/medical-history")
    public ResponseEntity<MedicalHistory> addMedicalHistory(@PathVariable Long patientId, @RequestBody MedicalHistory medicalHistory) throws Exception {
        MedicalHistory createdMedicalHistory = patientService.addMedicalHistory(patientId, medicalHistory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedicalHistory);
    }

    @GetMapping("/{patientId}/medical-history")
    public ResponseEntity<List<MedicalHistory>> getPatientMedicalHistory(@PathVariable Long patientId) {
        List<MedicalHistory> medicalHistory = patientService.getPatientMedicalHistory(patientId);
        return ResponseEntity.ok(medicalHistory);
    }
}
