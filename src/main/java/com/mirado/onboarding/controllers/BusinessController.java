package com.mirado.onboarding.controllers;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.BusinessDto;
import com.mirado.onboarding.dto.CustomerDto;
import com.mirado.onboarding.services.BusinessService;
import com.mirado.onboarding.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/onboarding/business")
public class BusinessController {
    private final BusinessService businessService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<BusinessDto>> list() {
        ApiResponse response = businessService.findAll();
        return new ResponseEntity<>(response, response.getStatus());
    }
}
