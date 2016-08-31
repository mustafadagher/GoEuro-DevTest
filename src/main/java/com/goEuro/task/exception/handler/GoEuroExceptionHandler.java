/**
 *
 */
package com.goEuro.task.exception.handler;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import com.goEuro.task.exception.BusinessException;
import com.goEuro.task.exception.GoEuroBaseException;
import com.goEuro.task.exception.SystemException;

/**
 * The Aspect GoEuroExceptionHandler. Used to handle exceptions thrown in the application.
 *
 * @author mustafa.kamel
 */
@Aspect
public final class GoEuroExceptionHandler {

    /**
     * Handle Business exception. For the current implementation it just print a message to console and exit the
     * application
     *
     * @param ex the ex
     */
    @AfterThrowing(pointcut = "execution(* com.goEuro.task..* (..))", throwing = "ex")
    public void handleSystemException(final SystemException ex) {
        final String message = "ClIENT ERROR: ";
        doCommonHandling(ex, message);
    }

    /**
     * Handle Business exception. For the current implementation it just print a message to console and exit the
     * application
     *
     * @param ex the ex
     */
    @AfterThrowing(pointcut = "execution(* com.goEuro.task..* (..))", throwing = "ex")
    public void handleBusinessException(final BusinessException ex) {
        final String message = "APPLICATION ERROR: ";
        doCommonHandling(ex, message);
    }

    /**
     * @param ex
     * @param message
     */
    private void doCommonHandling(final GoEuroBaseException ex, final String message) {
        message.concat(ex.getMessage());
        System.out.println(message);
        System.exit(0);
    }
}
