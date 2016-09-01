package com.goEuro.task;

import static org.junit.rules.ExpectedException.none;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.goEuro.task.exception.BusinessException;
import com.goEuro.task.exception.GoEuroErros;
import com.goEuro.task.service.GoEuroLocationSuggestionService;

/**
 * The Class GoEuroDevTestApplicationTest.
 *
 * @author mustafa.kamel
 */
@RunWith(MockitoJUnitRunner.class)
public class GoEuroDevTestApplicationTest {

    @InjectMocks
    private GoEuroDevTestApplication testee;

    @Mock
    private GoEuroLocationSuggestionService goEuroLocationSuggestionService;

    @Rule
    public ExpectedException thrown = none();

    /**
     * Test method for {@link com.goEuro.task.GoEuroDevTestApplication#run(java.lang.String[])}.
     *
     * @throws Exception
     */
    @Test
    public void testRun() throws Exception {
        testee.run("berlin");
        verify(goEuroLocationSuggestionService).getSuggestedLocations(anyString());
    }

    @Test
    public void testRunNoMatchFoundException() throws Exception {
        thrown.expect(BusinessException.class);
        thrown.expectMessage(GoEuroErros.NO_CITY_NAME_PROVIDED.getDescription());

        testee.run();
    }

}
