package org.example.mycarservice.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionConstants {
    BRAND_NOT_FOUND("BRAND_NOT_FOUND","Brand Not Found");
     private final String code;
     private final String message;
}
