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

import com.bhati.exception.SeatsNotAvailableException;
import com.bhati.model.Bookings;
import com.bhati.model.Movie;
import com.bhati.model.shared.BookingReqSharedModel;
import com.bhati.model.shared.BookingResSharedModel;
import com.bhati.model.shared.ShowsReqSharedModel;
import com.bhati.model.shared.ShowsResSharedModel;
import com.bhati.service.BookingsService;
import com.bhati.service.MovieService;

//creating RestController
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "bookingpath")
public class BookingsController {
	
	
	@Autowired
	BookingsService BookingsService;

	@RequestMapping(method = RequestMethod.GET, value = "/Booking")
	private List<Bookings> getAllBookings() {
		return BookingsService.getAllMovie();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Booking/{id}")
	private Bookings getMovieBooking(@PathVariable("id") int id) {
		return BookingsService.getMovieById(id);
	}

	
	@RequestMapping(method = RequestMethod.DELETE, value = "/Booking/{id}")
	private void deleteMovieBooking(@PathVariable("id") int id) {
		BookingsService.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/Booking")
	private  ResponseEntity<BookingResSharedModel> bookMovieTicket(@RequestBody BookingReqSharedModel Movie) {
		BookingResSharedModel responseModel = BookingsService.saveOrUpdate(Movie);
		if(responseModel.isBookingDone()) {
			return new ResponseEntity<BookingResSharedModel>(responseModel, HttpStatus.OK);
		}else {
			throw new SeatsNotAvailableException("Booking not Done,Seats Not Available");
		}
		
		
	}
		
}
