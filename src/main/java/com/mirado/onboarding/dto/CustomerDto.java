package com.mirado.onboarding.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mirado.onboarding.models.Customer;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Integer id;
    private String company;
    private String license;
    private String country;
    private String registrationNumber;
    private Date incorporationDate;
    private String applicant;
    private String email;
    private PurposeDto purposeDto;
    private EntityTypeDto entityTypeDto;
    private BusinessDto businessDto;
    private List<ShareholderDto> shareholderDtos;
    private StatusDto statusDto;

    public static CustomerDto fromEntity(Customer customer) {
        if (customer == null) return null;
        return CustomerDto.builder()
                .id(customer.getId())
                .company(customer.getCompany())
                .license(customer.getLicense())
                .country(customer.getCountry())
                .registrationNumber(customer.getRegistrationNumber())
                .incorporationDate(customer.getIncorporationDate())
                .applicant(customer.getApplicant())
                .email(customer.getEmail())
                .purposeDto(PurposeDto.fromEntity(customer.getPurpose()))
                .entityTypeDto(EntityTypeDto.fromEntity(customer.getEntityType()))
                .businessDto(BusinessDto.fromEntity(customer.getBusiness()))
                .shareholderDtos(
                        customer.getShareholders() != null ?
                                customer.getShareholders().stream()
                                        .map(ShareholderDto::fromEntity)
                                        .collect(Collectors.toList())
                                : new ArrayList<>()
                )
                .statusDto(StatusDto.fromEntity(customer.getStatus()))
                .build();
    }

    public static Customer toEntity(CustomerDto customerDto) {
        if (customerDto == null) return null;
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setCompany(customerDto.getCompany());
        customer.setLicense(customerDto.getLicense());
        customer.setCountry(customerDto.getCountry());
        customer.setRegistrationNumber(customerDto.getRegistrationNumber());
        customer.setIncorporationDate(customerDto.getIncorporationDate());
        customer.setApplicant(customerDto.getApplicant());
        customer.setEmail(customerDto.getEmail());
        customer.setPurpose(PurposeDto.toEntity(customerDto.getPurposeDto()));
        customer.setEntityType(EntityTypeDto.toEntity(customerDto.getEntityTypeDto()));
        customer.setBusiness(BusinessDto.toEntity(customerDto.getBusinessDto()));
        customer.setStatus(StatusDto.toEntity(customerDto.getStatusDto()));
        return customer;
    }
}
