package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.SupplierIfno;
import com.bharath.flightreservation.repos.SupplierIfnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {





	@Autowired
	private SupplierIfnoRepository repository;

	@Override
	public SupplierIfno saveSupplier(SupplierIfno supplierIfno) {
		return repository.save(supplierIfno);
	}

	@Override
	public SupplierIfno updateSupplier (SupplierIfno supplierIfno) {
		return repository.save(supplierIfno);
	}

	@Override
	public void deleteSupplier(SupplierIfno supplierIfno) {
		repository.delete(supplierIfno);
	}

	@Override
	public SupplierIfno getSupplierById(long id) {
		return repository.findOne(id);
	}

	@Override
	public List<SupplierIfno> getAllSuppliers() {
		return repository.findAll();
	}


	public void setRepository(SupplierIfnoRepository repository) {
		this.repository = repository;
	}

}
