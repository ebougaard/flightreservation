package com.bharath.flightreservation.repos;

import com.bharath.flightreservation.entities.AppointmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentInfoRepository extends JpaRepository<AppointmentInfo, Long> {


}
