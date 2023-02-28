package org.barney.infrastructure.vo;

import org.barney.infrastructure.exception.MessageCode;
import org.barney.infrastructure.utils.DistributedIDUtil;
import org.slf4j.MDC;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static Result of(MessageCode messageCode) {
        return new Result(messageCode.getStatus(), messageCode.getMessage(), MDC.get(DistributedIDUtil.MDC_TRACE_ID));
    }

    private static <T> Result of(MessageCode code, T data) {
        final Result<T> r = Result.of(code);
        r.setData(data);
        return r;
    }

    public static Result success() {
        return Result.of(MessageCode.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        return Result.of(MessageCode.SUCCESS, data);
    }

    public static Result error() {
        return Result.of(MessageCode.SYSTEM_ERROR);
    }

    public static Result error(String message) {
        final Result r = Result.of(MessageCode.SYSTEM_ERROR);
        r.setMessage(message);
        return r;
    }

    public static <T> Result<T> error(String message, T data) {
        final Result<T> r = Result.error(message);
        r.setData(data);
        return r;
    }

    public static <T> Result error(int code, String message, T data) {
        return new Result(code, message, data, MDC.get(DistributedIDUtil.MDC_TRACE_ID));
    }


    private int status;

    private String message;

    private T data;

    private String traceId;

    private String errorMessage;

    public Result() {
    }

    public Result(int status, String message, String traceId) {
        this.status = status;
        this.message = message;
        this.traceId = traceId;
    }

    public Result(int status, String message, T data, String traceId) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.traceId = traceId;
    }

    public boolean resultIsOk() {
        return status == MessageCode.SUCCESS.getStatus();
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", traceId='" + traceId + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
