package com.bhati.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhati.model.Movie;
import com.bhati.model.shared.MovieReqSharedModel;
import com.bhati.model.shared.MovieResSharedModel;
import com.bhati.service.MovieService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "moviepath")
public class MovieController {
	
	
	@Autowired
	MovieService MovieService;
	 
	@RequestMapping(method = RequestMethod.GET, value = "/Movie")
	private List<Movie> getAllMovie() {
		return MovieService.getAllMovie();
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/Movie/{id}")
	private Movie getMovie(@PathVariable("id") int id) {
		return MovieService.getMovieById(id);
	}

	
	@RequestMapping(method = RequestMethod.DELETE, value = "/Movie/{id}")
	private void deleteMovie(@PathVariable("id") int id) {
		MovieService.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/Movie")
	private ResponseEntity<MovieResSharedModel> createNewMovieRequest(@RequestBody MovieReqSharedModel Movie) {
		MovieResSharedModel responseModel = MovieService.saveOrUpdate(Movie);
		return new ResponseEntity<MovieResSharedModel>(responseModel, HttpStatus.OK);
	}
}
