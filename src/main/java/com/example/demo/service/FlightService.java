package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Flights;
import com.example.demo.repository.FlightsRepo;

@Service
public class FlightService {
	@Autowired
	private FlightsRepo repo;

	// Insert a Flight
	public Flights insert(Flights flights) {
		return repo.save(flights);
	}

	// Retrieve all Hotels
	public List<Flights> getAll() {
		return repo.findAll();
	}

	// Retrieve a Hotels by ID
	public Optional<Flights> findById(int id) {
		return repo.findById(id);
	}

	// Retrieve price by source and destination
	public Integer findprice(String departureCity, String arrivalCity) {
		return repo.findprice(departureCity, arrivalCity);
	}

	// Retrieve a Hotels by source and destination
	public Flights findFlight(String departureCity, String arrivalCity) {
		return repo.findFlight(departureCity, arrivalCity);
	}

	// update Hotels
	public Flights updateFlight(Flights flight) {
		return repo.save(flight);
	}

	public List<Flights> searchFlights(String departureCity, String arrivalCity, String date) {
		return repo.searchFlights(departureCity, arrivalCity, date);
	}

	// Delete a Flight by ID
	public String deleteById(int id) {
		repo.deleteById(id);
		return "Deleted";
	}
}
