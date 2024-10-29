package az.edu.turing.crmtask.service;

import az.edu.turing.crmtask.dto.request.CustomerRequest;
import az.edu.turing.crmtask.dto.response.CustomerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerServiceInter {

    ResponseEntity<List<CustomerResponse>> getAllCustomers();

    ResponseEntity<CustomerResponse> createCustomer(CustomerRequest request);
}
