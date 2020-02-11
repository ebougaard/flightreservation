package com.bharath.flightreservation.entities;

import javax.persistence.*;

@Entity
@Table(name = "Supplements")
public class Supplements extends AbstractEntity {

    @Column(name = "supplierId")
    private String supplierId;

    @Column(name = "description")
    private String description;

    @Column(name = "costExcVat")
    private String costExcVat;

    @Column(name = "costIncVat")
    private String costIncVat;

    @Column(name = "percInc")
    private String percInc;

    @Column(name = "costClient")
    private String costClient;


    @OneToOne
    private SupplierIfno supplierIfno;


    @Column(name = "minLevels")
    private String minLevels;

    @Column(name = "stockLevels")
    private String stockLevels;

    @Column(name = "nappiCode")
    private String nappiCode;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCostExcVat() {
        return costExcVat;
    }

    public void setCostExcVat(String costExcVat) {
        this.costExcVat = costExcVat;
    }

    public String getCostIncVat() {
        return costIncVat;
    }

    public void setCostIncVat(String costIncVat) {
        this.costIncVat = costIncVat;
    }

    public String getPercInc() {
        return percInc;
    }

    public void setPercInc(String percInc) {
        this.percInc = percInc;
    }

    public String getCostClient() {
        return costClient;
    }

    public void setCostClient(String costClient) {
        this.costClient = costClient;
    }

    public SupplierIfno getSupplierIfno() {
        return supplierIfno;
    }

    public void setSupplierIfno(SupplierIfno supplierIfno) {
        this.supplierIfno = supplierIfno;
    }

    public String getMinLevels() {
        return minLevels;
    }

    public void setMinLevels(String minLevels) {
        this.minLevels = minLevels;
    }

    public String getStockLevels() {
        return stockLevels;
    }

    public void setStockLevels(String stockLevels) {
        this.stockLevels = stockLevels;
    }

    public String getNappiCode() {
        return nappiCode;
    }

    public void setNappiCode(String nappiCode) {
        this.nappiCode = nappiCode;
    }
}