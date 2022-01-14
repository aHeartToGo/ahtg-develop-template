package com.ahtg.template.global;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
 
import java.util.ArrayList;
import java.util.List;
 
@Component
public class ResponseBodyReturnValueHandler implements InitializingBean {
 
    private final RequestMappingHandlerAdapter requestMappingHandlerAdapter;
 
    public ResponseBodyReturnValueHandler(RequestMappingHandlerAdapter requestMappingHandlerAdapter) {
        this.requestMappingHandlerAdapter = requestMappingHandlerAdapter;
    }
 
    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        ArrayList<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(returnValueHandlers);
        if (handlers.size() > 0) {
            decorateHandlers(handlers);
        }
        requestMappingHandlerAdapter.setReturnValueHandlers(handlers);
    }
 
    private void decorateHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        for (int i = 0, len = handlers.size(); i < len; i++) {
            HandlerMethodReturnValueHandler currentHandler = handlers.get(i);
            // 替换RequestResponseBodyMethodProcessor
            if (currentHandler instanceof RequestResponseBodyMethodProcessor) {
                WrapReturnValueHandler wrapHandler = new WrapReturnValueHandler(currentHandler);
                handlers.set(i, wrapHandler);
                break;
            }
        }
    }
}