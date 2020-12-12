package org.mddarr.patientservice.services;

import org.mddarr.patientservice.repository.PatientRepository;
import org.mddarr.patientservice.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public Patient getPatientById(long patient_id){
        return patientRepository.findPatientByIdIn(patient_id);
    }

    public List<Patient> getPatients(){
        return patientRepository.findAllPatients();
    }

}
