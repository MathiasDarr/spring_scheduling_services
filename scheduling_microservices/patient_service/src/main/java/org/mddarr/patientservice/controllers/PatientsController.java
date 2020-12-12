package org.mddarr.patientservice.controllers;

import org.mddarr.patientservice.dto.PostPatientRequest;
import org.mddarr.patientservice.models.Patient;
import org.mddarr.patientservice.services.PatientsService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value="patients/detail/{patient_id}")
    public Patient createNewPatient(@PathVariable String patient_id){
        return patientsService.getPatientDetail(patient_id);
    }

    @PostMapping(value="patients/detail")
    public String createNewPatient(@RequestBody PostPatientRequest postPatientRequest){
        return patientsService.postPatient(postPatientRequest);
        //        return patientsService.createNewPatient(postPatientRequest);
    }
}
