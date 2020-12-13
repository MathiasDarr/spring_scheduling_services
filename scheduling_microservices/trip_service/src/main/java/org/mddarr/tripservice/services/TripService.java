package org.mddarr.tripservice.services;

import org.mddarr.tripservice.models.TripDataPoint;
import org.mddarr.tripservice.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository){
        this.tripRepository = tripRepository;
    }

    public List<TripDataPoint> getTripData(String user_id, String trip_id){
        return this.tripRepository.getTripData(user_id, trip_id);
    }


}
