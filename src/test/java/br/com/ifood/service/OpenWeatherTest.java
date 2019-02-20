package br.com.ifood.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenWeatherTest {

    private static final String URL = "http://api.openweathermap.org/data/2.5/find?q=Santos&units=metric&appid=34f1fd102e088625bd39bd50719469b6";

    private OpenWeatherCityService service;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private SpotifyService spotifyService;

    @Value("${open.weather.map.key}")
    String secretId;

    @Value("${open.weather.map.url}")
    String urlWeather;

    @Value("${open.weather.map.units}")
    String units;

    @Before
    public void setUp() {
        this.service = new OpenWeatherCityService(restTemplate, secretId,
                urlWeather, units, spotifyService);
    }

    @Test
    public void buscarTemperatura() {

    }

}
