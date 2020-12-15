package org.mddarr.providerservice.services;

import org.mddarr.providerservice.models.Provider;
import org.mddarr.providerservice.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository patientRepository){
        this.providerRepository = patientRepository;
    }

    public List<Provider> getProviders(){
        return providerRepository.findAllProviders();
    }

    public List<Provider> getProvidersByDepartment(String department){
        return providerRepository.findAllProvidersByDepartment(department);
    }

}
