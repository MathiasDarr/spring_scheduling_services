package org.mddarr.patientservice.services;

import org.mddarr.patientservice.models.Patient;
import org.mddarr.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientsService {

    private final PatientRepository patientRepository;

    public PatientsService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients(){
        return patientRepository.findAllPatients();
    }

}
