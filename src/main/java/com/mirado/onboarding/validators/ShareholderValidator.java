package com.mirado.onboarding.validators;

import com.mirado.onboarding.dto.ShareholderDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ShareholderValidator {
    public static List<String> validate(ShareholderDto shareholderDto) {
        List<String> errors = new ArrayList<>();
        if (shareholderDto == null) {
            errors.add("Please enter director/shareholder name");
            errors.add("Please enter director/shareholder passport number");
            return errors;
        }

        if (!StringUtils.hasLength(shareholderDto.getName())) {
            errors.add("Please enter director/shareholder name");
        }
        if (!StringUtils.hasLength(shareholderDto.getPassport())) {
            errors.add("Please enter director/shareholder passport number");
        }

        return errors;
    }
}
