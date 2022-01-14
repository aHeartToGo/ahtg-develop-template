package com.ahtg.template.pojo.result;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RetCodeEnum {

    SYSTEM_ERROR("-1", "system error"),
    SUCCESS("0", "success");


    private String code;
    private String msg;

}
