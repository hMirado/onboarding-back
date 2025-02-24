package com.mirado.onboarding.dto;

import com.mirado.onboarding.models.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusDto {
    private Integer id;
    private String name;

    public static StatusDto fromEntity(Status status) {
        if (status == null) return null;
        return StatusDto.builder()
                .id(status.getId())
                .name(status.getName())
                .build();
    }

    public static Status toEntity(StatusDto statusDto) {
        if (statusDto == null) return null;
        Status status = new Status();
        status.setId(statusDto.getId());
        status.setName(statusDto.getName());
        return status;
    }
}
