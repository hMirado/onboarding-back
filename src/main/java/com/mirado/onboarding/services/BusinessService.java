package com.mirado.onboarding.services;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.BusinessDto;

public interface BusinessService {
    BusinessDto findById(Integer id);
    ApiResponse findAll();
}
