package com.brillio.starter.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {

	@Id
	String id;
	
	@NotNull
	@Size(min=2, max = 20, message="Passenger Name should have 2 to 7 characters")
	String passengerName;
	
	@NotNull
	@Size(min=2, max = 20, message="Departure should have 2 to 7 characters")
	String departure;
	
	@NotNull
	@Size(min=2, max = 20, message="Destination should have 2 to 7 characters")
	String destination;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
