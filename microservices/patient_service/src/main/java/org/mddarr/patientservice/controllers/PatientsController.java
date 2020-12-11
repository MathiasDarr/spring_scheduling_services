package org.mddarr.patientservice.controllers;



import org.mddarr.patientservice.services.PatientService;
import org.mddarr.providerservice.dto.Provider;

import org.mddarr.providerservice.models.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PatientsController {

    private final PatientService patientService;

    public PatientsController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping(value = "patients/{patient_id}")
    public Patient getPatientByID(@PathVariable long patient_id ){
        return patientService.getPatientById(patient_id);
    }
}
