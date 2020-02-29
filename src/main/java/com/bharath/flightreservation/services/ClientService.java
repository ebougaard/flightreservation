package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.ClientData;
import com.bharath.flightreservation.entities.Passenger;

import java.util.List;

public interface ClientService {

	ClientData saveClient(ClientData clientData);

	ClientData updateClient(ClientData clientData);

	void deleteClient(ClientData clientData);

	ClientData getClientById(String id);

	List<ClientData> getAllClients();

	public ClientData addClinet(Passenger passenger);
}
