package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.ClientData;
import com.bharath.flightreservation.entities.SupplierIfno;

import java.util.List;

public interface SupplierService {

	SupplierIfno saveSupplier(SupplierIfno supplierIfno);

	SupplierIfno updateSupplier(SupplierIfno supplierIfno);

	void deleteSupplier(SupplierIfno supplierIfno);

	SupplierIfno getSupplierById(long id);

	List<SupplierIfno> getAllSuppliers();
}
