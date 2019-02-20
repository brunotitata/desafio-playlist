package br.com.ifood.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.ifood.model.ItemsDTO;
import br.com.ifood.model.OpenWeatherResource;
import br.com.ifood.model.PlaylistDTO;
import br.com.ifood.model.TrackDTO;
import br.com.ifood.model.TrackResource.Track.Items;
import br.com.ifood.service.exception.ArgumentInvalidException;
import br.com.ifood.util.Utils;

@Service
public class OpenWeatherCityService {

    private static final Logger LOG = Logger
            .getLogger(OpenWeatherCityService.class);

    private RestTemplate restTemplate;
    private String secretId;
    private String urlWeather;
    private String units;
    private SpotifyService spotifyService;

    public OpenWeatherCityService(RestTemplate restTemplate,
            @Value("${open.weather.map.key}") String secretId,
            @Value("${open.weather.map.url}") String urlWeather,
            @Value("${open.weather.map.units}") String units,
            SpotifyService spotifyService) {
        this.restTemplate = restTemplate;
        this.secretId = secretId;
        this.urlWeather = urlWeather;
        this.units = units;
        this.spotifyService = spotifyService;
    }

    @HystrixCommand(fallbackMethod = "acionarMetodoFallBack")
    private OpenWeatherResource consumirServicoApi(String cidade) {

        Utils.assertArgumentNotEmpty(cidade,
                "Campo cidade não pode ser vazio ou nulo.");

        OpenWeatherResource informacoes = restTemplate.getForObject(
                urlHttpOpenWeather(cidade), OpenWeatherResource.class);

        if (informacoes.getList().isEmpty())
            throw new ArgumentInvalidException(
                    "Não foi possivel capturar a temperatura da cidade: "
                            + cidade);

        return informacoes;

    }

    public void acionarMetodoFallBack() {
        LOG.error(
                "Obteve um error ao consumir API. Por favor tente novamente mais tarde.");
    }

    private String urlHttpOpenWeather(String cidade) {

        try {
            String query = UriComponentsBuilder.fromHttpUrl(urlWeather)
                    .queryParam("q", cidade).queryParam("units", units)
                    .queryParam("appid", secretId).toUriString();

            return URLDecoder.decode(query, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            throw new ArgumentInvalidException(
                    "Error ao montar URL: " + e.getMessage());
        }
    }

    private BigDecimal capturarTemperatura(String cidade) {

        return consumirServicoApi(cidade).getList().stream()
                .map(m -> m.getMain().getTemp()).findFirst().get().setScale(2);
    }

    public PlaylistDTO listarTracks(String cidade) {

        String genero = TemperatureService
                .capturarClima(capturarTemperatura(cidade));

        List<Items> items = spotifyService.buscarMusicas(genero).getTracks()
                .getItems();

        List<ItemsDTO> item = new ArrayList<>();

        for (Items nome : items) {
            item.add(new ItemsDTO(nome.getName()));
        }

        return new PlaylistDTO(capturarTemperatura(cidade), genero,
                new TrackDTO(item));
    }

}
