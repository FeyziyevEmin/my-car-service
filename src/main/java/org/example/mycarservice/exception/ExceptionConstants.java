package org.example.mycarservice.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionConstants {
    BRAND_NOT_FOUND("BRAND_NOT_FOUND", "Brand Not Found"),
    CAR_DETAIL_NOT_FOUND("CAR_DETAIL_NOT_FOUND", "Car Detail Not Found"),
    CAR_NOT_FOUND("CAR_NOT_FOUND", "Car Not Found"),
    FEATURE_NOT_FOUND("FEATURE_NOT_FOUND", "Feature Not Found"),
    MODEL_NOT_FOUND("MODEL_NOT_FOUND", "Model Not Found");
    private final String code;
    private final String message;
    }
