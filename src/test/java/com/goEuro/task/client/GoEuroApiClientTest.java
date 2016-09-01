package com.goEuro.task.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.goEuro.task.bo.Location;
import com.goEuro.task.exception.BusinessException;
import com.goEuro.task.exception.GoEuroBaseException;
import com.goEuro.task.exception.GoEuroErros;
import com.goEuro.task.exception.SystemException;

/**
 * The Class GoEuroApiClientTest.
 *
 * @author mustafa.kamel
 */
@RunWith(MockitoJUnitRunner.class)
public class GoEuroApiClientTest {

    @InjectMocks
    private GoEuroApiClient testee;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(testee, "url", "http://api.goeuro.com/api/v2/position/suggest/en/");
    }

    @Rule
    public ExpectedException thrown = none();

    /**
     * Test get location suggestions.
     *
     * @throws GoEuroBaseException
     */
    @Test
    public void testGetLocationSuggestions() throws GoEuroBaseException {

        // given
        when(restTemplate.getForObject(anyString(), any())).thenReturn(getDummyLocations());

        // when
        final Location[] result = testee.getLocationSuggestions("berlin");

        // then
        assertNotNull(result);
        assertTrue(result.length > 0);
    }

    /**
     * Test get location suggestions with empty url.
     *
     * @throws GoEuroBaseException the go euro base exception
     */
    @Test
    public void testGetLocationSuggestionsEmptyUrl() throws GoEuroBaseException {
        // expect
        thrown.expect(BusinessException.class);
        thrown.expectMessage(GoEuroErros.EMPTY_URL_EXCEPTION.getDescription());

        // given
        ReflectionTestUtils.setField(testee, "url", "");

        // when
        testee.getLocationSuggestions("berlin");
    }

    /**
     * Test get location suggestions with client exception.
     *
     * @throws GoEuroBaseException the go euro base exception
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetLocationSuggestionsClientException() throws GoEuroBaseException {
        // expect
        thrown.expect(SystemException.class);
        thrown.expectMessage(GoEuroErros.CLIENT_ERROR.getDescription());

        // given
        when(restTemplate.getForObject(anyString(), any())).thenThrow(HttpClientErrorException.class);

        // when
        testee.getLocationSuggestions("berlin");
    }

    private Location[] getDummyLocations() {
        final Location loc1 = new Location();
        final Location loc2 = new Location();

        final Location[] locations = { loc1, loc2 };

        return locations;
    }

}
