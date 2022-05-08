package com.bhati.repository;

import org.springframework.data.repository.CrudRepository;

import com.bhati.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
