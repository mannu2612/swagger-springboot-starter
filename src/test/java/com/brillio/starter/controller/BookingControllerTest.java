package com.brillio.starter.controller;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.brillio.starter.model.Booking;
import com.brillio.starter.service.BookingService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookingController.class, secure = false)
public class BookingControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookingService bookingService;

	@Test
	public void getBookingById() throws Exception {
		Mockito.when(bookingService.getBooking(Mockito.anyString())).thenReturn(getBookingObject());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/booking/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = getBokingJSONString();
		System.out.println(expected);
		System.out.println(result.getResponse().getContentAsString());
		Assert.assertTrue(expected.equalsIgnoreCase(result.getResponse().getContentAsString()));
	}

	@Test
	public void getAllBookings() throws Exception {
		Mockito.when(bookingService.getAllBooking()).thenReturn(getBookingObjects());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/booking").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = getBokingListJSONString();
		System.out.println(result.getResponse().getContentAsString());
		Assert.assertTrue(expected.equalsIgnoreCase(result.getResponse().getContentAsString()));
	}

	@Test
	public void createBooking() throws Exception {
		Mockito.doNothing().when(bookingService).createBooking(Mockito.any(Booking.class));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/booking").accept(MediaType.APPLICATION_JSON)
				.content(getBokingJSONString()).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void updateBooking() throws Exception {
		Mockito.doNothing().when(bookingService).updateBooking(Mockito.any(Booking.class));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/booking").accept(MediaType.APPLICATION_JSON)
				.content(getBokingJSONString()).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void deleteBooking() throws Exception {
		Mockito.doNothing().when(bookingService).deleteBooking((Mockito.any(String.class)));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/booking/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
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

	private String getBokingJSONString() {
		return "{\"id\":\"1\",\"passenger_name\":\"Timon\",\"departure\":\"Bangalore\",\"destination\":\"Delhi\"}";
	}

	private String getBokingListJSONString() {
		return "[{\"id\":\"1\",\"passenger_name\":\"Timon\",\"departure\":\"Bangalore\",\"destination\":\"Delhi\"}]";
	}

}
