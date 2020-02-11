package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.Appointment;


import java.util.List;

public interface AppointmentsService {

	Appointment saveAppointment(Appointment appointment);

	Appointment updateAppointments(Appointment appointment);

	void deleteAppointment(Appointment appointment);

	Appointment getAppointmentById(long id);

	List<Appointment> getAllAppointment();
}
