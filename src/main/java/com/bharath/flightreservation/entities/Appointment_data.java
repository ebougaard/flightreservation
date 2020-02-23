package com.bharath.flightreservation.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "appointment_data")
public class Appointment_data {

    @Id
    @Column(name = "appontments_id")
    private int appontments_id;

    @Column(name = "appointment_description")
    private String appointmentDescription;


    public int getAppontments_id() {
        return appontments_id;
    }

    public void setAppontments_id(int appontments_id) {
        this.appontments_id = appontments_id;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }
}
