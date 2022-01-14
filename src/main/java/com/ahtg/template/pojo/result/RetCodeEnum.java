package com.ahtg.template.pojo.result;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RetCodeEnum {

    SYSTEM_ERROR("-1", "system error"),
    SUCCESS("0", "success"),
    PARAMS_NOT_VALID("1001", "参数校验不通过"),
    PARAMS_TYPE_ERROR("1002", "参数类型有误");

    private String code;
    private String msg;

}
