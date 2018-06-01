package com.brillio.starter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookingNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final String MESSAGE = " Booking not found";
	private static final long serialVersionUID = 1L;
	public BookingNotFoundException() {
		super(MESSAGE);
	}
	public BookingNotFoundException(String bookingId) {
		super(MESSAGE+" for booking ID: "+bookingId);
	}
}
