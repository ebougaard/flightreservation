package com.bharath.flightreservation.repos;

import com.bharath.flightreservation.entities.ClientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDataRepository extends JpaRepository<ClientData,Long>{
}
