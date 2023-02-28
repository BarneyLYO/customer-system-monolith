package org.barney.infrastructure.exception;

import org.barney.infrastructure.exception.interfaces.ExceptionMessage;

public class BusinessException extends RuntimeException implements ExceptionMessage {
    private final MessageCode messageCode;

    public BusinessException(MessageCode messageCode, Throwable cause) {
        super(messageCode.getMessage(), cause);
        this.messageCode = messageCode;
    }

    public BusinessException(MessageCode messageCode, String... sub) {
        super(messageCode.getSubMessage(sub));
        this.messageCode = messageCode;
    }

    public BusinessException(MessageCode messageCode, Throwable cause, String... sub) {
        super(messageCode.getSubMessage(sub), cause);
        this.messageCode = messageCode;
    }

    @Override
    public MessageCode getMessageCode() {
        return this.messageCode;
    }
}
