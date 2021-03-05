package com.example.exception.handler;

import com.example.config.CommonResult;
import com.example.exception.ApiException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/*
 *@author:liuhongdi
 *@description:异常集中处理
 */
@ControllerAdvice

public class GlobalExceptionHandler {
    //验证参数时不符合要求 ConstraintViolationException
    //缺少应该传递的参数 MissingServletRequestParameterException
    //参数类型不匹配，用户输入的参数类型有错误时会报这个 MethodArgumentTypeMismatchException
    //验证时绑定错误 BindException
    @ResponseBody
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public CommonResult violationHandler(ConstraintViolationException e) {
        return CommonResult.validateFailed(e.getLocalizedMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public CommonResult violationHandler(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        for( FieldError fieldError:e.getBindingResult().getFieldErrors()){
            sb.append(fieldError.getDefaultMessage()).append(",");
        }
        sb.setLength(sb.length()-1);
        return CommonResult.validateFailed(sb.toString());
    }

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }
}
