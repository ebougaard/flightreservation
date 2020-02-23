package com.bharath.flightreservation.repos;


import com.bharath.flightreservation.entities.AppointmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentInfoRepository extends JpaRepository<AppointmentInfo, Integer> {

    @Query("from AppointmentInfo where appointmentDate=:appointmentDate")
    List<AppointmentInfo> findAppointmentInfo(
            @Param("appointmentDate") Date appDate);


}
