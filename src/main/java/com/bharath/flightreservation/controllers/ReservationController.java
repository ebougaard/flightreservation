package com.bharath.flightreservation.controllers;

import com.bharath.flightreservation.entities.*;
import com.bharath.flightreservation.repos.*;
import com.bharath.flightreservation.services.AppointmentDataService;
import com.bharath.flightreservation.services.AppointmentInfoService;
import com.bharath.flightreservation.services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bharath.flightreservation.services.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ReservationController {

Date appDate = new Date();

String Dates;

	@Autowired
	AppointmentDataService appointmentDataService;

	@Autowired
	AppointmentInfoRepository appointmentInfoRepository;

	@Autowired
	AppointmentInfoService appointmentInfoService;

	@Autowired
	AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentDataRepository appointmentDataRepository;

	@Autowired
	ReservationService reservationService;

	@Autowired
	ClientService clientService;

	@Autowired
	PassengerRepository passengerRepository;
	private int tempId;
	Appointment_data appointment =null;

	public int getTempId() {
		return tempId;
	}

	public void setTempId(int tempId) {
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

	@RequestMapping("findAppointment")
	public String findAppointment(@RequestParam("appointmentDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date appointmentDate,
								  ModelMap modelMap) {




		Dates = appointmentDate.toString();

/*		LOGGER.info("Inside findAppointment() from" + "Appointment Date: " + appointmentDate);
		Appointment appointment = new Appointment();
		appointment.setLocation("45456");
		appointment.setCompany("Test");
		appointment.setDateOfAppointment(new Date());
		//appointmentRepository.save(appointment);
		List<Appointment> appointments = appointmentRepository.findAll();*/

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
		modelMap.addAttribute("appointmentDate", appDate);
		LOGGER.info("Appointment Found are:" + appointment_data);
		return "AppointmentSearch";

	}



	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("appointmentId") int appointmentId, ModelMap modelMap) {
		LOGGER.info("showCompleteReservation() invoked with the Appointment Id: " + appointmentId);
		appointment = appointmentDataRepository.findOne(appointmentId);
		setTempId(appointmentId);
		modelMap.addAttribute("", appointment);
		LOGGER.info("Appointment is:" + appointment);
		return "completeReservation";

	}




	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(@ModelAttribute("passenger") Passenger passenger, Appointment_data appointmentData, AppointmentInfo appointmentInfo, ModelMap modelMap ) {
		System.out.println(passenger.getIdNumber());


		LocalDate date2 =  LocalDate.now().plusDays(7);






		List <ClientData> clientDataList =  clientService.getAllClients();
			Reservation reservation = reservationService.bookAppointment(passenger);


			ClientData clientData = clientService.getClientById(passenger.getIdNumber());
			if (clientData == null) {
				ClientData clientData1 = clientService.addClinet(passenger);
			}
			ClientData clientData1 = clientService.getClientById(passenger.getIdNumber());
		appointment = appointmentDataRepository.findOne(appointment.getAppontments_id());



		//add data into appointment table
		AppointmentInfo appointmentInfo1 = new AppointmentInfo();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");

Date selected  = new Date();

		formatter.format(selected);
	//	formatter.format(date2);






		appointmentInfo1.setAppointmentDate(selected);
		appointmentInfo1.setClientData(clientData1);
		appointmentInfo1.setAppointment_data(appointment);
		AppointmentInfo saveApp = appointmentInfoRepository.save(appointmentInfo1);

		modelMap.addAttribute("appDate", appDate);
		modelMap.addAttribute("appointmentDate", appDate);
		modelMap.addAttribute("msg", "Thank you," + passenger.getFirstName());
		modelMap.addAttribute("msg1", "Your appointment was successfully created" );
		return "reservationConfirmation";

	}

}
