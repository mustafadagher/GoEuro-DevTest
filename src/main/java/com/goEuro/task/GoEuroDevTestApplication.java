package com.goEuro.task;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import com.goEuro.task.exception.GoEuroErros;
import com.goEuro.task.service.GoEuroLocationSuggestionService;

/**
 * @author mustafa.kamel
 */
@SpringBootApplication
@PropertySource("classpath:goEuro.properties")
public class GoEuroDevTestApplication implements CommandLineRunner {

    @Autowired
    private GoEuroLocationSuggestionService goEuroLocationSuggestionService;

    public static void main(final String[] args) {
        SpringApplication.run(GoEuroDevTestApplication.class, args);
    }

    @Bean(name = "restTemplate")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(final String... arg0) throws Exception {

        /*
         * while running/debugging the project as a spring boot app, the args contains this argument
         * "--spring.output.ansi.enabled"
         */
        final String cityName = Arrays.stream(arg0).filter(arg -> !arg.contains("--spring.output.ansi.enabled")).findFirst().orElse(null);

        if (cityName == null || cityName.trim().isEmpty()) {
            throw GoEuroErros.NO_CITY_NAME_PROVIDED.buildException();
        }

        goEuroLocationSuggestionService.getSuggestedLocations(cityName.trim());

    }
}
