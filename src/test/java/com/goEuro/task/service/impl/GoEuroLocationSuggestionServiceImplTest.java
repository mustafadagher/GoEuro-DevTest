/**
 *
 */
package com.goEuro.task.service.impl;

import static org.junit.rules.ExpectedException.none;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.goEuro.task.bo.Location;
import com.goEuro.task.client.GoEuroApiClient;
import com.goEuro.task.exception.BusinessException;
import com.goEuro.task.exception.GoEuroBaseException;
import com.goEuro.task.exception.GoEuroErros;
import com.goEuro.task.util.CsvUtils;

/**
 * The Class GoEuroLocationSuggestionServiceImplTest.
 *
 * @author mustafa.kamel
 */
@RunWith(MockitoJUnitRunner.class)
public class GoEuroLocationSuggestionServiceImplTest {

    @InjectMocks
    private GoEuroLocationSuggestionServiceImpl testee;

    @Mock
    private GoEuroApiClient goEuroApiClient;

    @Mock
    private CsvUtils csvUtils;

    @Rule
    public ExpectedException thrown = none();

    /**
     * Test method for
     * {@link com.goEuro.task.service.impl.GoEuroLocationSuggestionServiceImpl#getSuggestedLocations(java.lang.String)}.
     *
     * @throws GoEuroBaseException
     */
    @Test
    public void testGetSuggestedLocations() throws GoEuroBaseException {
        // given
        when(goEuroApiClient.getLocationSuggestions(anyString())).thenReturn(getDummyLocations());
        doNothing().when(csvUtils).writeToCsvFile(anyString(), any(Location[].class));

        // when
        testee.getSuggestedLocations("berlin");

        // then
        verify(csvUtils).writeToCsvFile(anyString(), any(Location[].class));
    }

    @Test
    public void testGetSuggestedLocationsNoMatchFound() throws GoEuroBaseException {
        // expect
        thrown.expect(BusinessException.class);
        thrown.expectMessage(GoEuroErros.NO_MATCH_FOUND.getDescription());

        // given
        when(goEuroApiClient.getLocationSuggestions(anyString())).thenReturn(null);

        // when
        testee.getSuggestedLocations("berlin");
    }

    private Location[] getDummyLocations() {
        final Location loc1 = new Location();
        final Location loc2 = new Location();

        final Location[] locations = { loc1, loc2 };

        return locations;
    }

}
