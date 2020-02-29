package com.bharath.flightreservation.services;



import com.bharath.flightreservation.entities.AppointmentInfo;
import com.bharath.flightreservation.repos.AppointmentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentsInfoServiceImpl implements AppointmentInfoService {





	@Autowired
	private AppointmentInfoRepository repository;

	@Override
	public AppointmentInfo saveAppointmentInfo (AppointmentInfo appointmentInfo) {
		return repository.save(appointmentInfo);
	}

	@Override
	public AppointmentInfo updateAppointmentInfo (AppointmentInfo appointmentInfo) {
		return repository.save(appointmentInfo);
	}

	@Override
	public void deleteAppointmentInfo (AppointmentInfo appointmentInfo) {
		repository.delete(appointmentInfo);
	}

	@Override
	public AppointmentInfo getAppointmenInfoById(int id) {
		return repository.findOne(id);
	}

	@Override
	public List<AppointmentInfo> getAllAppointmenInfo() {
		return repository.findAll();
	}


	public void setRepository(AppointmentInfoRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<AppointmentInfo> getAppointmentDatesByDateRange(Date fromDate, Date toDate) {
		return repository.findAppointmentDatesByDateRange(fromDate,toDate);
	}
}
