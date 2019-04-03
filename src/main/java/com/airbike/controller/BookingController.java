package com.airbike.controller;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbike.message.request.BookingForm;
import com.airbike.model.Booking;
import com.airbike.model.User;
import com.airbike.model.Vehicule;
import com.airbike.repository.BookingRepository;
import com.airbike.repository.UserRepository;
import com.airbike.repository.VehiculeRepository;

@RestController
@RequestMapping("/api")
public class BookingController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VehiculeRepository vehiculeRepository;

	@Autowired
	private BookingRepository bookingRepository;
	
	final int LENGTH_CODE = 12;



	@GetMapping("/bookings")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}

	@GetMapping("/user/{userId}/booking")
	 public List<Booking> getAllbookingForUser(@PathVariable (value = "userId") Long userId) {
		 return bookingRepository.findByUserId(userId);
	}

	@GetMapping("/vehicule/{vehiculeId}/booking")
	 public List<Booking> getAllCommentsByPostId(@PathVariable (value = "vehiculeId") Long vehiculeId) {
		 return bookingRepository.findByVehiculeId(vehiculeId);
	}

	@PostMapping("/booking")
	public ResponseEntity<?> registerBooking(@Valid @RequestBody BookingForm bookingRequest) {
		
		// get user
		User user = userRepository.findUserById(bookingRequest.getUserId());
		
		// get vehicule
		Vehicule vehicule = vehiculeRepository.findById(bookingRequest.getVehiculeId());
		
		// date format yyyy-mm-dd
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);	
		
		Date date_from = new Date();
		try {
			date_from = format.parse(bookingRequest.getDateFrom());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Date date_to = new Date();
		try {
			date_to = format.parse(bookingRequest.getDateTo());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		// create booking
		/*
			String code, 
			int status,
			Date dateFrom, 
			Date date_to, 
			Date date, 
			boolean deleted, 
			User user, 
			Vehicule vehicule
			*/
		Booking booking = new Booking(
				randomString(LENGTH_CODE),
				0,
				date_from,
				date_to,
				new Date(),
				false,
				user,
				vehicule
				);
		
		return ResponseEntity.ok(bookingRepository.save(booking));
	}
	
	// generate code
	final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	SecureRandom rnd = new SecureRandom();

	String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
}
