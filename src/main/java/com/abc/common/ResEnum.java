package com.abc.common;

public enum ResEnum {
    SUCCESS(200,"success"),
    SUCCESS_USER_EXIST(201,"user exist success"),
    SUCCESS_DEL_BATCH(202,"del batch success"),

    ERROR_USER_EXIST(501,"user exist error"),
    ERROR_PARAMS_IN_DELBATCH(502,"params in delbatch error"),
    ERROR(500,"error");
    private int status;
    private String msg;

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    ResEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

}
