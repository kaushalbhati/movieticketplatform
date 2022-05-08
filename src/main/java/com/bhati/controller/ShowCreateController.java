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
import com.bhati.model.Shows;
import com.bhati.model.shared.ShowsAllResSharedModel;
import com.bhati.model.shared.ShowsReqSharedModel;
import com.bhati.model.shared.ShowsResSharedModel;
import com.bhati.model.shared.TheatreResSharedModel;
import com.bhati.service.MovieService;
import com.bhati.service.ShowsService;

//creating RestController
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "showpath")
public class ShowCreateController {
	
	@Autowired
	ShowsService ShowsService;

	@RequestMapping(method = RequestMethod.GET, value = "/shows")
	private ResponseEntity<List<ShowsAllResSharedModel>> getAllShow() {
		List<ShowsAllResSharedModel> responseModel = ShowsService.getAllMovie();
		return new ResponseEntity<List<ShowsAllResSharedModel>>(responseModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/shows/{id}")
	private Shows getShow(@PathVariable("id") int id) {
		return ShowsService.getMovieById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/shows/{id}")
	private void deleteShowForTheatre(@PathVariable("id") int id) {
		ShowsService.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/shows")
	private ResponseEntity<ShowsResSharedModel> createShowforTheatre(@RequestBody ShowsReqSharedModel Movie) {
		ShowsResSharedModel responseModel = ShowsService.saveOrUpdate(Movie);
		return new ResponseEntity<ShowsResSharedModel>(responseModel, HttpStatus.OK);
		
	}
}
