package com.goEuro.task.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.goEuro.task.bo.Location;
import com.goEuro.task.client.GoEuroApiClient;
import com.goEuro.task.exception.GoEuroBaseException;
import com.goEuro.task.exception.GoEuroErros;

/**
 * The Class GoEuroApiClientImpl.
 *
 * @author mustafa.kamel
 */
@Component
public class GoEuroApiClientImpl implements GoEuroApiClient {

    /** The url. */
    @Value(value = "${goEuro.location.api.endpoint.url}")
    private transient String url;

    /** The rest template. */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Gets the location suggestions from the API endpoint.
     *
     * @param cityName the city name
     * @return the location suggestions
     * @throws GoEuroBaseException the go euro base exception
     */
    @Override
    public Location[] getLocationSuggestions(final String cityName) throws GoEuroBaseException {
        Location[] locations = null;

        if (url == null || url.isEmpty()) {
            throw GoEuroErros.EMPTY_URL_EXCEPTION.buildException();
        }

        try {
            locations = restTemplate.getForObject(url.concat(cityName), Location[].class);
        } catch (final HttpClientErrorException hce) {
            throw GoEuroErros.CLIENT_ERROR.buildException(hce);
        }
        return locations;
    }
}
