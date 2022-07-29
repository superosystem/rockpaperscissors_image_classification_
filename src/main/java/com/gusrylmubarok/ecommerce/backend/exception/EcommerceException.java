package com.gusrylmubarok.ecommerce.backend.exception;

import com.gusrylmubarok.ecommerce.backend.domain.enumeration.ResultEnum;

public class EcommerceException extends RuntimeException{
    private Integer code;

    public EcommerceException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public EcommerceException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
