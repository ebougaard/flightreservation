package com.bharath.flightreservation.services;



import com.bharath.flightreservation.entities.AppointmentInfo;

import java.util.List;

public interface AppointmentInfoService {

	AppointmentInfo saveAppointmentInfo(AppointmentInfo appointmentInfo);

	AppointmentInfo updateAppointmentInfo(AppointmentInfo appointmentInfo);

	void deleteAppointmentInfo(AppointmentInfo appointmentInfo);

	AppointmentInfo getAppointmenInfoById(int id);

	List<AppointmentInfo> getAllAppointmenInfo();
}
