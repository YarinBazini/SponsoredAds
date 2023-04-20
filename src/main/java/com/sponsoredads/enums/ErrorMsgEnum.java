package com.sponsoredads.enums;

import lombok.Getter;

@Getter
public enum ErrorMsgEnum {
    CATEGORY_NOT_EXIST("Category %s not exist."),

    CATEGORY_ALREADY_EXIST("category %s already exist."),

    SERIAL_NUMBER_ALREADY_EXIST("Serial number %s already exist.");


    private final String msg;

    ErrorMsgEnum(String msg)
    {
        this.msg = msg;
    }
}
