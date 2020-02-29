package com.bharath.flightreservation.controllers;


import com.bharath.flightreservation.entities.Appointment;
import com.bharath.flightreservation.entities.AppointmentInfo;
import com.bharath.flightreservation.entities.Appointment_data;
import com.bharath.flightreservation.repos.AppointmentRepository;
import com.bharath.flightreservation.services.AppointmentDataService;
import com.bharath.flightreservation.services.AppointmentInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class AppointmentController {

	Date appointmentDate;

	@Autowired
	private final AppointmentRepository appointmentRepository;

	@Autowired
	public AppointmentController(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}

	@Autowired
	AppointmentInfoService appointmentInfoService;

	@Autowired
	AppointmentDataService appointmentDataService;

	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);
/*
	@RequestMapping("findAppointments")
	public String findAppointments(@RequestParam("departureDate") @DateTimeFormat(pattern = "YYYY-MM-dd") Date departureDate,
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

	}*/
//Here
/*
	@RequestMapping("findAppointment")
	public String findAppointment(@RequestParam("appointmentDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date appointmentDate,
								   ModelMap modelMap) {

*//*		LOGGER.info("Inside findAppointment() from" + "Appointment Date: " + appointmentDate);
		Appointment appointment = new Appointment();
		appointment.setLocation("45456");
		appointment.setCompany("Test");
		appointment.setDateOfAppointment(new Date());
		//appointmentRepository.save(appointment);
		List<Appointment> appointments = appointmentRepository.findAll();*//*

		List <Appointment_data> appointment_data = appointmentDataService.getAllAppointmenData();
		List<Appointment> appointmentList = new ArrayList<>();

		List <AppointmentInfo> appointmentInfoList = appointmentInfoService.getAllAppointmenInfo();
	//	for (Appointment_data appointment_data1: appointment_data) {
	//	for (Appointment_data appointmentData: appointment_data) {
			for (AppointmentInfo appointmentInfo : appointmentInfoList) {
				if (appointmentDate.equals(appointmentInfo.getAppointmentDate())) {
					appointment_data.remove(appointmentInfo.getAppointment_data());
					System.out.println(appointmentInfo.getAppointmentDate());
						}
				}

		modelMap.addAttribute("appointment_data", appointment_data);
		modelMap.addAttribute("appointmentDate", appointmentDate);
		LOGGER.info("Appointment Found are:" + appointment_data);
		return "AppointmentSearch";

	}*/

	@RequestMapping("admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
	}

}
