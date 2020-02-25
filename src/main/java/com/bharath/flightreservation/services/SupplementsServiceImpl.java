package com.bharath.flightreservation.services;

import com.bharath.flightreservation.entities.Supplements;
import com.bharath.flightreservation.repos.SupplementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplementsServiceImpl implements SupplementsService {





	@Autowired
	private SupplementsRepository repository;

	@Override
	public Supplements saveSupplement (Supplements supplements) {
		return repository.save(supplements);
	}

	@Override
	public Supplements updateSupplements (Supplements supplements) {
		return repository.save(supplements);
	}

	@Override
	public void deleteSupplements(Supplements supplements) {
		repository.delete(supplements);
	}

	@Override
	public Supplements getSupplementById(String id) {
		return repository.findOne(id);
	}


	@Override
	public List<Supplements> getAllSupplements() {
		return repository.findAll();
	}


	public void setRepository(SupplementsRepository repository) {
		this.repository = repository;
	}

}
