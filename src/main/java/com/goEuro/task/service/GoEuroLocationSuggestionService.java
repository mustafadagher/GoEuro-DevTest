/**
 *
 */
package com.goEuro.task.service;

import com.goEuro.task.exception.GoEuroBaseException;

/**
 * The Interface GoEuroLocationSuggestionService.
 *
 * @author mustafa.kamel
 */
public interface GoEuroLocationSuggestionService {

    /**
     * Gets the suggested locations.
     *
     * @param cityName the city name
     * @return the suggested locations
     * @throws GoEuroBaseException the go euro base exception
     */
    void getSuggestedLocations(String cityName) throws GoEuroBaseException;
}
