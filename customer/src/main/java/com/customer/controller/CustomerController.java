package com.customer.controller;

import com.customer.modal.CustomerDTO;
import com.customer.request.AddCustomerRequest;
import com.customer.request.DeleteCustomerRequest;
import com.customer.request.UpdateCustomerRequest;
import com.customer.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value="/customer/detail/{name}")
    public CustomerDTO getCustomerDetail (@PathVariable("name") String name){

        return customerService.getCustomerDetail(name);
    }

    @PostMapping(value="/customer/add")
    public void doAddCustomer(@RequestBody AddCustomerRequest addCustomerRequest){

        customerService.doAddCustomer(addCustomerRequest);
    }

    @PostMapping(value="/customer/update")
    public void doUpdateCustomer(@RequestBody UpdateCustomerRequest updateCustomerRequest){

        customerService.updateCustomer(updateCustomerRequest);
    }

    @PostMapping(value="/customer/delete")
    public void doDeleteCustomer(@RequestBody DeleteCustomerRequest deleteCustomerRequest){

        customerService.deleteCustomer(deleteCustomerRequest);
    }

    @GetMapping("/external")
    public String getExternalData() throws JsonProcessingException {
        return customerService.getExternalData();
    }

}
