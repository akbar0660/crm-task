package az.edu.turing.crmtask.service;

import az.edu.turing.crmtask.dao.domain.Customer;
import az.edu.turing.crmtask.dao.repository.CustomerRepository;
import az.edu.turing.crmtask.dto.request.CustomerRequest;
import az.edu.turing.crmtask.dto.response.CustomerResponse;
import az.edu.turing.crmtask.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerServiceInter {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper = CustomerMapper.customerMapper;

    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customers) {
            customerResponses.add(customerMapper.entityToResponse(customer));
        }
        return ResponseEntity.ok(customerResponses);
    }

    public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest request) {
        if (request == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(customerMapper.entityToResponse(customerRepository.save(customerMapper.requestToEntity(request))));
    }

}
