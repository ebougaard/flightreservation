package com.bharath.flightreservation.repos;

import com.bharath.flightreservation.entities.AppointmentInfo;
import com.bharath.flightreservation.entities.Supplements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SupplementsRepository extends JpaRepository<Supplements, String> {

    @Query("from Supplements where minLevels >=stockLevels")
    List<Supplements> findSupplementsLevels();
}
