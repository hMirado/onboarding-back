package com.mirado.onboarding.controllers;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.EntityTypeDto;
import com.mirado.onboarding.dto.PurposeDto;
import com.mirado.onboarding.services.EntityTypeService;
import com.mirado.onboarding.services.PurposeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/onboarding/purpose")
public class PurposeController {
    private final PurposeService purposeService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<PurposeDto>> list() {
        ApiResponse response = purposeService.findAll();
        return new ResponseEntity<>(response, response.getStatus());
    }
}
