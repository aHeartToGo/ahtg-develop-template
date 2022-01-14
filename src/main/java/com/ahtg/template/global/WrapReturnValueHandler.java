package com.ahtg.template.global;

import com.ahtg.template.pojo.result.RetResult;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

public class WrapReturnValueHandler implements HandlerMethodReturnValueHandler {
    /**
     * 采用装饰者模式
     */
    private final HandlerMethodReturnValueHandler delegate;
 
    public WrapReturnValueHandler(HandlerMethodReturnValueHandler delegate) {
        this.delegate = delegate;
    }
 
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return this.delegate.supportsReturnType(returnType);
    }
 
    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType,
                                  ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        // 1. 对所有返回值进行包装处理, 适用于新项目
        returnValue = new RetResult(returnValue);
        this.delegate.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }
}