package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.Appointment_data;

import java.util.List;

public interface AppointmentDataService {

	Appointment_data saveAppointmentData(Appointment_data appointmentData);

	Appointment_data updateAppointmentData(Appointment_data appointmentData);

	void deleteAppointmentData(Appointment_data appointmentData);

	Appointment_data getAppointmenDataById(int id);

	List<Appointment_data> getAllAppointmenData();
}
