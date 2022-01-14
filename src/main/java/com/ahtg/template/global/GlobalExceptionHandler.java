package com.ahtg.template.global;

import com.ahtg.template.pojo.result.RetCodeEnum;
import com.ahtg.template.pojo.result.RetResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler({CommonBizException.class})
    @ResponseBody
    public RetResult<Object> handleCommonBizException(HttpServletResponse response, CommonBizException exception) {
        response.setStatus(HttpServletResponse.SC_OK);
        String code = exception.getCode();
        String message = exception.getMessage();
        return new RetResult(code, message);
    }

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RetResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new RetResult().error(RetCodeEnum.PARAMS_NOT_VALID.getCode(), e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * 参数类型校验
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public RetResult<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return new RetResult().error(RetCodeEnum.PARAMS_TYPE_ERROR.getCode(), RetCodeEnum.PARAMS_TYPE_ERROR.getMsg());
    }


}
