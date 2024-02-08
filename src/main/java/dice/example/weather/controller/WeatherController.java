package dice.example.weather.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dice.example.weather.model.ForecastLocation;
import dice.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    private final String rapidApiKey;

    public WeatherController(WeatherService weatherService, @Value("${rapidapi.key}") String rapidApiKey) {
        this.weatherService = weatherService;
        this.rapidApiKey = rapidApiKey;
    }

    /***
     * api to fetch weather forecast summary by location name
     * @param city
     * @param clientId
     * @param clientSecret
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/RapidApiGetForecastSummaryByLocationName")
    public ResponseEntity<ForecastLocation> getForecastSummary(@RequestParam String city,
                                                               @RequestHeader("X-Client-ID") String clientId,
                                                               @RequestHeader("X-Client-Secret") String clientSecret) throws JsonProcessingException {
        // Perform authentication with clientId and clientSecret
        if (!authenticate(clientId, clientSecret)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String forecastSummary = weatherService.getForecastSummary(city,rapidApiKey);
        ObjectMapper objectMapper = new ObjectMapper();
        ForecastLocation weatherForecast = objectMapper.readValue(forecastSummary, ForecastLocation.class);
        return ResponseEntity.ok(weatherForecast);
    }

    /***
     * api to fetch hourly weather information by location name
     * @param city
     * @param clientId
     * @param clientSecret
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/hourly-forecast")
    public ResponseEntity<ForecastLocation> getHourlyForecast(@RequestParam String city,
                                                              @RequestHeader("Client-ID") String clientId,
                                                              @RequestHeader("Client-Secret") String clientSecret) throws JsonProcessingException {
        // Perform authentication with clientId and clientSecret
        if (!authenticate(clientId, clientSecret)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String hourlyForecast = weatherService.getHourlyForecast(city,rapidApiKey);
        ObjectMapper objectMapper = new ObjectMapper();
        ForecastLocation weatherForecast = objectMapper.readValue(hourlyForecast, ForecastLocation.class);
        return ResponseEntity.ok(weatherForecast);
    }

    // Method to authenticate client ID and client secret
    private boolean authenticate(String clientId, String clientSecret) {
        // we can implement our authentication logic here.
        return clientId != null && !clientId.isEmpty() && clientSecret != null && !clientSecret.isEmpty();
    }
}