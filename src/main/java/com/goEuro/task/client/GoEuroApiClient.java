package com.goEuro.task.client;

import com.goEuro.task.bo.Location;
import com.goEuro.task.exception.GoEuroBaseException;

/**
 * The Interface GoEuroApiClient.
 */
public interface GoEuroApiClient {

    /**
     * Gets the location suggestions from the API endpoint.
     *
     * @param cityName the city name
     * @return the location suggestions
     * @throws GoEuroBaseException
     */
    public Location[] getLocationSuggestions(final String cityName) throws GoEuroBaseException;

}
