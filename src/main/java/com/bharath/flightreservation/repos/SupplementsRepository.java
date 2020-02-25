package com.bharath.flightreservation.repos;

import com.bharath.flightreservation.entities.Supplements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplementsRepository extends JpaRepository<Supplements, String> {
}
