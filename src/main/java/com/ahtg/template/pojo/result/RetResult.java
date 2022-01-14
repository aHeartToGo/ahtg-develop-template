package com.ahtg.template.pojo.result;

import lombok.Data;

/**
 * @author xubod
 */
@Data
public class RetResult<T> {

    private String code;

    private String msg;

    private T data;

    /**
     * 成功时候的调用
     */
    public static <T> RetResult<T> success(T data) {
        return new RetResult<>(data);
    }

    /**
     * 成功时候的调用
     */
    public static <T> RetResult<T> success() {
        return new RetResult<>();
    }


    /**
     * 失败时候的调用
     */
    public static <T> RetResult<T> error(RetCodeEnum retCodeEnum) {
        return new RetResult<>(retCodeEnum);
    }

    public static <T> RetResult<T> error(String ret, String retMsg) {
        return new RetResult<>(ret, retMsg);
    }

    public RetResult() {
        this.code = RetCodeEnum.SUCCESS.getCode();
        this.msg = RetCodeEnum.SUCCESS.getMsg();
    }

    private RetResult(T data) {
        this.code = RetCodeEnum.SUCCESS.getCode();
        this.msg = RetCodeEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public RetResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private RetResult(RetCodeEnum retMsg) {
        if (retMsg != null) {
            this.code = retMsg.getCode();
            this.msg = retMsg.getMsg();
        }
    }


}
