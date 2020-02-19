package com.bharath.flightreservation.repos;


import com.bharath.flightreservation.entities.Appointment_data;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface AppointmentDataRepository extends JpaRepository<Appointment_data, Long> {


}
