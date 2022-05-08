package com.bhati.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhati.model.Bookings;
import com.bhati.model.Movie;
import com.bhati.model.Theatre;
import com.bhati.model.shared.MovieResSharedModel;
import com.bhati.model.shared.TheatreReqSharedModel;
import com.bhati.model.shared.TheatreResSharedModel;
import com.bhati.repository.BookingRepository;
import com.bhati.repository.MovieRepository;
import com.bhati.repository.TheatreRepository;

//defining the business logic
@Service
public class TheatreService {
	@Autowired
	TheatreRepository TheatreRepository;

//getting all Movie records
	public List<Theatre> getAllMovie() {
		List<Theatre> Movies = new ArrayList<Theatre>();
		TheatreRepository.findAll().forEach(Movie -> Movies.add(Movie));
		return Movies;
	}

//getting a specific record
	public Theatre getMovieById(int id) {
		return TheatreRepository.findById(id).get();
	}
	
	public TheatreResSharedModel saveOrUpdate(TheatreReqSharedModel theatre) {
		
		Theatre currentobj = new Theatre();
		currentobj.setLocation(theatre.getLocation());
		currentobj.setName(theatre.getName());
		currentobj.setCapactiy(theatre.getCapactiy());
		
		Theatre returnObj= TheatreRepository.save(currentobj);
		TheatreResSharedModel TheatreResSharedModel = new TheatreResSharedModel(); 
		TheatreResSharedModel.setId(returnObj.getId());
		return TheatreResSharedModel;
			
	}

//deleting a specific record
	public void delete(int id) {
		TheatreRepository.deleteById(id);
	}
}