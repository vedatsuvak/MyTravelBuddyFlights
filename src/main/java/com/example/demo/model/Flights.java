package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Flights {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	private String planeName;
	private int planeCapacity;
	private int remainingSeats;
	private String date;
	private String time;
	private String departureCity;
	private String arrivalCity;
	private int baseFare;

}
