package com.sponsoredads.enums;

import lombok.Getter;

@Getter
public enum ErrorMsgEnum {
    CATEGORY_NOT_EXIST("Category %s not exist."),

    CATEGORY_ALREADY_EXIST("category %s already exist."),

    SERIAL_NUMBER_ALREADY_EXIST("Serial number %s already exist."),

    SERIAL_NUMBER_NOT_EXIST("Serial number %s not exist."),

    NO_ACTIVE_PROMOTED_PRODUCT_FOUND("No active promoted product was found.");


    private final String msg;

    ErrorMsgEnum(String msg)
    {
        this.msg = msg;
    }
}
