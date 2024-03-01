package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

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
        Flight flight1 = new Flight("AWDA", 100, LocalDate.of(2020, Month.AUGUST, 12), LocalTime.of(6, 30));
        flightRepository.save(flight1);

        Flight flight2 = new Flight("dsa", 50, LocalDate.of(2020, Month.SEPTEMBER, 30), LocalTime.of(10, 30));
        flightRepository.save(flight2);

        Passenger passenger1 = new Passenger("ASDSA", "ASDAA");
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("DAWWE@", "!@£!DA");
        passengerRepository.save(passenger2);


    }
}
