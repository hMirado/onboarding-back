package com.mirado.onboarding.services.impl;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.BusinessDto;
import com.mirado.onboarding.dto.StatusDto;
import com.mirado.onboarding.exceptions.EntityNotFoundException;
import com.mirado.onboarding.exceptions.ErrorCodes;
import com.mirado.onboarding.repositories.BusinessRepository;
import com.mirado.onboarding.repositories.StatusRepository;
import com.mirado.onboarding.services.BusinessService;
import com.mirado.onboarding.services.StatusService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class StatusServiceImpl implements StatusService {
    StatusRepository statusRepository;
    @Override
    public ApiResponse findAll() {
        List<StatusDto> status = statusRepository.findAll().stream()
                .map(StatusDto::fromEntity)
                .toList();

        return ApiResponse.success(status, "List of status", HttpStatus.OK);
    }

    @Override
    public StatusDto findById(Integer id) {
        if (id == null) return null;
        return statusRepository.findById(id)
                .map(StatusDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(("Status not found"), ErrorCodes.STATUS_NOT_FOUND));
    }
}
