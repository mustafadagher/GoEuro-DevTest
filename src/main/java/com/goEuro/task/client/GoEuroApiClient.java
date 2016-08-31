package com.goEuro.task.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.goEuro.task.bo.Location;
import com.goEuro.task.exception.GoEuroBaseException;
import com.goEuro.task.exception.GoEuroErros;

/**
 * The Class GoEuroApiClient.
 *
 * @author mustafa.kamel
 */
@Component
public class GoEuroApiClient {

    // FIXME add to property
    @Value(value = "${goEuro.location.api.endpoint.url}")
    private transient String url;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Gets the location suggestions.
     *
     * @param cityName the city name
     * @return the location suggestions
     * @throws GoEuroBaseException
     */
    public Location[] getLocationSuggestions(final String cityName) throws GoEuroBaseException {
        Location[] locations = null;

        try {
            locations = restTemplate.getForObject(url.concat(cityName), Location[].class);
        } catch (final HttpClientErrorException hce) {
            throw GoEuroErros.CLIENT_ERROR.buildException(hce);
        }
        return locations;
    }
}
