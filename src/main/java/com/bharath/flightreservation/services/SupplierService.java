package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.SupplierInfo;

import java.util.List;

public interface SupplierService {

	SupplierInfo saveSupplier(SupplierInfo supplierIfno);

	SupplierInfo updateSupplier(SupplierInfo supplierIfno);

	void deleteSupplier(SupplierInfo supplierIfno);

	SupplierInfo getSupplierById(long id);

	List<SupplierInfo> getAllSuppliers();
}
