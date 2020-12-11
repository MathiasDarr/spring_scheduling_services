package org.mddarr.patientservice.services;

import org.mddarr.patientservice.repository.PatientRepository;
import org.mddarr.providerservice.models.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public Patient getPatientById(long patient_id){
        return patientRepository.findPatientByIdIn(patient_id);
    }

}
