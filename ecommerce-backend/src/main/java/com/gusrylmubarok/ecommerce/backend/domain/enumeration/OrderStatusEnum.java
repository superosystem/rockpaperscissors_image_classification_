package com.gusrylmubarok.ecommerce.backend.domain.enumeration;

public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "New OrderMain"),
    FINISHED(1, "Finished"),
    CANCELED(2, "Canceled");

    private int code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return null;
    }
}
