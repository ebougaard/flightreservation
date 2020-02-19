package com.bharath.flightreservation.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

public class AppointmentInfo {



    @Id
    @Column(name = "appontments_id")
    private int appontmentsId;

    @Column(name = "Appointment_Date")
    private Date appointmentDate;

    @OneToOne
    private ClientData clientData;

    @OneToOne
    private Appointment_data appointment_data;

    public int appontmentsId() {
        return appontmentsId;
    }

    public void appontmentsId(int appontments_id) {
        this.appontmentsId = appontments_id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public ClientData getClientData() {
        return clientData;
    }

    public void setClientData(ClientData clientData) {
        this.clientData = clientData;
    }

    public Appointment_data getAppointment_data() {
        return appointment_data;
    }

    public void setAppointment_data(Appointment_data appointment_data) {
        this.appointment_data = appointment_data;
    }
}
