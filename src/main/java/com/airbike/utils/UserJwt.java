package com.airbike.utils;


import com.airbike.message.response.JwtResponse;
import com.airbike.model.User;

public class UserJwt {
	
	private User user;

	private JwtResponse jwt;
	
	public UserJwt(User optional, JwtResponse jwt) {
		user = optional;
		this.jwt = jwt;
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
	 * @return the mJwt
	 */
	public JwtResponse getJwt() {
		return jwt;
	}

	/**
	 * @param mJwt the mJwt to set
	 */
	public void setJwt(JwtResponse jwt) {
		this.jwt = jwt;
	}

}
