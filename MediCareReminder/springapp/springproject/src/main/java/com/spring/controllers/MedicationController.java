package com.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.MedicationDao;
import com.spring.pojos.Medication;

@CrossOrigin
@RestController
@RequestMapping("/medications")
public class MedicationController {

    @Autowired
    private MedicationDao medicationRepository;

    // Get all medications
    @GetMapping
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    // Get medication by ID
    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        Optional<Medication> medicationOptional = medicationRepository.findById(id);
        if (medicationOptional.isPresent()) {
            return ResponseEntity.ok(medicationOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new medication
    @PostMapping
    public ResponseEntity<Medication> createMedication(@RequestBody Medication medication) {
        Medication createdMedication = medicationRepository.save(medication);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedication);
    }

    // Update medication
    @PutMapping("/{id}")
    public ResponseEntity<Medication> updateMedication(@PathVariable Long id, @RequestBody Medication medication) {
        Optional<Medication> medicationOptional = medicationRepository.findById(id);
        if (medicationOptional.isPresent()) {
            Medication existingMedication = medicationOptional.get();
            existingMedication.setMedicationName(medication.getMedicationName());
            existingMedication.setFrequency(medication.getFrequency());
            existingMedication.setDosage(medication.getDosage());
            // Set other fields as needed

            Medication updatedMedication = medicationRepository.save(existingMedication);
            return ResponseEntity.ok(updatedMedication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete medication
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long id) {
    	Optional<Medication> userOptional = medicationRepository.findById(id);
        if (userOptional.isPresent()) {
        	medicationRepository.delete(userOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
     
