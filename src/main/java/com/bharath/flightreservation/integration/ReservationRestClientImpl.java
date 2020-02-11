package com.bharath.flightreservation.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bharath.flightreservation.integration.dto.Reservation;
import com.bharath.flightreservation.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {



	private static final String RESERVATION_REST_URL = "http://localhost:8090/reservations/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(id);
		System.out.println(RESERVATION_REST_URL);
		Reservation reservation = restTemplate
				.getForObject(RESERVATION_REST_URL + id, Reservation.class);
		System.out.println(reservation);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
		return reservation;
	}

}
