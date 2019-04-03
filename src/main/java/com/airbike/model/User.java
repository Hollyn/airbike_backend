package com.airbike.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String firstname;

    @NotBlank
    @Size(min=3, max = 50)
    private String lastname;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;
    
    @Size(min=3, max = 50)
    private String phone;
    
    @Size(min=3, max = 50)
    private String country;
    
    @Size(min=3, max = 50)
    private String city;
    
    @Size(min=3, max = 50)
    private String address;

    /**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user_vehicules", 
//    	joinColumns = @JoinColumn(name = "user_id"), 
//    	inverseJoinColumns = @JoinColumn(name = "vehicule_id"))
//    private Set<Vehicule> vehicules = new HashSet<>();
//    
    

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "user_id")
//    private Set<Booking> bookings;

    public User() {}

    public User(
    		String firstname, 
    		String lastname, 
    		String username, 
    		String email, 
    		String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
    }


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\"User\": {\"id\":\"" + id + "\", "
				+ "\"firstname\":\"" + firstname + "\","
				+ "\"lastname\":\"" + lastname + "\","
				+ "\"username\":\"" + username + "\","
				+ "\"phone\":\"" + phone + "\", "
				+ "\"country\":\"" + country + "\","
				+ "\"city\":\"" + city + "\","
				+ "\"address\":\"" + address + "\","
				+ "\"email\":\"" + email + "\","
				+ "\"roles\":" + roles.toString() + "\","
//				+ "\"vehicules\":" + vehicules.toString()
				+ "}";
	}

	public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
//
//	/**
//	 * @return the vehicules
//	 */
//	public Set<Vehicule> getVehicules() {
//		return vehicules;
//	}
//
//	/**
//	 * @param vehicules the vehicules to set
//	 */
//	public void setVehicules(Set<Vehicule> vehicules) {
//		this.vehicules = vehicules;
//	}

//	/**
//	 * @return the bookings
//	 */
//	public Set<Booking> getBookings() {
//		return bookings;
//	}
//
//	/**
//	 * @param bookings the bookings to set
//	 */
//	public void setBookings(Set<Booking> bookings) {
//		this.bookings = bookings;
//	}
    
}