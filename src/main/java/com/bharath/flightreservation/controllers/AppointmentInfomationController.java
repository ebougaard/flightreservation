package com.bharath.flightreservation.controllers;


import com.bharath.flightreservation.entities.Appointment;
import com.bharath.flightreservation.entities.AppointmentInfo;
import com.bharath.flightreservation.repos.AppointmentInfoRepository;
import com.bharath.flightreservation.repos.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class AppointmentInfomationController {



	private final AppointmentInfoRepository appointmentInfoRepository;

	@Autowired
	public AppointmentInfomationController(AppointmentInfoRepository appointmentInfoRepository) {
		this.appointmentInfoRepository = appointmentInfoRepository;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentInfomationController.class);

	@RequestMapping("/admin/findSearchAppointments")
	public String findSearchAppointments(@RequestParam("appDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date appDate,
			ModelMap modelMap) {

		LOGGER.info("Inside findAppointments() from" + "Appointment Date: " + appDate);
		AppointmentInfo appointment = new AppointmentInfo();
		appointment.setAppointmentDate(new Date());
		//appointmentRepository.save(appointment);
		List<AppointmentInfo> appointments = appointmentInfoRepository.findAppointmentInfo(appDate);
       // List<AppointmentInfo> appointmentsl = appointmentInfoRepository.findAll();
			modelMap.addAttribute("appointments", appointments);
		LOGGER.info("Appointment Found are:" + appointments);
		return "displayAppointmentReport";

	}


}
