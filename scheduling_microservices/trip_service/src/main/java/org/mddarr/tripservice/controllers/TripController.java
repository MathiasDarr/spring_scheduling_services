package org.mddarr.tripservice.controllers;

import org.mddarr.tripservice.models.TripDataPoint;
import org.mddarr.tripservice.repository.TripRepository;
import org.mddarr.tripservice.services.TripService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService){
        this.tripService = tripService;
    }

    @GetMapping(value="trips/{userid}/{tripid}")
    public List<TripDataPoint> getTripData(@PathVariable String userid, @PathVariable String tripid){
        return tripService.getTripData(userid, tripid);
    }

}
