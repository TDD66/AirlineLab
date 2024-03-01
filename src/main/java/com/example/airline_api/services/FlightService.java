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
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

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

    @Transactional
    public Optional<Flight> addPassenger(PassengerDTO passengerDTO, Long id) {
        Optional<Passenger> passenger = passengerRepository.findByNameAndEmail(passengerDTO.getName(),
                                                                                passengerDTO.getEmail());
        if(passenger.isEmpty()){
            return Optional.empty();
        }

        Optional<Flight> flight = flightRepository.findById(id);
        if(flight.isEmpty()){
            return Optional.empty();
        }

        if(flight.get().getPassengers().size() == flight.get().getCapacity()){
            return Optional.empty();
        }

        flight.get().addPassenger(passenger.get());
        flightRepository.save(flight.get());

        return flight;
    }

    public List<Flight> findFlightsByDestination(String destination) {
        return flightRepository.findByDestination(destination);
    }
}
