package com.customer.service;

import com.customer.modal.CustomerDTO;
import com.customer.request.AddCustomerRequest;
import com.customer.request.DeleteCustomerRequest;
import com.customer.request.UpdateCustomerRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CustomerService {
    public CustomerDTO getCustomerDetail(String name);
    public void doAddCustomer (AddCustomerRequest addCustomerRequest);
    public void updateCustomer(UpdateCustomerRequest updateCustomerRequest);
    public void deleteCustomer(DeleteCustomerRequest deleteCustomerRequest);
    public String getExternalData() throws JsonProcessingException;

}
