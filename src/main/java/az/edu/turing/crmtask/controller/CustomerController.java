package az.edu.turing.crmtask.controller;

import az.edu.turing.crmtask.dto.request.CustomerRequest;
import az.edu.turing.crmtask.dto.response.CustomerResponse;
import az.edu.turing.crmtask.service.CustomerServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceInter customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponse>> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest request) {
        return customerService.createCustomer(request);
    }

}
