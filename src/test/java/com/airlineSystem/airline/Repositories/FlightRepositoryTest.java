package com.airlineSystem.airline.Repositories;

import com.airlineSystem.airline.Entities.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FlightRepositoryTest {
    @Autowired
    FlightRepository flightRepository;
    //private Flight flight1;
    // private List<Flight> flights;
    private Flight flight2;

    @BeforeEach
    public void setUp() {
        flightRepository.saveAll(List.of(
                new Flight("DL143", "Boeing 747", 400, 135),
                new Flight("DL122", "Airbus A330", 236, 4370),
                new Flight("DL53", "Boeing 777", 264, 2078),
                new Flight("DL222", "Boeing 777", 264, 1765),
                new Flight("DL37", "Boeing 747", 400, 531)));
    }

    @AfterEach
    void removeAll() {
        flightRepository.deleteAll();
    }

    @Test
    void testCreateFlight() {
        Flight flight1 = new Flight("DL222", "Boeing 777", 264, 1765);
        Flight flight2 = new Flight("DL122", "Airbus A330", 236, 4370);

        flightRepository.saveAll(List.of(flight1, flight2));
        List<Flight> retrievedFlights = flightRepository.findAll();
        assertEquals(8, retrievedFlights.size());
        assertTrue(retrievedFlights.contains(flight1));
        assertTrue(retrievedFlights.contains(flight2));
    }

    @Test
    void FindFlightByFlightNumber() {
        Flight expectedFlight = new Flight("DL143", "Boeing 747", 400, 135);

        flightRepository.save(expectedFlight);
        Optional<Flight> foundFlightOptional = flightRepository.findByFlightNumber("DL143");
        assertTrue(foundFlightOptional.isPresent(), "Flight is not present in the repository, try Again");

        Flight foundFlight = foundFlightOptional.get();
        assertNotNull(foundFlight, "Found flight is null");
        assertEquals(expectedFlight.getFlightNumber(), foundFlight.getFlightNumber(), "Flight numbers do not match");
        assertEquals(expectedFlight.getAircraft(), foundFlight.getAircraft(), "Aircraft types do not match");

    }

    @Test
    void FindAircraftByAircraftName() {
        List<Flight> boeingAircraftList = flightRepository.findFlightByAircraft("Boeing 777");
        System.out.println("After saving: " + flightRepository.findAll());
        assertEquals(2, boeingAircraftList.size());

        for (Flight flight : boeingAircraftList) {
            assertTrue(flight.getAircraft().contains("Boeing 777"));
        }

    }

    @Test
    void FindFlightsWithDistance() {

        List<Flight> flightsWithDistanceGreaterThan500 = flightRepository.findFlightsByFlightMileageGreaterThan(500);
        System.out.println("After saving: " + flightRepository.findAll());
        assertEquals(4, flightsWithDistanceGreaterThan500.size());

        Flight flight = flightsWithDistanceGreaterThan500.get(0);
        assertEquals("DL143", flight.getFlightNumber());
        assertEquals("Boeing 747", flight.getAircraft());
        assertEquals(127656, flight.getFlightMileage());
        assertEquals(135, flight.getTotalAircraftSeats());


    }
}