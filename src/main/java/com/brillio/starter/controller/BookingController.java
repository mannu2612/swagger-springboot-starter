package com.brillio.starter.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brillio.starter.model.Booking;
import com.brillio.starter.service.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/booking")
@Api(value = "/booking")
public class BookingController {
	@Autowired
	BookingService bookingService;

	@PostMapping
	@ApiOperation(value = "New Booking")
	public void create(@Valid @RequestBody Booking booking) {
		bookingService.createBooking(booking);
	}
	
	@GetMapping(value= "/{bookingId}")
	@ApiOperation(value = "Get booking by ID")
	public Booking getBooking(@ApiParam(value = "booking id", required = true) @PathVariable String bookingId) {
		return bookingService.getBooking(bookingId);
	}

	@GetMapping
	@ApiOperation(value = "Get all bookings")
	public List<Booking> getAllBooking() {
		return bookingService.getAllBooking();
	}
	
	@PutMapping
	@ApiOperation(value = "Update a booking")
	public void updateBooking(@Valid @RequestBody Booking updatedBooking) {
		bookingService.updateBooking(updatedBooking);
	}
	@DeleteMapping(value= "/{bookingId}")
	@ApiOperation(value = "Delete a booking by ID")
	public void deleteBooking(@ApiParam(value = "booking id", required = true) @PathVariable String bookingId) {
		bookingService.deleteBooking(bookingId);
	}
	
}
