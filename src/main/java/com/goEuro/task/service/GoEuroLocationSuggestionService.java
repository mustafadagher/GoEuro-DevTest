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
     * Write locations to file.
     *
     * @param location the location
     */
    void writeSuggestedLocationsToFile(String cityName) throws GoEuroBaseException;
}
