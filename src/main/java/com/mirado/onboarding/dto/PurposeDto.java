package com.mirado.onboarding.dto;

import com.mirado.onboarding.models.Purpose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurposeDto {
    private Integer id;
    private String name;

    public static PurposeDto fromEntity(Purpose purpose) {
        if (purpose == null) return null;
        return PurposeDto.builder()
                .id(purpose.getId())
                .name(purpose.getName())
                .build();
    }

    public static Purpose toEntity(PurposeDto purposeDto) {
        if (purposeDto == null) return null;
        Purpose purpose = new Purpose();
        purpose.setId(purposeDto.getId());
        purpose.setName(purposeDto.getName());
        return purpose;
    }
}
