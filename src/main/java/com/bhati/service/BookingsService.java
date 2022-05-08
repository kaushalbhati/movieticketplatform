package com.bhati.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhati.model.Bookings;
import com.bhati.model.Movie;
import com.bhati.model.Shows;
import com.bhati.model.shared.BookingReqSharedModel;
import com.bhati.model.shared.BookingResSharedModel;
import com.bhati.model.shared.ShowsResSharedModel;
import com.bhati.repository.BookingRepository;
import com.bhati.repository.MovieRepository;
import com.bhati.repository.ShowsRepository;
import com.bhati.repository.TheatreRepository;

//defining the business logic
@Service
public class BookingsService {
	
	private static final Logger LOGGER = LogManager.getLogger(BookingsService.class);
	
	@Autowired
	BookingRepository BookingRepository;

	@Autowired
	ShowsRepository ShowsRepository;
	
	@Autowired
	MovieService MovieService;
	
	@Autowired
	TheatreService TheatreService;
	
	@Autowired
	ShowsService ShowsService;
	
	private final MoviePlatformDroolsService MoviePlatformDroolsService;
	
	private BookingsService() {
    	this.MoviePlatformDroolsService = null;
    }
	
	private static BookingsService ourInstance = new BookingsService();
    
    public static BookingsService getInstance() {
        return ourInstance;
    }
    
	@Autowired
	public BookingsService(MoviePlatformDroolsService weatherdroolservice) {
		this.MoviePlatformDroolsService = weatherdroolservice;
	}
	
//getting all Movie records
	public List<Bookings> getAllMovie() {
		List<Bookings> Movies = new ArrayList<Bookings>();
		BookingRepository.findAll().forEach(Movie -> Movies.add(Movie));
		return Movies;
	}

//getting a specific record
	public Bookings getMovieById(int id) {
		return BookingRepository.findById(id).get();
	}

	public BookingResSharedModel saveOrUpdate(BookingReqSharedModel requestObj) {
		
		Shows shows = ShowsService.getMovieById(requestObj.getShowid());
		BookingResSharedModel BookingResSharedModel = new BookingResSharedModel();
		
		int currentAvailability = shows.getCurrentAvailability();
		if(currentAvailability >= requestObj.getSeatsbooked()) {
			
			//Movie eachmovie = MovieService.getMovieById(shows.getMovieid());
			
			Bookings currentobj = new Bookings();
			currentobj.setMovieid(shows.getMovieid());
			currentobj.setSeatsbooked(requestObj.getSeatsbooked());
			currentobj.setShowid(requestObj.getShowid());
			currentobj.setTheatreid(shows.getTheatreid());
			currentobj.setUserid(requestObj.getUserid());
			
			Bookings returnObj = BookingRepository.save(currentobj);
			int newSeatsAvailability = currentAvailability-currentobj.getSeatsbooked();
			
			Shows updateShows = new Shows();
			updateShows.setId(currentobj.getShowid());
			updateShows.setCurrentAvailability(newSeatsAvailability);
			updateShows.setMovieid(currentobj.getMovieid());
			updateShows.setTheatreid(currentobj.getTheatreid());
			updateShows.setShowtime(shows.getShowtime());
			updateShows.setPrice(shows.getPrice());
			
			ShowsRepository.save(updateShows);
			
			BookingResSharedModel.setBookingDone(true);
			BookingResSharedModel.setId(returnObj.getId());
			BookingResSharedModel.setShowtime(shows.getShowtime());
			BookingResSharedModel.setFinalPrice(shows.getPrice());
			BookingResSharedModel.setTicketAsked(currentobj.getSeatsbooked());
			
			MoviePlatformDroolsService.getMovieDecision(BookingResSharedModel);
			
			return BookingResSharedModel;
			
		}else if(currentAvailability < requestObj.getSeatsbooked()) {
			
			BookingResSharedModel.setBookingDone(false);
			return BookingResSharedModel;
			
		}else{
			
			BookingResSharedModel.setBookingDone(false);
			return BookingResSharedModel;
		}
		
		
	}

//deleting a specific record
	public void delete(int id) {
		BookingRepository.deleteById(id);
	}
	
	
	public int getHourValueFromDate(Date datetime) {
		
		int timeOfDay = datetime.getHours();

		if(timeOfDay >= 0 && timeOfDay < 12){
		    return 1;    
		}else if(timeOfDay >= 12 && timeOfDay < 16){
			return 2;
		}else if(timeOfDay >= 16 && timeOfDay < 21){
			return 3;
		}else if(timeOfDay >= 21 && timeOfDay < 24){
			return 4;
		}
		return timeOfDay;
			
	}
	
}