package com.airlineSystem.airline.Repositories;

import com.airlineSystem.airline.Entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<Flight,Integer> {

}
