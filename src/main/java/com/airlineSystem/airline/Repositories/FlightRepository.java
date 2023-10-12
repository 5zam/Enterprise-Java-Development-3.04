package com.airlineSystem.airline.Repositories;

import com.airlineSystem.airline.Entities.Customer;
import com.airlineSystem.airline.Entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    // find flights by flight number.
    Flight findByFlightId(Integer flightId);
    Optional<Flight> findByFlightNumber(String FlightNumber);

    List<Flight> findFlightByAircraft(String boeing);

    List<Flight> findFlightsByFlightMileageGreaterThan(int num);
}
