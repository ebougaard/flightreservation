package com.bharath.flightreservation.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Appointment_data {

    @Id
    @Column(name = "appontments_id")
    private int appontments_id;

    @Column(name = "appointment_description")
    private Date appointmentDescription;


    public int getAppontments_id() {
        return appontments_id;
    }

    public void setAppontments_id(int appontments_id) {
        this.appontments_id = appontments_id;
    }

    public Date getDateOfAppointment() {
        return appointmentDescription;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.appointmentDescription = dateOfAppointment;
    }
}
