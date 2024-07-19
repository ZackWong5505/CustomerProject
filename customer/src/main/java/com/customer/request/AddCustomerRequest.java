package com.customer.request;

import java.time.LocalDate;

public class AddCustomerRequest {

    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String contactNo;

    public AddCustomerRequest(String name, LocalDate dateOfBirth, String address, String contactNo) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
