package com.airbike.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "BOOKINGS")
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Code", nullable = true)
	private String code;

	@Column(name = "Status", length = 10, nullable = true, columnDefinition="TINYINT default '0'")
	private int status;

	@Temporal(TemporalType.DATE)
    @Column(name = "Date_From", nullable = true)
    private Date dateFrom;

	@Temporal(TemporalType.DATE)
    @Column(name = "Date_To", nullable = true)
    private Date date_to;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date", nullable = true)
	private Date date;


	@Column(name = "deleted", columnDefinition="TINYINT default '0'")
    private boolean deleted;
    



@ManyToOne
@JoinColumn(name = "vehicule_id", nullable = false)
@OnDelete(action = OnDeleteAction.CASCADE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference(alwaysAsId = true)
//@JsonIgnore
private Vehicule vehicule;



@ManyToOne
@JoinColumn(name = "user_id", nullable = false)
@OnDelete(action = OnDeleteAction.CASCADE)
//@JsonIgnore
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIdentityReference(alwaysAsId = true)
private User user;




public Booking() {}

	public Booking(
			String code, 
			int status,
			Date dateFrom, 
			Date date_to, 
			Date date, 
			boolean deleted, 
			User user, 
			Vehicule vehicule) {
		super();
		this.code = code;
		this.status = status;
		this.dateFrom = dateFrom;
		this.date_to = date_to;
		this.date = date;
		this.deleted = deleted;
		this.user = user;
		this.vehicule = vehicule;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the dateFrom
	 */
	public String getDateFrom() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(dateFrom);
		return strDate;
	}

	/**
	 * @param dateFrom the dateFrom to set
	 */
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	/**
	 * @return the date_to
	 */
	public String getDate_to() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date_to);
		return strDate;
	}

	/**
	 * @param date_to the date_to to set
	 */
	public void setDate_to(Date date_to) {
		this.date_to = date_to;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		return strDate;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Booking [id=" + id + ", code=" + code + ", status=" + status + ", dateFrom=" + dateFrom + ", date_to="
				+ date_to + ", date=" + date + "]";
	}

	/**
	 * @return the vehicule
	 */@JsonProperty("vehicule_id")
	public Vehicule getVehicule() {
		return vehicule;
	}

	/**
	 * @param vehicule the vehicule to set
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

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
	
	
	


}
