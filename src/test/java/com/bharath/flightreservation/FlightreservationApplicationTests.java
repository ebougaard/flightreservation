package com.bharath.flightreservation;

import com.bharath.flightreservation.entities.AppointmentInfo;
import com.bharath.flightreservation.services.AppointmentInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bharath.flightreservation.entities.Reservation;
import com.bharath.flightreservation.repos.FlightRepository;
import com.bharath.flightreservation.repos.PassengerRepository;
import com.bharath.flightreservation.repos.ReservationRepository;
import com.bharath.flightreservation.util.EmailUtil;
import com.bharath.flightreservation.util.PDFGenerator;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightreservationApplicationTests {

	@Autowired
	PassengerRepository repo;

	@Autowired
	FlightRepository flightRepo;

	@Autowired
	ReservationRepository reservationRepo;

	@Autowired
	AppointmentInfoService appointmentInfoService;

	@Autowired
	EmailUtil emailUtil;

	//@Test
	public void contextLoads() {
	}

	@Test
	public void testGenerateItenarary() {
		List<AppointmentInfo> appointmentInfoList = appointmentInfoService.getAllAppointmenInfo();
		System.out.println(appointmentInfoList);
	}

	//@Test
	public void testEmail() {
		Reservation reservation = reservationRepo.findOne(1L);
		String filePath = "/Users/ebougaard/Documents/reservations/reservation" + reservation.getId() + ".pdf";
		emailUtil.sendItinerary("thippireddy.bharath@gmail.com", filePath);
	}

}
