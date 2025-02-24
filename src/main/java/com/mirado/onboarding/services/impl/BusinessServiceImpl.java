package com.mirado.onboarding.services.impl;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.BusinessDto;
import com.mirado.onboarding.dto.CustomerDto;
import com.mirado.onboarding.dto.PurposeDto;
import com.mirado.onboarding.repositories.BusinessRepository;
import com.mirado.onboarding.repositories.PurposeRepository;
import com.mirado.onboarding.services.BusinessService;
import com.mirado.onboarding.services.PurposeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BusinessServiceImpl implements BusinessService {
    BusinessRepository businessRepository;

    @Override
    public BusinessDto findById(Integer id) {
        if (id == null) return null;
        return businessRepository.findById(id)
                .map(BusinessDto::fromEntity)
                .orElse(null);
    }

    @Override
    public ApiResponse findAll() {
        List<BusinessDto> businesses = businessRepository.findAll().stream()
                .map(BusinessDto::fromEntity)
                .toList();

        return ApiResponse.success(businesses, "List of businesses", HttpStatus.OK);
    }
}
