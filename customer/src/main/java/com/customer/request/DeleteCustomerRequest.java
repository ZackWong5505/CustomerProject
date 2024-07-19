package com.customer.request;

public class DeleteCustomerRequest {
    private String name;

    public DeleteCustomerRequest(String name) {
        this.name = name;
    }

    public DeleteCustomerRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
