package org.mddarr.patientservice.controllers;

import org.mddarr.patientservice.models.Patient;
import org.mddarr.patientservice.services.PatientsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientsController {

    private final PatientsService patientsService;

    public PatientsController(PatientsService patientsService){
        this.patientsService = patientsService;
    }

    @GetMapping(value="patients")
    public List<Patient> getPatients(){
        return patientsService.getPatients();
    }
}
