package com.bharath.flightreservation.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class InvInfo {

    @Id
    @Column(name = "Inv_Num")
    private String invNum;

    @Column(name = "Inv_Date")
    private Date invDate;

    @OneToOne
    private ClientData clientData;

    @Column(name = "Inv_Consulation_Fee")
    private Double invConsulationFee;


    public String getInvNum() {
        return invNum;
    }

    public void setInvNum(String invNum) {
        this.invNum = invNum;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public ClientData getClientData() {
        return clientData;
    }

    public void setClientData(ClientData clientData) {
        this.clientData = clientData;
    }

    public Double getInvConsulationFee() {
        return invConsulationFee;
    }

    public void setInvConsulationFee(Double invConsulationFee) {
        this.invConsulationFee = invConsulationFee;
    }
}
