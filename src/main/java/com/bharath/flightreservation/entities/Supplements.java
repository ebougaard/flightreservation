package com.bharath.flightreservation.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supplements")
public class Supplements  {

    @Id
    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "Suppl_Description")
    private String description;

    @Column(name = "Cost_excl")
    private Double costExcVat;

    @Column(name = "Perc_inc")
    private String costIncVat;

    @Column(name = "Min_levels")
    private int minLevels;

    @Column(name = "Stock_levels")
    private int stockLevels;

    @Column(name = "Nappi_code")
    private String nappiCode;

  /*  @ManyToOne()
    @JoinColumn(name="supplier_id")*/
/*    @ManyToOne(optional=false)
    @JoinColumn(name="supplierId",referencedColumnName="supplier_id")*/

    @OneToOne
    @JoinColumn(name="supplier_id")
    private SupplierInfo supplierIfno;


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

    public Double getCostExcVat() {
        return costExcVat;
    }

    public void setCostExcVat(Double costExcVat) {
        this.costExcVat = costExcVat;
    }

    public String getCostIncVat() {
        return costIncVat;
    }

    public void setCostIncVat(String costIncVat) {
        this.costIncVat = costIncVat;
    }

    public int getMinLevels() {
        return minLevels;
    }

    public void setMinLevels(int minLevels) {
        this.minLevels = minLevels;
    }

    public int getStockLevels() {
        return stockLevels;
    }

    public void setStockLevels(int stockLevels) {
        this.stockLevels = stockLevels;
    }

    public String getNappiCode() {
        return nappiCode;
    }

    public void setNappiCode(String nappiCode) {
        this.nappiCode = nappiCode;
    }

    public SupplierInfo getSupplierIfno() {
        return supplierIfno;
    }

    public void setSupplierIfno(SupplierInfo supplierIfno) {
        this.supplierIfno = supplierIfno;
    }
}