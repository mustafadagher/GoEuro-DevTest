package com.goEuro.task.exception;

/**
 * The Enum GoEuroErros. Contains the common custom errors thrown within the application.
 *
 * @author mustafa.kamel
 */
public enum GoEuroErros {

    /** The client error. */
    CLIENT_ERROR("Error while accessing the client endpoint URL", ExceptionType.SYSTEM),

    /** The no match found error. */
    NO_MATCH_FOUND("No match found for the city:", ExceptionType.BUSINESS),

    /** The no city name provided. */
    NO_CITY_NAME_PROVIDED("Ther's no city name provided in parameters.", ExceptionType.BUSINESS),

    /** The empty url exception. */
    EMPTY_URL_EXCEPTION("URL provided is empty", ExceptionType.BUSINESS),

    /** The file creation writing exception. */
    FILE_CREATION_WRITING_EXCEPTION("Error while creating or writing the CSV file", ExceptionType.SYSTEM);

    /** The description. */
    private String description;

    /** The exception type. */
    private ExceptionType type;

    /**
     * Instantiates a new go euro erros.
     *
     * @param description the description
     * @param type the exception type. value from the Enum {@link ExceptionType}.
     */
    private GoEuroErros(final String description, final ExceptionType type) {
        this.description = description;
        this.type = type;
    }

    /**
     * Builds the exception.
     *
     * @param messageParameters the message parameters
     * @return the runtime exception
     */
    public GoEuroBaseException buildException(final Object... messageParameters) {

        return buildException(null, messageParameters);
    }

    /**
     * Builds the exception.
     *
     * @param cause the cause
     * @param messageParameters the message parameters
     * @return the {@link BusinessException} in case of business related Error and {@link SystemException} in case of
     *         system errors
     */
    public GoEuroBaseException buildException(final Throwable cause, final Object... messageParameters) {
        switch (this.type) {
            case BUSINESS:
                return new BusinessException(this.description, cause);
            case SYSTEM:
                return new SystemException(this.description, cause);
            default:
                return new SystemException(this.description, cause);
        }

    }

    /**
     * The Enum ExceptionType.
     */
    private static enum ExceptionType {

        /** The system. */
        SYSTEM,
        /** The business. */
        BUSINESS;
    }

    public String getDescription() {
        return description;
    }

    public ExceptionType getType() {
        return type;
    }
}
