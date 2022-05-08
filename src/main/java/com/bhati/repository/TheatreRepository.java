package com.bhati.repository;

import org.springframework.data.repository.CrudRepository;

import com.bhati.model.Bookings;
import com.bhati.model.Movie;
import com.bhati.model.Theatre;

public interface TheatreRepository extends CrudRepository<Theatre, Integer> {
}
