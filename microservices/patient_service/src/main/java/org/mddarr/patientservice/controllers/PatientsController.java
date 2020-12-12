package org.mddarr.patientservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientsController {

    @GetMapping(value="hello")
    public String hello(){
        return "hello";
    }
}
