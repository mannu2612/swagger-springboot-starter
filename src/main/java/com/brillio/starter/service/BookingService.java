package com.brillio.starter.service;

import java.util.List;
import com.brillio.starter.model.Booking;

public interface BookingService {

	public void createBooking( Booking booking);
	
	public Booking getBooking(String bookingId);

	public List<Booking> getAllBooking();
	
	public void updateBooking(Booking updatedBooking);

	public void deleteBooking(String bookingId);
}
