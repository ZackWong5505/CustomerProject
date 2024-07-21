package com.customer.service;

import com.customer.entity.Customer;
import com.customer.modal.CustomerDTO;
import com.customer.repository.CustomerRepository;
import com.customer.request.AddCustomerRequest;
import com.customer.request.DeleteCustomerRequest;
import com.customer.request.UpdateCustomerRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    private final ObjectMapper objectMapper = new ObjectMapper();

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

    public String getExternalData() throws JsonProcessingException {
        String url = "https://api.agify.io?name=meelad"; // Example 3rd party API

        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer your_token");
        headers.add("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            Object json = objectMapper.readValue(response.getBody(), Object.class);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

        } else {
            throw new RuntimeException("Failed to get data from external API");
        }
    }

    @Scheduled(fixedRate = 10000) // 10 seconds
    public void scheduledTask() throws JsonProcessingException {
        String data = getExternalData();
        System.out.println("Fetched Data: " + data);
    }

}
