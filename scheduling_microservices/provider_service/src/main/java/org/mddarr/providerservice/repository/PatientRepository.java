package org.mddarr.providerservice.repository;

import org.mddarr.providerservice.models.Patient;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CassandraRepository<Patient, Long> {

    @Query("SELECT * from patients where patient_id =(?0)")
    Patient findPatientByIdIn(long id);

    @Query("SELECT * from patients;")
    List<Patient> findAllPatients();

}