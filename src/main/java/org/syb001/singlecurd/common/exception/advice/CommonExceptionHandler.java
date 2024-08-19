package org.syb001.singlecurd.common.exception.advice;

import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.syb001.singlecurd.common.exception.BizException;
import org.syb001.singlecurd.dto.response.Result;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(BizException.class)
    public Result<Void> handleUsernameDuplicateException(BizException e){
        return new Result<>(e.getErrorCode(), e.getMessage(), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();

        result.getFieldErrors().forEach(fieldError -> {
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            errorMap.put(field, message);
        });
        return Result.fail("入参不合法", errorMap);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Result<Void> handleConstraintViolationException(ConstraintViolationException e){
        return Result.fail(e.getMessage(), null);
    }
}
