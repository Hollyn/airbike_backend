package com.airbike.model;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

 
@Entity
@Table(name = "Vehicules")
public class Vehicule {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "vehicule_id")
    private Long id;
 
    @Column(name = "Color", length = 128, nullable = false)
    private String color;
 
    @Column(name = "mark", length = 128, nullable = false)
    private String mark;
 
    @Column(name = "Model", length = 128, nullable = false)
    private String model;
 
    @Column(name = "Year", length = 128, nullable = false)
    private String year;
 
    @Column(name = "Power", length = 128, nullable = false)
    private String power;
 
    @Column(name = "Number_Plate", length = 128, nullable = false)
    private String numberPlate;

    @Column(name = "Photo", length = 128, nullable = false)
    private String photo;
    
    @Column(name = "Daily_Price", length = 128)
    private String daily_price;
    
    @Column(name = "Description")
    private String description;
    
    @Column(name = "deleted",  columnDefinition="TINYINT default '0'")
    private boolean deleted;
    
    
    

public Vehicule(
		String color, 
		String mark,
		String model, 
		String year, 
		String power, 
		String numberPlate,
		String photo,
		String daily_price,
		String description,
		User user) {
		super();
		this.color = color;
		this.mark = mark;
		this.model = model;
		this.year = year;
		this.power = power;
		this.numberPlate = numberPlate;
		this.daily_price = daily_price;
		this.description = description;
		this.photo = photo;
		this.user = user;
	}

public Vehicule() {}
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private User user;
    
    
    


	/**
	 * @return the user
	 */
    @JsonProperty("user_id")
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", color=" + color + ", mark=" + mark + ", model=" + model + ", year=" + year
				+ ", power=" + power + ", numberPlate=" + numberPlate + "]";
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
}
