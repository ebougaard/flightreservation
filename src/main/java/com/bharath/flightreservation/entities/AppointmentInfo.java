package com.bharath.flightreservation.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointment_infos")
public class AppointmentInfo {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;

    @Column(name = "Appointment_Date")
    private Date appointmentDate;


   // @JoinColumn(name = "Client_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private ClientData clientData;

    //@JoinColumn(name = "appontments_id", nullable = false)
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="appontments_id")
    private Appointment_data appointment_data;

    @Override
    public String toString() {
        return "AppointmentInfo{" +
                "appointmentDate=" + appointmentDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
