package com.sponsoredads.exceptions;

import com.sponsoredads.enums.ErrorMsgEnum;
import lombok.Getter;

@Getter
public class SponsoredAdsException extends Exception{

    public SponsoredAdsException(ErrorMsgEnum errorMsgEnum, String... args)
    {
        super(String.format(errorMsgEnum.getMsg(), args));
    }
}
