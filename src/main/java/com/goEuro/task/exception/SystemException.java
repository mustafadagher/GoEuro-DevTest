package com.goEuro.task.exception;

/**
 * The Class SystemException.
 *
 * @author mustafa.kamel
 */
public class SystemException extends GoEuroBaseException {

    private static final long serialVersionUID = 2206601376445069690L;

    public SystemException() {
    }

    public SystemException(final String message) {
        super(message);
    }

    public SystemException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
