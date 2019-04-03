package com.airbike.message.request;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

public class BookingForm {
//	@NotBlank
	@Temporal(TemporalType.DATE)
	@Size(min = 3, max = 50)
	private String dateFrom;

	@Temporal(TemporalType.DATE)
	@Size(min = 3, max = 50)
	private String dateTo;
	
	private long userId;
	
	private long vehiculeId;
	
	public BookingForm() {}

	/**
	 * @return the dateFrom
	 */
	public String getDateFrom() {
		return dateFrom;
	}

	/**
	 * @param dateFrom the dateFrom to set
	 */
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	/**
	 * @return the dateTo
	 */
	public String getDateTo() {
		return dateTo;
	}

	/**
	 * @param dateTo the dateTo to set
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the vehiculId
	 */
	public long getVehiculeId() {
		return vehiculeId;
	}

	/**
	 * @param vehiculId the vehiculId to set
	 */
	public void setVehiculeId(long vehiculeId) {
		this.vehiculeId = vehiculeId;
	}
}
