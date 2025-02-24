package com.mirado.onboarding.controllers;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.CustomerDto;
import com.mirado.onboarding.models.Customer;
import com.mirado.onboarding.requests.StatusRequest;
import com.mirado.onboarding.services.CustomerService;
import com.mirado.onboarding.specifications.CustomerSpec;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/onboarding")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CustomerDto>> save(@RequestBody CustomerDto customerDto) {
        ApiResponse<CustomerDto> response = customerService.save(customerDto);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<CustomerDto>> list() {
        Specification<Customer> specification = new CustomerSpec();
        ApiResponse response = customerService.findAll(specification);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerDto>> findById(@PathVariable("id") Integer id) {
        ApiResponse response = customerService.findById(id);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerDto>> update(@PathVariable("id") Integer id, @RequestBody CustomerDto customerDto) {
        ApiResponse response = customerService.update(id, customerDto);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping("/validate/{id}")
    public ResponseEntity<ApiResponse<CustomerDto>> validate(@PathVariable("id") Integer id, @RequestBody StatusRequest statusRequest) {
        ApiResponse response = customerService.validate(id, statusRequest.getStatus());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
