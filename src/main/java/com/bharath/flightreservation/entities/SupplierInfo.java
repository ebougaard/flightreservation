package com.bharath.flightreservation.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "supplierInfo")
public class SupplierInfo {

    @Id
    @Column(name = "supplierId")
    private String supplierId;

    @Column(name = "Contact_Person")
    private String ContactPerson;

    @Column(name = "Supplier_Tell")
    private String tell;

    @Column(name = "Supplier_Cell")
    private String cell;

    @Column(name = "Supplier_Fax")
    private String fax;

    @Column(name = "Supplier_Email")
    private String email;

    @Column(name = "Bank")
    private String bank;

    @Column(name = "Bank_Code")
    private String branch;

    @Column(name = "Supplier_BankNum")
    private String accountNo;

    @Column(name = "Supplier_Typle_Bank_Account")
    private String accountType;

    @Column(name = "Comments")
    private String comments;

    @OneToMany(targetEntity=Supplements.class, mappedBy="supplierIfno",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SupplierInfo> supplierInfoList;


    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getContactPerson() {
        return ContactPerson;
    }

    public void setContactPerson(String contactPerson) {
        ContactPerson = contactPerson;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<SupplierInfo> getSupplierInfoList() {
        return supplierInfoList;
    }

    public void setSupplierInfoList(List<SupplierInfo> supplierInfoList) {
        this.supplierInfoList = supplierInfoList;
    }
}
