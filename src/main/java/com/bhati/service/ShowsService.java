package com.bhati.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhati.model.Movie;
import com.bhati.model.Shows;
import com.bhati.model.Theatre;
import com.bhati.model.shared.ShowsAllResSharedModel;
import com.bhati.model.shared.ShowsReqSharedModel;
import com.bhati.model.shared.ShowsResSharedModel;
import com.bhati.model.shared.TheatreResSharedModel;
import com.bhati.repository.MovieRepository;
import com.bhati.repository.ShowsRepository;
import com.bhati.repository.TheatreRepository;

//defining the business logic
@Service
public class ShowsService {
	
	@Autowired
	ShowsRepository ShowsRepository;

	@Autowired
	MovieRepository MovieRepository;
	
	@Autowired
	TheatreRepository TheatreRepository;
	
	@Autowired
	TheatreService TheatreService;
	
//getting all Movie records
	public List<ShowsAllResSharedModel> getAllMovie() {
		List<ShowsAllResSharedModel> Movies = new ArrayList<ShowsAllResSharedModel>();

		Iterable<Shows> returnObj= ShowsRepository.findAll();
		
		for (Iterator iterator = returnObj.iterator(); iterator.hasNext();) {
			Shows eachshows = (Shows) iterator.next();
			
			Movie movie = MovieRepository.findById(eachshows.getMovieid()).get();
			
			Theatre theatre = TheatreRepository.findById(eachshows.getTheatreid()).get();
			
			ShowsAllResSharedModel ShowsAllResSharedModel = new ShowsAllResSharedModel();
			ShowsAllResSharedModel.setLocation(theatre.getLocation());
			ShowsAllResSharedModel.setMovieName(movie.getName());
			ShowsAllResSharedModel.setPrice(eachshows.getPrice());
			ShowsAllResSharedModel.setSeatsAvailable(eachshows.getPrice());
			ShowsAllResSharedModel.setShowTime(eachshows.getShowtime());
			ShowsAllResSharedModel.setTheatreName(theatre.getName());
			
			Movies.add(ShowsAllResSharedModel);
		}
		
		//ShowsRepository.findAll().forEach(Movie -> Movies.add(Movie));
		return Movies;
	}

//getting a specific record
	public Shows getMovieById(int id) {
		return ShowsRepository.findById(id).get();
	}

	public ShowsResSharedModel saveOrUpdate(ShowsReqSharedModel requestObj) {
		
		Shows currentobj = new Shows();
		currentobj.setCurrentAvailability(requestObj.getCurrentAvailability());
		currentobj.setMovieid(requestObj.getMovieid());
		currentobj.setShowtime(requestObj.getShowtime());
		currentobj.setTheatreid(requestObj.getTheatreid());
		currentobj.setPrice(requestObj.getPrice());
		
		Shows returnObj= ShowsRepository.save(currentobj);
		ShowsResSharedModel ShowsResSharedModel = new ShowsResSharedModel(); 
		ShowsResSharedModel.setId(returnObj.getId());
		return ShowsResSharedModel;
		
	}

//deleting a specific record
	public void delete(int id) {
		ShowsRepository.deleteById(id);
	}
}