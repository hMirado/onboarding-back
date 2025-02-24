package com.mirado.onboarding.services.impl;

import com.mirado.onboarding.dto.CustomerDto;
import com.mirado.onboarding.dto.ShareholderDto;
import com.mirado.onboarding.exceptions.EntityNotFoundException;
import com.mirado.onboarding.exceptions.ErrorCodes;
import com.mirado.onboarding.exceptions.InvalidEntityException;
import com.mirado.onboarding.models.Customer;
import com.mirado.onboarding.models.Shareholder;
import com.mirado.onboarding.repositories.ShareholderRepository;
import com.mirado.onboarding.services.ShareHolderService;
import com.mirado.onboarding.validators.ShareholderValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class ShareholderServiceImpl implements ShareHolderService {
    private ShareholderRepository shareholderRepository;

    @Override
    @Transactional
    public List<ShareholderDto> save(List<ShareholderDto> shareholderDtos, CustomerDto customerDto) {
        List<ShareholderDto> savedShareholders = new ArrayList<>();

        for (ShareholderDto value: shareholderDtos) {
            List<String> errors = ShareholderValidator.validate(value);
            if (!errors.isEmpty()) {
                throw new InvalidEntityException("Directors or shareholders information aren't completed", ErrorCodes.SHAREHOLDER_NOT_VALID, errors);
            }

            value.setCustomerDto(customerDto);

            Shareholder newShareholder = shareholderRepository.save(ShareholderDto.toEntity(value));
            savedShareholders.add(ShareholderDto.fromEntity(newShareholder));
        }

        return savedShareholders;
    }

    @Override
    public List<ShareholderDto> findByCustomer(Integer id) {
        return shareholderRepository.findByCustomerId(id).stream()
                .map(ShareholderDto::fromEntity)
                .toList();
    }

    @Override
    public List<ShareholderDto> update(Integer customerOnboardingId, List<ShareholderDto> shareholderDto, CustomerDto customerDto) {
        List<ShareholderDto> currentShareolder = findByCustomer(customerOnboardingId);

        List<ShareholderDto> shareholderRemoved = new ArrayList<>(currentShareolder);
        shareholderRemoved.removeAll(shareholderDto);
        for (ShareholderDto s: shareholderRemoved ) {
            delete(s.getId());
        }

        return save(shareholderDto, customerDto);
    }

    @Transactional
    public void delete(Integer id) {
        Shareholder shareholder = shareholderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(("Customer not found"), ErrorCodes.SHAREHOLDER_NOT_FOUND));
        shareholder.setDeleted(Instant.now());
        shareholderRepository.save(shareholder);
    }
}
