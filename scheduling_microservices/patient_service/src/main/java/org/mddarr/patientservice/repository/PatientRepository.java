package org.mddarr.patientservice.repository;

import com.datastax.driver.core.PreparedStatement;
import org.mddarr.patientservice.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CassandraRepository<Patient, Long> {


    @Query("SELECT * from patients;")
    List<Patient> findAllPatients();

    @Query("INSERT INTO patients(patient_id, first_name, last_name) VALUES ('(?0)', '(?1)', '(?2)');")
    String createNewPatient(String patient_id, String first_name, String last_name);

    @Query("SELECT * FROM patients where patient_id=?0")
    Patient getPatientById(String patient_id);

}