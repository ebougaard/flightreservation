package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.Appointment;
import com.bharath.flightreservation.repos.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> appointments(Date dateOfAppointment){
       return appointmentRepository.findAppointments(dateOfAppointment);
    }
}
