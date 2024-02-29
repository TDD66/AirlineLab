package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlightsFiltered(@RequestParam(required = false) String destination){
        if(destination == null){
            List<Flight> flights = flightService.findAllFlights();
            return new ResponseEntity<>(flights, HttpStatus.OK);
        }
        List<Flight> flights = flightService.findFlightsByDestination(destination);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        Optional<Flight> flight = flightService.findFlight(id);
        if(flight.isPresent()){
            return new ResponseEntity<>(flight.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight newFlight){
        Flight addedFlight = flightService.saveFlight(newFlight);
        return new ResponseEntity<>(addedFlight, HttpStatus.CREATED);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(@RequestBody PassengerDTO passengerDTO,
                                                        @PathVariable Long id){
        Optional<Flight> flight = flightService.addPassenger(passengerDTO, id);
        if(flight.isPresent()){
            return new ResponseEntity<>(flight.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
