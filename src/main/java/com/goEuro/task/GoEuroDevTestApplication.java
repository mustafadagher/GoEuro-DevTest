package com.goEuro.task;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.goEuro.task.exception.GoEuroErros;
import com.goEuro.task.service.GoEuroLocationSuggestionService;

/**
 * @author mustafa.kamel
 */
@SpringBootApplication
public class GoEuroDevTestApplication implements CommandLineRunner {

    @Autowired
    private GoEuroLocationSuggestionService goEuroLocationSuggestionService;

    public static void main(final String[] args) {
        SpringApplication.run(GoEuroDevTestApplication.class, args);
    }

    @Bean(name = "restTemplate", autowire = Autowire.BY_TYPE)
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(final String... arg0) throws Exception {

        if (arg0.length < 1) {
            throw GoEuroErros.NO_CITY_NAME_PROVIDED.buildException();
        }
        final String cityName = arg0[0];
        goEuroLocationSuggestionService.writeSuggestedLocationsToFile(cityName);

    }
}
