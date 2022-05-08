package com.bhati.repository;

import org.springframework.data.repository.CrudRepository;

import com.bhati.model.Bookings;
import com.bhati.model.Movie;

public interface BookingRepository extends CrudRepository<Bookings, Integer> {
}
