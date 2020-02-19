package com.bharath.flightreservation.services;


import com.bharath.flightreservation.entities.Appointment_data;
import com.bharath.flightreservation.repos.AppointmentDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsDataServiceImpl implements AppointmentDataService {





	@Autowired
	private AppointmentDataRepository repository;

	@Override
	public Appointment_data saveAppointmentData (Appointment_data appointmentData) {
		return repository.save(appointmentData);
	}

	@Override
	public Appointment_data updateAppointmentData (Appointment_data appointmentData) {
		return repository.save(appointmentData);
	}

	@Override
	public void deleteAppointmentData (Appointment_data appointmentData) {
		repository.delete(appointmentData);
	}

	@Override
	public Appointment_data getAppointmenDataById(long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Appointment_data> getAllAppointmenData() {
		return repository.findAll();
	}


	public void setRepository(AppointmentDataRepository repository) {
		this.repository = repository;
	}

}
