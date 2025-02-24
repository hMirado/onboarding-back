package com.mirado.onboarding.services.impl;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.BusinessDto;
import com.mirado.onboarding.dto.EntityTypeDto;
import com.mirado.onboarding.repositories.EntityTypeRepository;
import com.mirado.onboarding.services.EntityTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class EntityTypeServiceImpl implements EntityTypeService {
    EntityTypeRepository entityTypeRepository;
    
    @Override
    public EntityTypeDto findById(Integer id) {
        if (id == null) return null;
        return entityTypeRepository.findById(id)
                .map(EntityTypeDto::fromEntity)
                .orElse(null);
    }

    @Override
    public ApiResponse findAll() {
        List<EntityTypeDto> businesses = entityTypeRepository.findAll().stream()
                .map(EntityTypeDto::fromEntity)
                .toList();

        return ApiResponse.success(businesses, "List of Type of entity", HttpStatus.OK);
    }
}
