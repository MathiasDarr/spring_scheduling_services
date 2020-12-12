package org.mddarr.providerservice.controllers;

import org.mddarr.providerservice.models.Provider;
import org.mddarr.providerservice.services.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProvidersController {

    private final ProviderService providerService;

    public ProvidersController(ProviderService patientsService){
        this.providerService = patientsService;
    }

    @GetMapping(value="providers")
    public List<Provider> getPatients(){
        return providerService.getProviders();
    }
}
