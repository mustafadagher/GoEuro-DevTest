package com.goEuro.task.exception;

/**
 * The Class BusinessException.
 *
 * @author mustafa.kamel
 */
public class BusinessException extends GoEuroBaseException {

    private static final long serialVersionUID = 6907392070973221073L;

    public BusinessException() {
    }

    public BusinessException(final String message) {
        super(message);
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
