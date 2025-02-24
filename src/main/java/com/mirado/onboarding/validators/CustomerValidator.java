package com.mirado.onboarding.validators;

import com.mirado.onboarding.dto.CustomerDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerValidator {
    public static List<String> validate(CustomerDto customerDto) {
        List<String> errors = new ArrayList<>();
        if (customerDto == null) {
            errors.add("Please choose the main purpose for applying at MCB");
            errors.add("Please enter the company name");
            errors.add("Please choose the type of entity");
            errors.add("Please choose the business activity");
            errors.add("Please enter your license");
            errors.add("Please enter registration number");
            errors.add("Please enter the incorporation date");
            errors.add("Please select the country");
            errors.add("Please enter the applicant");
            errors.add("Please enter the email");
            errors.add("Please enter name and passport for director or shareholders");
            return errors;
        }

        if (customerDto.getPurposeDto() == null || customerDto.getPurposeDto().getId() == null){
            errors.add("Please choose the main purpose for applying at MCB");
        }
        if (customerDto.getEntityTypeDto() == null || customerDto.getEntityTypeDto().getId() == null){
            errors.add("Please choose the type of entity");
        }
        if (customerDto.getBusinessDto() == null || customerDto.getBusinessDto().getId() == null){
            errors.add("Please choose the business activity");
        } else {
            if (customerDto.getBusinessDto().getName().equals("Banking") && !StringUtils.hasLength(customerDto.getLicense())) {
                errors.add("Please enter your license");
            }
        }
        if (!StringUtils.hasLength(customerDto.getCompany())){
            errors.add("Please enter the company name");
        }
        if (!StringUtils.hasLength(customerDto.getCountry())){
            errors.add("Please select the country");
        }
        if (!StringUtils.hasLength(customerDto.getRegistrationNumber())){
            errors.add("Please enter registry number");
        }
        if (!StringUtils.hasLength(customerDto.getIncorporationDate().toString())){
            errors.add("Please enter the incorporationDate");
        }
        if (!StringUtils.hasLength(customerDto.getApplicant())){
            errors.add("Please enter the applicant");
        }

        if (!StringUtils.hasLength(customerDto.getEmail())){
            errors.add("Please enter the email");
        } else {
            String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            Pattern pattern = Pattern.compile(EMAIL_REGEX);
            Matcher matcher = pattern.matcher(customerDto.getEmail());
            if (!matcher.matches())  errors.add("Your email is invalid");
        }

        if (customerDto.getShareholderDtos() == null || customerDto.getShareholderDtos().isEmpty()) {
            errors.add("Please enter name and passport for director or shareholders");
        }
        return errors;
    }
}
