package com.brillio.starter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
import com.brillio.starter.model.Booking;

@Transactional
public interface BookingRepository extends MongoRepository<Booking, String> {

}
