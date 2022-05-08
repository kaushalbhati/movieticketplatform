package com.bhati.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhati.model.Movie;
import com.bhati.model.shared.MovieReqSharedModel;
import com.bhati.model.shared.MovieResSharedModel;
import com.bhati.repository.MovieRepository;

//defining the business logic
@Service
public class MovieService {
	
	@Autowired
	MovieRepository MovieRepository;
	
//getting all Movie records
	public List<Movie> getAllMovie() {
		List<Movie> Movies = new ArrayList<Movie>();
		MovieRepository.findAll().forEach(Movie -> Movies.add(Movie));
		return Movies;
	}

//getting a specific record
	public Movie getMovieById(int id) {
		return MovieRepository.findById(id).get();
	}

	public MovieResSharedModel saveOrUpdate(MovieReqSharedModel Movie) {
		Movie movie = new Movie();
		movie.setGenere(Movie.getGenere());
		movie.setLanguage(Movie.getLanguage());
		movie.setName(Movie.getName());
		
		Movie movier= MovieRepository.save(movie);
		MovieResSharedModel MovieResSharedModel = new MovieResSharedModel(); 
		MovieResSharedModel.setId(movier.getId());
		return MovieResSharedModel;
	}

//deleting a specific record
	public void delete(int id) {
		MovieRepository.deleteById(id);
	}
}