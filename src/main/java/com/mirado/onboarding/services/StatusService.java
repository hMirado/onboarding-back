package com.mirado.onboarding.services;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.BusinessDto;
import com.mirado.onboarding.dto.StatusDto;

public interface StatusService {
    StatusDto findById(Integer id);
    ApiResponse findAll();
}
