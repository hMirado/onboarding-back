package com.mirado.onboarding.handlers;

import com.mirado.onboarding.exceptions.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpCode;
    private ErrorCodes code;
    private String message;
    private List<String> errors = new ArrayList<>();
}
