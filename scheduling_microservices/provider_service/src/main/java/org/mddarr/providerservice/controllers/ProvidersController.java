package org.mddarr.providerservice.controllers;

import org.mddarr.providerservice.models.Patient;
import org.mddarr.providerservice.services.PatientsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProvidersController {

    private final PatientsService patientsService;

    public ProvidersController(PatientsService patientsService){
        this.patientsService = patientsService;
    }

    @GetMapping(value="patients")
    public List<Patient> getPatients(){
        return patientsService.getPatients();
    }
}
