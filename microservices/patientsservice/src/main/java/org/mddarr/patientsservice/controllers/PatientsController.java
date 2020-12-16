package org.mddarr.patientsservice.controllers;

import org.mddarr.patientsservice.models.Patient;
import org.mddarr.patientsservice.services.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientsController {

    private final PatientService patientService;

    public PatientsController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping(value ="patients")
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }

    @GetMapping(value="patients/{patient_id}")
    public Optional<Patient> getPatientDetail(@PathVariable String patient_id){
        return patientService.getPatientDetail(patient_id);
    }


}
