package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Flight flight1 = new Flight("AWDA",100, "ads", "asda");
        flightRepository.save(flight1);

        Flight flight2 = new Flight("w",1, "d", "f");
        flightRepository.save(flight2);

        Passenger passenger1 = new Passenger("ASDSA", "ASDAA");
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("DAWWE@", "!@£!DA");
        passengerRepository.save(passenger2);


    }
}
