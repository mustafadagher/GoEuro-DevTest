/**
 *
 */
package com.goEuro.task.exception;

/**
 * The Class GoEuroBaseException.
 *
 * @author mustafa.kamel
 */
public class GoEuroBaseException extends Exception {

    private static final long serialVersionUID = 3298430582389800279L;

    public GoEuroBaseException() {
    }

    public GoEuroBaseException(final String message) {
        super(message);
    }

    public GoEuroBaseException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
