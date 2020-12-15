package org.mddarr.patientservice.repository;


import org.mddarr.patientservice.models.PostgresPatient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientPostgresRepository extends CrudRepository<PostgresPatient, Integer> {
}