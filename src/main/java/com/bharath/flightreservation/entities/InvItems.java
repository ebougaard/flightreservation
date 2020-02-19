package com.bharath.flightreservation.entities;

import javax.persistence.Column;
import javax.persistence.OneToOne;


public class InvItems {

    @OneToOne
    InvInfo invInfo;

    @OneToOne
    private SupplierIfno supplierIfno;

    @Column(name = "Item_Price")
    private Double itemPrice;

    @Column(name = "Item_Quantity")
    private int itemQuantity;

    public InvInfo getInvInfo() {
        return invInfo;
    }

    public void setInvInfo(InvInfo invInfo) {
        this.invInfo = invInfo;
    }

    public SupplierIfno getSupplierIfno() {
        return supplierIfno;
    }

    public void setSupplierIfno(SupplierIfno supplierIfno) {
        this.supplierIfno = supplierIfno;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
