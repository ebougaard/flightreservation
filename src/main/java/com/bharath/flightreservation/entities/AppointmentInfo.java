package com.bharath.flightreservation.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointment_infos")
public class AppointmentInfo extends AbstractEntity{


    @Column(name = "Appointment_Date")
    private Date appointmentDate;





   // @OneToOne(fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Client_id", nullable = false)
    private ClientData clientData;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appontments_id", nullable = false)
    private Appointment_data appointment_data;

    @Override
    public String toString() {
        return "AppointmentInfo{" +
                "appointmentDate=" + appointmentDate +
                '}';
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
