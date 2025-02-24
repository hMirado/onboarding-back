package com.mirado.onboarding.services.impl;

import com.mirado.onboarding.dto.*;
import com.mirado.onboarding.exceptions.EntityAlreadyExistException;
import com.mirado.onboarding.exceptions.EntityNotFoundException;
import com.mirado.onboarding.exceptions.ErrorCodes;
import com.mirado.onboarding.exceptions.InvalidEntityException;
import com.mirado.onboarding.repositories.CustomerRepository;
import com.mirado.onboarding.services.*;
import com.mirado.onboarding.validators.CustomerValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final BusinessService businessService;
    private final EntityTypeService entityTypeService;
    private final PurposeService purposeService;
    private final ShareHolderService shareHolderService;
    private final StatusService statusService;

    @Override
    @Transactional
    public ApiResponse<CustomerDto> save(CustomerDto value) {
        BusinessDto businessDto = businessService.findById(BusinessDto.toEntity(value.getBusinessDto()).getId());
        value.setBusinessDto(businessDto);

        List<String> errors = CustomerValidator.validate(value);
        if (!errors.isEmpty()) throw new InvalidEntityException("Customer onboarding information isn't completed", ErrorCodes.CUSTOMER_NOT_VALID, errors);
        CustomerDto customerDto = findByCompany(value.getCompany());
        if (CustomerDto.toEntity(customerDto) != null) {
            throw new EntityAlreadyExistException("Company name already exist.", ErrorCodes.CUSTOMER_COMPANY_ALREADY_EXIST);
        }
        CustomerDto newCustomer = CustomerDto.fromEntity(customerRepository.save(CustomerDto.toEntity(value)));

        List<ShareholderDto> shareholders = shareHolderService.save(value.getShareholderDtos(), newCustomer);
        newCustomer.setShareholderDtos(shareholders);

        return ApiResponse.success(newCustomer, "Your information has saved successfully", HttpStatus.CREATED);
    }

    @Override
    public ApiResponse findAll(Specification specification) {
        List<CustomerDto> customers = customerRepository.findAll(specification).stream()
                .map(CustomerDto::fromEntity)
                .toList();

        return ApiResponse.success(customers, "List of customer onboarding", HttpStatus.OK);
    }

    @Override
    public ApiResponse findById(Integer id) {
        CustomerDto customer = customerRepository.findById(id).map(
                CustomerDto::fromEntity).orElseThrow(() -> new EntityNotFoundException(("Customer onboarding not found"), ErrorCodes.CUSTOMER_NOT_FOUND));
        return ApiResponse.success(customer, "Customer onboarding detail", HttpStatus.OK);
    }

    @Transactional
    @Override
    public ApiResponse update(Integer id, CustomerDto value) {
        findById(id);
        CustomerDto customer = value;
        customer.setId(id);

        BusinessDto businessDto = businessService.findById(BusinessDto.toEntity(value.getBusinessDto()).getId());
        customer.setBusinessDto(businessDto);

        EntityTypeDto entityTypeDto = entityTypeService.findById(EntityTypeDto.toEntity(value.getEntityTypeDto()).getId());
        customer.setEntityTypeDto(entityTypeDto);

        PurposeDto purposeDto = purposeService.findById(PurposeDto.toEntity(value.getPurposeDto()).getId());
        customer.setPurposeDto(purposeDto);

        List<String> errors = CustomerValidator.validate(customer);
        if (!errors.isEmpty()) throw new InvalidEntityException("Customer onboarding information isn't completed", ErrorCodes.CUSTOMER_NOT_VALID, errors);

        CustomerDto updatedCustomerOnboarding = CustomerDto.fromEntity(customerRepository.save(CustomerDto.toEntity(customer)));

        List<ShareholderDto> shareholders = shareHolderService.update(customer.getId(), customer.getShareholderDtos(), updatedCustomerOnboarding);
        updatedCustomerOnboarding.setShareholderDtos(shareholders);

        return ApiResponse.success(updatedCustomerOnboarding, "Your information is updated successfully", HttpStatus.OK);
    }

    @Override
    public ApiResponse validate(Integer id, Integer status) {
        StatusDto statusDto = statusService.findById(status);

        CustomerDto customerDto = (CustomerDto) findById(id).getData();
        customerDto.setStatusDto(statusDto);

        CustomerDto validateCustomerOnboarding = CustomerDto.fromEntity(customerRepository.save(CustomerDto.toEntity(customerDto)));
        validateCustomerOnboarding.setShareholderDtos(customerDto.getShareholderDtos());
        return ApiResponse.success(validateCustomerOnboarding, "Your onboarding is " + statusDto.getName().toLowerCase() + " successfully", HttpStatus.OK);
    }

    private CustomerDto findByCompany(String company) {
        return customerRepository.findCustomerByCompany(company)
                .map(CustomerDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(("Customer onboarding not found"), ErrorCodes.CUSTOMER_NOT_FOUND));
    }
}
