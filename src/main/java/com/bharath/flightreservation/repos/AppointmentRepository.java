package com.bharath.flightreservation.repos;

import com.bharath.flightreservation.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	@Query("from Appointment where dateOfAppointment=:dateOfAppointment")
	List<Appointment> findAppointments(
	        @Param("dateOfAppointment") Date departureDate);
}
