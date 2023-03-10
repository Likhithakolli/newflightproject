package com.flightbooking.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="booking")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Booking implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_Id")
	private long bookingId;
	
	@Column(name="passenger_name", nullable=false)
	private String passengerName ;
	
	@Column(name="number_of_seats")
	private int numberOfSeats;
	
	@Column(name="travel_date")
	private Date travelDate;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="passport_number")
	private String passportNumber;
	
	@Column(name="passenger_mobile")
	private long passengerMobile;
	
	@ManyToOne 
	@JoinColumn(name="flight_id")
	private Flight flight;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties({"userId", "password","dob"})
	private User user;
	
	@OneToMany(mappedBy="bookings")
	@JsonIgnoreProperties({"tickets"})
	private List<Ticket> tickets;

}
