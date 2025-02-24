package com.mirado.onboarding.dto;

import com.mirado.onboarding.models.Shareholder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShareholderDto {
    private Integer id;
    private String name;
    private String passport;
    private CustomerDto customerDto;

    public static ShareholderDto fromEntity(Shareholder shareholder) {
        if (shareholder == null) return null;
        return ShareholderDto.builder()
                .id(shareholder.getId())
                .name(shareholder.getName())
                .passport(shareholder.getPassport())
                .build();
    }

    public static Shareholder toEntity(ShareholderDto shareholderDto) {
        if (shareholderDto == null) return null;
        Shareholder shareholder = new Shareholder();
        shareholder.setId(shareholderDto.getId());
        shareholder.setName(shareholderDto.getName());
        shareholder.setPassport(shareholderDto.getPassport());
        shareholder.setCustomer(CustomerDto.toEntity(shareholderDto.getCustomerDto()));
        return shareholder;
    }
}
