package com.bharath.flightreservation.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment extends AbstractEntity{

	@Column(name = "location_number")
	private String locationNumber;

	private String company;

	private String location;

	@Column(name = "date_of_appointment")
	private Date dateOfAppointment;

	private String time;

	@Column(name = "estimated_departure_time")
	private Timestamp estimatedDepartureTime;

	@OneToOne(mappedBy = "appointment",cascade = CascadeType.ALL)
	private Reservation reservation;

	public String getLocationNumber() {
		return locationNumber;
	}

	public void setLocationNumber(String locationNumber) {
		this.locationNumber = locationNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Appointment{" +
			//	"id=" + id +
				", locationNumber='" + locationNumber + '\'' +
				", company='" + company + '\'' +
				", location='" + location + '\'' +
				", dateOfAppointment=" + dateOfAppointment +
				", time='" + time + '\'' +
				", estimatedDepartureTime=" + estimatedDepartureTime +
				'}';
	}

	public Date getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(Date dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
/*
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}
