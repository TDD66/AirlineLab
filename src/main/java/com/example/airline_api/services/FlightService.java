package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> findFlight(Long id) {
        return flightRepository.findById(id);
    }

    public Flight saveFlight(Flight newFlight) {
        return flightRepository.save(newFlight);
    }

    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}
