package com.jpacourse.rest;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.service.impl.PatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.jpacourse.mapper.PatientMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientServiceImpl patientService;
    private final PatientMapper patientMapper;

    @GetMapping("/{id}")
    public ResponseEntity<PatientTO>
    getPatientById(@PathVariable Long id) {

        PatientTO patient = patientService.findById(id);
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/all")
    public List<PatientTO> getAllPatients() {
        return patientService.getAllPatients()
                .stream()
                .map(patientMapper::mapToTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<PatientTO> createPatient(@RequestBody PatientTO patientTO) {
        PatientTO createdPatient = patientService.createPatient(patientTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }
    @PutMapping
    public ResponseEntity<PatientTO> updatePatient(@RequestBody PatientTO patientTO) {
        PatientTO updatedPatient = patientService.updatePatient(patientTO);
        return ResponseEntity.ok(updatedPatient);
    }
}
