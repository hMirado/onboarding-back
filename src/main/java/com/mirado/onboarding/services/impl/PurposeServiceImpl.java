package com.mirado.onboarding.services.impl;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.EntityTypeDto;
import com.mirado.onboarding.dto.PurposeDto;
import com.mirado.onboarding.repositories.PurposeRepository;
import com.mirado.onboarding.services.PurposeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PurposeServiceImpl implements PurposeService {
    PurposeRepository purposeRepository;

    @Override
    public PurposeDto findById(Integer id) {
        if (id == null) return null;
        return purposeRepository.findById(id)
                .map(PurposeDto::fromEntity)
                .orElse(null);
    }

    @Override
    public ApiResponse findAll() {
        List<PurposeDto> businesses = purposeRepository.findAll().stream()
                .map(PurposeDto::fromEntity)
                .toList();

        return ApiResponse.success(businesses, "List of main purpose for applying at MCB", HttpStatus.OK);
    }
}
