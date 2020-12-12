package org.mddarr.scheduling_service.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SchedulingControllers {


    @GetMapping(value="patients")
    public String getPatientByID(){
        return "Hello";
    }
}
