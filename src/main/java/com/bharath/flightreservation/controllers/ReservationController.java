package com.bharath.flightreservation.controllers;

import com.bharath.flightreservation.entities.Appointment;
import com.bharath.flightreservation.entities.Passenger;
import com.bharath.flightreservation.repos.AppointmentRepository;
import com.bharath.flightreservation.repos.PassengerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bharath.flightreservation.dto.ReservationRequest;
import com.bharath.flightreservation.entities.Flight;
import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.repos.FlightRepository;
import com.bharath.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

/*	@Autowired
	FlightRepository flightRepository;*/

	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	ReservationService reservationService;

	@Autowired
	PassengerRepository passengerRepository;
	private Long tempId;
	Appointment appointment =null;

	public Long getTempId() {
		return tempId;
	}

	public void setTempId(Long tempId) {
		this.tempId = tempId;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
/*
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("appointmentId") Long appointmentId, ModelMap modelMap) {
		LOGGER.info("showCompleteReservation() invoked with the Flight Id: " + appointmentId);
		Flight flight = flightRepository.findOne(appointmentId);
		modelMap.addAttribute("", flight);
		LOGGER.info("Flight is:" + flight);
		return "completeReservation";

	}*/

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("appointmentId") Long appointmentId, ModelMap modelMap) {
		LOGGER.info("showCompleteReservation() invoked with the Appointment Id: " + appointmentId);
		appointment = appointmentRepository.findOne(appointmentId);
		setTempId(appointmentId);
		modelMap.addAttribute("", appointment);
		LOGGER.info("Appointment is:" + appointment);
		return "completeReservation";

	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("completeReservation()  " + request);
		request.setappointmentId(this.getTempId());


//		reservationService.save(request);
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Appointment successfully created, Appointment ID " + reservation.getId());
		return "reservationConfirmation";

	}

}
