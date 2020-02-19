package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.SupplierInfo;
import com.bharath.flightreservation.repos.SupplierIfnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {





	@Autowired
	private SupplierIfnoRepository repository;

	@Override
	public SupplierInfo saveSupplier(SupplierInfo supplierIfno) {
		return repository.save(supplierIfno);
	}

	@Override
	public SupplierInfo updateSupplier (SupplierInfo supplierIfno) {
		return repository.save(supplierIfno);
	}

	@Override
	public void deleteSupplier(SupplierInfo supplierIfno) {
		repository.delete(supplierIfno);
	}

	@Override
	public SupplierInfo getSupplierById(long id) {
		return repository.findOne(id);
	}

	@Override
	public List<SupplierInfo> getAllSuppliers() {
		return repository.findAll();
	}


	public void setRepository(SupplierIfnoRepository repository) {
		this.repository = repository;
	}

}
