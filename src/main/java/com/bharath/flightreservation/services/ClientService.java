package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.ClientData;

import java.util.List;

public interface ClientService {

	ClientData saveClient(ClientData clientData);

	ClientData updateClient(ClientData clientData);

	void deleteClient(ClientData clientData);

	ClientData getClientById(long id);

	List<ClientData> getAllClients();
}
