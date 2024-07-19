package com.customer.service;

import com.customer.entity.Customer;
import com.customer.modal.CustomerDTO;
import com.customer.repository.CustomerRepository;
import com.customer.request.AddCustomerRequest;
import com.customer.request.DeleteCustomerRequest;
import com.customer.request.UpdateCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
   public CustomerDTO getCustomerDetail(String name){

       Customer cust = customerRepository.findByName(name);

       return new CustomerDTO(cust.getId(), cust.getName(), cust.getDateOfBirth(),cust.getAddress(),cust.getContactNo());
   }

   @Override
   public void doAddCustomer (AddCustomerRequest addCustomerRequest){

       Customer cust = new Customer();
       cust.setId(UUID.randomUUID());
       cust.setAddress(addCustomerRequest.getAddress());
       cust.setContactNo(addCustomerRequest.getContactNo());
       cust.setName(addCustomerRequest.getName());
       cust.setDateOfBirth(addCustomerRequest.getDateOfBirth());

       customerRepository.saveAndFlush(cust);


   }

    @Override
    public void updateCustomer(UpdateCustomerRequest updateCustomerRequest) {

        Customer cust = customerRepository.findByName(updateCustomerRequest.getName());

        cust.setAddress(updateCustomerRequest.getAddress());
        cust.setContactNo(updateCustomerRequest.getContactNo());

        customerRepository.saveAndFlush(cust);

    }

    @Override
    public void deleteCustomer(DeleteCustomerRequest deleteCustomerRequest) {
        Customer cust = customerRepository.findByName(deleteCustomerRequest.getName());


        customerRepository.deleteById(cust.getId());
    }


}
