package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.Appointment;
import com.bharath.flightreservation.repos.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsServiceImpl implements AppointmentsService {





	@Autowired
	private AppointmentRepository repository;

	@Override
	public Appointment saveAppointment (Appointment appointment) {
		return repository.save(appointment);
	}

	@Override
	public Appointment updateAppointments (Appointment appointment) {
		return repository.save(appointment);
	}

	@Override
	public void deleteAppointment (Appointment appointment) {
		repository.delete(appointment);
	}

	@Override
	public Appointment getAppointmentById(int id) {
		return repository.findOne(id);
	}

	@Override
	public List<Appointment> getAllAppointment() {
		return repository.findAll();
	}


	public void setRepository(AppointmentRepository repository) {
		this.repository = repository;
	}

}
