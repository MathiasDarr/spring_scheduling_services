package org.mddarr.providerservice.repository;

import org.mddarr.providerservice.models.ProviderKey;
import org.mddarr.providerservice.models.Provider;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProviderRepository extends CassandraRepository<Provider, Long> {

    List<Provider> findByKeyFirstName(final String firstName);

    List<Provider> findByKeyFirstNameAndKeyDateOfBirthGreaterThan(final String firstName);

    @Query(allowFiltering = true)
    List<Provider> findByLastName(final String lastName);
}