package com.mirado.onboarding.services;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.EntityTypeDto;

public interface EntityTypeService {
    EntityTypeDto findById(Integer id);
    ApiResponse findAll();
}
