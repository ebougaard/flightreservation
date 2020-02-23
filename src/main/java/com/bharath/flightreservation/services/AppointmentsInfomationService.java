package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.Appointment;
import com.bharath.flightreservation.entities.AppointmentInfo;
import com.bharath.flightreservation.repos.AppointmentInfoRepository;
import com.bharath.flightreservation.repos.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentsInfomationService {

    private final AppointmentInfoRepository appointmentInfoRepository;

    @Autowired
    public AppointmentsInfomationService(AppointmentInfoRepository appointmentInfoRepository) {
        this.appointmentInfoRepository = appointmentInfoRepository;
    }

    public List<AppointmentInfo> appointmentInfos(Date appointmentDate){
       return appointmentInfoRepository.findAppointmentInfo(appointmentDate);
    }
}
