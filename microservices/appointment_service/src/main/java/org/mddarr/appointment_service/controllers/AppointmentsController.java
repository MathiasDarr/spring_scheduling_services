package org.mddarr.appointment_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentsController {

    @GetMapping(value="hello")
    public String hello(){
        return "hello";
    }

}
