package com.brillio.starter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.starter.exception.BookingNotFoundException;
import com.brillio.starter.model.Booking;
import com.brillio.starter.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public void createBooking(Booking booking) {
		bookingRepository.save(booking);
	}

	@Override
	public Booking getBooking(String bookingId) {
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		if(!booking.isPresent()){
			throw new BookingNotFoundException(bookingId);
		}
		return booking.get();
	}

	@Override
	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}

	@Override
	public void updateBooking(Booking updatedBooking) {
		bookingRepository.save(updatedBooking);
	}

	@Override
	public void deleteBooking(String bookingId) {
		bookingRepository.deleteById(bookingId);
	}

}
