package org.barney.infrastructure.exception;

import org.aspectj.bridge.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;

public class MessageCode {

    public static final MessageCode SUCCESS = MessageCode.build(200, "ok");
    public static final MessageCode UNKNOWN = MessageCode.build(10001, "unKnowError");
    public static final MessageCode SYSTEM_ERROR = MessageCode.build(10002, "systemError");
    public static final MessageCode COMPONENT_ERROR = MessageCode.build(10003, "componentError");
    public static final MessageCode RUNTIME_ERROR = MessageCode.build(10004, "runtimeError");

    public static final MessageCode REMOTE_ERROR = MessageCode.build(10005, "callRemoteError");

    public static final MessageCode VALIDATE_ERROR = MessageCode.build(11000, "Validation Failed: {0}");

    public static final MessageCode build(int status, String message) {
        return new MessageCode(status, message);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageCode.class);

    private int status;

    private String message;

    public MessageCode(int status, String message) {
        this.status = status;
        this.message = message;
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

    public String getSubMessage(String[] sub) {
        if (!StringUtils.hasText(getMessage())) {
            return null;
        }

        if (ObjectUtils.isEmpty(sub)) {
            return getMessage();
        }

        for (int i = 0; i < sub.length; i++) {
            if (!StringUtils.hasLength(sub[i])) {
                sub[i] = "";
            }
        }

        try {
            return MessageFormat.format(getMessage(), sub);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return getMessage();
        }
    }

    @Override
    public String toString() {
        return "{\"status\":" + status + ",\"message\":\"" + message + '\"' + "}";
    }
}
