package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Flights;

public interface FlightsRepo extends JpaRepository<Flights, Integer> {

	String query = "select f.baseFare from Flights f where f.departureCity=?1 and f.arrivalCity=?2";

	@Query(query)
	Integer findprice(String departureCity, String arrivalCity);

	String query1 = "select f from Flights f where f.departureCity=?1 and f.arrivalCity=?2";

	@Query(query1)
	Flights findFlight(String departureCity, String arrivalCity);

	String query2 = "select f from Flights f where f.departureCity=?1 and f.arrivalCity=?2 and f.date=?3";

	@Query(query2)
	List<Flights> searchFlights(String departureCity, String arrivalCity, String date);

}
