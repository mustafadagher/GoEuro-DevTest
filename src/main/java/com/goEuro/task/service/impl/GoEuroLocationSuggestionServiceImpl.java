/**
 *
 */
package com.goEuro.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goEuro.task.bo.Location;
import com.goEuro.task.client.GoEuroApiClient;
import com.goEuro.task.exception.GoEuroBaseException;
import com.goEuro.task.exception.GoEuroErros;
import com.goEuro.task.service.GoEuroLocationSuggestionService;
import com.goEuro.task.util.CsvUtils;

/**
 * The Class GoEuroLocationSuggestionServiceImpl.
 *
 * @author mustafa.kamel
 */
@Service
public class GoEuroLocationSuggestionServiceImpl implements GoEuroLocationSuggestionService {

    private static final String CSV_EXT = ".csv";

    /** The go euro api client. */
    @Autowired
    private GoEuroApiClient goEuroApiClient;

    @Autowired
    private CsvUtils csvUtils;

    /**
     * Gets the suggested locations from the client and then writes them to csv file.
     *
     * @param cityName the city name
     * @return Writes a csv file with the sugessted locations
     * @throws GoEuroBaseException if no match found for the city name specified.
     */
    @Override
    public void getSuggestedLocations(final String cityName) throws GoEuroBaseException {
        final Location[] locations = goEuroApiClient.getLocationSuggestions(cityName);
        if (locations == null || locations.length < 1) {
            throw GoEuroErros.NO_MATCH_FOUND.buildException();
        }
        final String fileName = cityName.concat(CSV_EXT);
        csvUtils.writeToCsvFile(fileName, locations);
    }

}
