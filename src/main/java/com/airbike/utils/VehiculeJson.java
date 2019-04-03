package com.airbike.utils;

import java.util.Set;

import com.airbike.model.Booking;
import com.airbike.model.User;

public class VehiculeJson {

    private Long id;


    private String color;
 
    private String mark;
 
    private String model;
 
    private String year;
 
    private String power;
 
    private String numberPlate;
 
    private String photo;
    
    private boolean deleted;
    
    private User user;
    
    private Set<Booking> bookings;

	public VehiculeJson() {};
	
	public VehiculeJson(
			String color, 
			String mark, 
			String model, 
			String year, 
			String power, 
			String numberPlate,
			String photo, 
			boolean deleted, 
			User user, 
			Set<Booking> bookings) {
		super();
		this.color = color;
		this.mark = mark;
		this.model = model;
		this.year = year;
		this.power = power;
		this.numberPlate = numberPlate;
		this.photo = photo;
		this.deleted = deleted;
		this.user = user;
		this.bookings = bookings;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the mark
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * @param mark the mark to set
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the power
	 */
	public String getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(String power) {
		this.power = power;
	}

	/**
	 * @return the numberPlate
	 */
	public String getNumberPlate() {
		return numberPlate;
	}

	/**
	 * @param numberPlate the numberPlate to set
	 */
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the bookings
	 */
	public Set<Booking> getBookings() {
		return bookings;
	}

	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
    
    
    

}
