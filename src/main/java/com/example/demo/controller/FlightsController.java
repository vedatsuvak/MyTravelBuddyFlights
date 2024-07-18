package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Flights;
import com.example.demo.service.FlightService;

@RestController
//spring boot app is open to gt accessed for any external applciation 
//@CrossOrigin(origins = "localhost:4200")
@CrossOrigin(origins = "*")
public class FlightsController {
	@Autowired
	private FlightService service;

	@PostMapping("/insert")
	public Flights insert(@RequestBody Flights flight) {
		service.insert(flight);
		return flight;

	}

	@PostMapping("/update")
	public String updateDestination(@RequestBody Flights flights) {
		service.updateFlight(flights);
		return "Hey, flight: " + flights.getFlightId() + ", successfully updated!";

	}

	@GetMapping("/getAllFlights")
	public List<Flights> findAllflights() {
		return service.getAll();
	}

	@GetMapping("/getOne/{id}")
	public Flights findFlight(@PathVariable int id) {
		return service.findById(id).orElse(null);
	}

	@GetMapping("/getPrice/{departureCity}/{arrivalCity}")
	public Integer findprice(@PathVariable String departureCity, @PathVariable String arrivalCity) {
		int price;
		price = service.findprice(departureCity, arrivalCity);
		return price;
	}

	@GetMapping("/findFlight/{departureCity}/{arrivalCity}")
	public Flights findFlight(@PathVariable String departureCity, @PathVariable String arrivalCity) {
		return service.findFlight(departureCity, arrivalCity);
	}

	@GetMapping("/searchFlights")
	public List<Flights> searchFlights(@RequestParam("departureCity") String departureCity,
			@RequestParam("arrivalCity") String arrivalCity, @RequestParam("date") String date) {
		return service.searchFlights(departureCity, arrivalCity, date);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		service.deleteById(id);
		return "Flight deleted successfully";
	}
}
