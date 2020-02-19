package com.bharath.flightreservation.repos;

import com.bharath.flightreservation.entities.SupplierInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierIfnoRepository extends JpaRepository<SupplierInfo, Long> {
}
