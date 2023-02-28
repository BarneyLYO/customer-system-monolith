package org.barney.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;
import org.barney.infrastructure.vo.Result;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAopHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result exceptionHandler(HttpServletRequest _req, HttpMessageNotReadableException _e) {
        return Result.error("Received Empty Request Body");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result exceptionHandler(HttpServletRequest _req, MethodArgumentNotValidException e) {
        return Result.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result exceptionHandler(HttpServletRequest _req, HttpRequestMethodNotSupportedException e) {
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result exceptionHandler(HttpServletRequest req, BusinessException e) {
        log.error("Business Exception", e);
        return Result.error(e.getMessageCode().getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("System Exception", e);
        return Result.error("System Internal Error");
    }
}
