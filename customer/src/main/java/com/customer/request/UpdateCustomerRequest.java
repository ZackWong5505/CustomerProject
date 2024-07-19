package com.customer.request;

import java.time.LocalDate;

public class UpdateCustomerRequest {

    private String name;
    private String address;
    private String contactNo;

    public UpdateCustomerRequest(String name, String contactNo, String address) {
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
