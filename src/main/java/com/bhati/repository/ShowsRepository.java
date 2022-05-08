package com.bhati.repository;

import org.springframework.data.repository.CrudRepository;

import com.bhati.model.Movie;
import com.bhati.model.Shows;

public interface ShowsRepository extends CrudRepository<Shows, Integer> {
}
