package com.airbike.message.request;

import javax.validation.constraints.*;

public class VehiculeForm {
    private String color;
    
    private String mark;
   
    private String model;
    
    private String power;

    private String picture;

    private String description;

    private String daily_price;
    
    @NotBlank
    @Size(min = 3, max = 50)
    private String numberplate;
    
    private String year;
    
    //@NotBlank
    //@Size(min = 1, max = 50)
    private long userId;

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
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * @return the numberplate
	 */
	public String getNumberplate() {
		return numberplate;
	}

	/**
	 * @param numberplate the numberplate to set
	 */
	public void setNumberplate(String numberplate) {
		this.numberplate = numberplate;
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
	 * @return the user_id
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the daily_price
	 */
	public String getDaily_price() {
		return daily_price;
	}

	/**
	 * @param daily_price the daily_price to set
	 */
	public void setDaily_price(String daily_price) {
		this.daily_price = daily_price;
	}
	    
	
}