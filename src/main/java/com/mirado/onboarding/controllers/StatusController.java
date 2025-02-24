package com.mirado.onboarding.controllers;

import com.mirado.onboarding.dto.ApiResponse;
import com.mirado.onboarding.dto.StatusDto;
import com.mirado.onboarding.services.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/onboarding/status")
public class StatusController {
    private final StatusService statusService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<StatusDto>> list() {
        ApiResponse response = statusService.findAll();
        return new ResponseEntity<>(response, response.getStatus());
    }
}
