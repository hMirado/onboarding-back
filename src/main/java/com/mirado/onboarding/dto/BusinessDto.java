package com.mirado.onboarding.dto;

import com.mirado.onboarding.models.Business;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusinessDto {
    private Integer id;
    private String name;

    public static BusinessDto fromEntity(Business business) {
        if (business == null) return null;
        return BusinessDto.builder()
                .id(business.getId())
                .name(business.getName())
                .build();
    }

    public static Business toEntity(BusinessDto businessDto) {
        if (businessDto == null) return null;
        Business business = new Business();
        business.setId(businessDto.getId());
        business.setName(businessDto.getName());
        return business;
    }
}
