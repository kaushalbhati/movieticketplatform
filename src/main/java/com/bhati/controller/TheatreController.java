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

import com.bhati.model.Bookings;
import com.bhati.model.Movie;
import com.bhati.model.Theatre;
import com.bhati.model.shared.MovieResSharedModel;
import com.bhati.model.shared.TheatreReqSharedModel;
import com.bhati.model.shared.TheatreResSharedModel;
import com.bhati.service.BookingsService;
import com.bhati.service.MovieService;
import com.bhati.service.TheatreService;

//creating RestController
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "theatrepath")
public class TheatreController {
	
	
	@Autowired
	TheatreService TheatreService;

	@RequestMapping(method = RequestMethod.GET, value = "/Theatre")
	private List<Theatre> getAllTheatre() {
		return TheatreService.getAllMovie();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Theatre/{id}")
	private Theatre getTheatreById(@PathVariable("id") int id) {
		return TheatreService.getMovieById(id);
	}

	
	@RequestMapping(method = RequestMethod.DELETE, value = "/Theatre/{id}")
	private void deleteAnyTheatre(@PathVariable("id") int id) {
		TheatreService.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/Theatre")
	private ResponseEntity<TheatreResSharedModel> addNewTheatre(@RequestBody TheatreReqSharedModel Movie) {
		TheatreResSharedModel responseModel = TheatreService.saveOrUpdate(Movie);
		return new ResponseEntity<TheatreResSharedModel>(responseModel, HttpStatus.OK);
	}
}
