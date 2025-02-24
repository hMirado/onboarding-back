package com.mirado.onboarding.controllers;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.BusinessDto;
import com.mirado.onboarding.dto.EntityTypeDto;
import com.mirado.onboarding.services.BusinessService;
import com.mirado.onboarding.services.EntityTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/onboarding/entity")
public class EntityController {
    private final EntityTypeService entityTypeService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<EntityTypeDto>> list() {
        ApiResponse response = entityTypeService.findAll();
        return new ResponseEntity<>(response, response.getStatus());
    }
}
