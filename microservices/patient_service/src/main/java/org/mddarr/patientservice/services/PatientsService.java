package org.mddarr.patientservice.services;

import com.datastax.driver.core.PreparedStatement;
import org.mddarr.patientservice.dto.PostPatientRequest;
import org.mddarr.patientservice.models.Patient;
import org.mddarr.patientservice.models.PostgresPatient;
import org.mddarr.patientservice.repository.PatientPostgresRepository;
import org.mddarr.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PatientsService {

    @Autowired
    CassandraOperations cassandraTemplate;

    private final PatientRepository patientRepository;
    private final PatientPostgresRepository patientPostgresRepository;



    public PatientsService(PatientRepository patientRepository, PatientPostgresRepository patientPostgresRepository){
        this.patientRepository = patientRepository;
        this.patientPostgresRepository = patientPostgresRepository;
    }

    public List<PostgresPatient> getPatients(){
        List<PostgresPatient> patients = new ArrayList<>();
        patientPostgresRepository.findAll().forEach(patients::add); ;
        return patients;
    }

    public Patient getPatientDetail(String patient_id){
        return patientRepository.getPatientById(patient_id);
    }

    public String createNewPatient(PostPatientRequest postPatientRequest){
        String patient_id = UUID.randomUUID().toString();
        patientRepository.createNewPatient(patient_id, postPatientRequest.getFirst_name(), postPatientRequest.getLast_name());
        return patient_id;
    }

    public String postPatient(PostPatientRequest postPatientRequest){
        String patient_id = UUID.randomUUID().toString();
        Patient javaBook = new Patient(patient_id, postPatientRequest.getFirst_name(), postPatientRequest.getLast_name());
        cassandraTemplate.insert(javaBook);
        return patient_id;
    }

}
