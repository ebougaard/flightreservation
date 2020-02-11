package com.bharath.flightreservation.integration;

import com.bharath.flightreservation.integration.dto.Reservation;
import com.bharath.flightreservation.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);

}
