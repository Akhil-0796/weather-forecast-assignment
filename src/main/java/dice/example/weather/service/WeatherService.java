package dice.example.weather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${rapidapi.key}")
    private String apiKey;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getForecastSummary(String city, String rapidApiKey) {
        if (!rapidApiKey.equals(apiKey)) {
            return "Invalid API Key";
        }

        String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/" + city + "/summary/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    public String getHourlyForecast(String city, String rapidApiKey) {
        if (!rapidApiKey.equals(apiKey)) {
            return "Invalid API Key";
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        //https://forecast9.p.rapidapi.com/rapidapi/forecast/Berlin/hourly/
        String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/" + city + "/hourly/";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}
