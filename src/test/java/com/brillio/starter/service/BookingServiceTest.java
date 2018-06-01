package com.brillio.starter.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.brillio.starter.exception.BookingNotFoundException;
import com.brillio.starter.model.Booking;
import com.brillio.starter.repository.BookingRepository;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

	
	@Mock
	private BookingRepository bookingRepository;

	@InjectMocks
	BookingServiceImpl bookingService;
	
	@Test
	public void createBooking() throws Exception {
		Mockito.when(bookingRepository.save(Mockito.any(Booking.class))).thenReturn(getBookingObject());
		bookingService.createBooking(getBookingObject());
		assertTrue(true);
	}
	
	@Test
	public void updateBooking() throws Exception {
		Mockito.when(bookingRepository.save(Mockito.any(Booking.class))).thenReturn(getBookingObject());
		bookingService.updateBooking(getBookingObject());
		assertTrue(true);
	}
	
	@Test(expected = BookingNotFoundException.class)
	public void getNonExistingBooking() throws Exception {
		Mockito.doThrow(new BookingNotFoundException()).when(bookingRepository).findById("4");
		bookingService.getBooking("4");
	}
	
	@Test
	public void getBooking() throws Exception {
		Mockito.when(bookingRepository.findById("1")).thenReturn(getBookingWrapperObject());
		assertEquals(bookingService.getBooking("1").getId(),getBookingObject().getId());
	}
	
	@Test
	public void getAllBookings() throws Exception {
		Mockito.when(bookingRepository.findAll()).thenReturn(getBookingObjects());
		assertEquals(bookingService.getAllBooking().get(0).getId(),getBookingObject().getId());
	}
	
	@Test
	public void deleteBooking() throws Exception {
		Mockito.doNothing().when(bookingRepository).deleteById((Mockito.any(String.class)));
		bookingService.deleteBooking("1");
		assertTrue(true);
	}
	
	private Optional<Booking> getBookingWrapperObject() {
		Booking booking = new Booking();
		booking.setId("1");
		booking.setPassengerName("Timon");
		booking.setDeparture("Bangalore");
		booking.setDestination("Delhi");
		Optional<Booking> bookingWrapper = Optional.of(booking);
		return bookingWrapper;
	}

	private List<Booking> getBookingObjects() {
		List<Booking> bookingList = new ArrayList<>();
		bookingList.add(getBookingObject());
		return bookingList;
	}

	private Booking getBookingObject() {
		Booking booking = new Booking();
		booking.setId("1");
		booking.setPassengerName("Timon");
		booking.setDeparture("Bangalore");
		booking.setDestination("Delhi");
		return booking;
	}
//
//	private String getBokingJSONString() {
//		return "{\"id\":\"1\",\"passenger_name\":\"Timon\",\"departure\":\"Bangalore\",\"destination\":\"Delhi\"}";
//	}
//
//	private String getBokingListJSONString() {
//		return "[{\"id\":\"1\",\"passenger_name\":\"Timon\",\"departure\":\"Bangalore\",\"destination\":\"Delhi\"}]";
//	}

}
