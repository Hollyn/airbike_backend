package com.airbike.utils;

public class ErrorException {
	
	private int error;
	private String message = "";
	
	public ErrorException(int code, String message) {
		this.message = message;
		error = code;
	}
	
	
	/**
	 * @return the error
	 */
	public int getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(int error) {
		this.error = error;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


}
