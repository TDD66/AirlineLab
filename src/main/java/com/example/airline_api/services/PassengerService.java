package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;


    public List<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }


    public Optional<Passenger> findPassenger(Long id) {
        return passengerRepository.findById(id);
    }

    @Transactional
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
}
