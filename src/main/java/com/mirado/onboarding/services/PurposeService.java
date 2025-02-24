package com.mirado.onboarding.services;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.PurposeDto;

public interface PurposeService {
    PurposeDto findById(Integer id);
    ApiResponse findAll();
}
