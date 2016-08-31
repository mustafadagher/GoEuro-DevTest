/**
 *
 */
package com.goEuro.task.exception.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.goEuro.task.exception.BusinessException;
import com.goEuro.task.exception.GoEuroBaseException;
import com.goEuro.task.exception.SystemException;

/**
 * The Aspect GoEuroExceptionHandler. Used to handle exceptions thrown in the application.
 *
 * @author mustafa.kamel
 */
@Aspect
@Component
public final class GoEuroExceptionHandler {

    /**
     * Handle exception. For the current implementation it just print a message to console and exit the application
     *
     * @param ex the ex
     */

    @Around("execution(* com.goEuro.task..*.*(..))")
    public void handleException(final ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            joinPoint.proceed();
        } catch (final SystemException ex) {
            final String message = "ClIENT ERROR: ";
            doCommonHandling(ex, message);
        } catch (final BusinessException ex) {
            final String message = "APPLICATION ERROR: ";
            doCommonHandling(ex, message);
        }
    }

    /**
     * @param ex
     * @param message
     */
    private void doCommonHandling(final GoEuroBaseException ex, final String message) {
        System.out.println(message.concat(ex.getMessage()));
        System.exit(0);
    }
}
