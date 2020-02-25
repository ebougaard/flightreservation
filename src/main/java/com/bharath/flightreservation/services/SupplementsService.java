package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.Supplements;

import java.util.List;

public interface SupplementsService {

	Supplements saveSupplement (Supplements supplements);

	Supplements updateSupplements(Supplements supplements);

	void deleteSupplements(Supplements supplements);

	Supplements getSupplementById(String id);

	List<Supplements> getAllSupplements();
}
