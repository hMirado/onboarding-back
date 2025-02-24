package com.mirado.onboarding.services;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.CustomerDto;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CustomerService {
    ApiResponse save(CustomerDto value);
    ApiResponse findAll(Specification specification);
    ApiResponse findById(Integer id);
    ApiResponse update(Integer id, CustomerDto customerDto);
    ApiResponse validate(Integer id, Integer status);
}
