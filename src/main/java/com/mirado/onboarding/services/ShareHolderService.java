package com.mirado.onboarding.services;

import com.mirado.onboarding.dto.CustomerDto;
import com.mirado.onboarding.dto.ShareholderDto;

import java.util.List;

public interface ShareHolderService {
    List<ShareholderDto> save(List<ShareholderDto> shareholderDto, CustomerDto customerDto);
    List<ShareholderDto> findByCustomer(Integer id);
    List<ShareholderDto> update(Integer customerOnboardingId, List<ShareholderDto> shareholderDto, CustomerDto updatedCustomerOnboarding);
}
