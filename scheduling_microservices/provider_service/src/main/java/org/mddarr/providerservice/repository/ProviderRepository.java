package org.mddarr.providerservice.repository;

import org.mddarr.providerservice.models.Provider;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends CassandraRepository<Provider, Long> {


    @Query("SELECT * from provider_department;")
    List<Provider> findAllProviders();

    @Query("SELECT * from provider_department where department_name=?0")
    List<Provider> findAllProvidersByDepartment(String department);

}