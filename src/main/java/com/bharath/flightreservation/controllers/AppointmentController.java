package com.bharath.flightreservation.controllers;


import com.bharath.flightreservation.entities.Appointment;
import com.bharath.flightreservation.repos.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class AppointmentController {



	private final AppointmentRepository appointmentRepository;

	@Autowired
	public AppointmentController(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);

	@RequestMapping("findAppointments")
	public String findAppointments(@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
			ModelMap modelMap) {

		LOGGER.info("Inside findAppointments() from" + "Departure Date: " + departureDate);
		Appointment appointment = new Appointment();
		appointment.setLocation("45456");
		appointment.setCompany("Test");
		appointment.setDateOfAppointment(new Date());
		//appointmentRepository.save(appointment);
		List<Appointment> appointments = appointmentRepository.findAll();
		modelMap.addAttribute("appointments", appointments);
		LOGGER.info("Appointment Found are:" + appointments);
		return "displayAppointments";

	}

	@RequestMapping("admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
	}

}
