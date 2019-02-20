package br.com.ifood.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ifood.model.TokenResource;
import br.com.ifood.model.TrackResource;
import br.com.ifood.service.exception.ArgumentInvalidException;

@Service
public class SpotifyService {

    private SpotifyTokenService spotifyTokenService;
    private RestTemplate restTemplate;
    private String spotifyUrl;

    public SpotifyService(TokenResource token, RestTemplate restTemplate,
            @Value("${spotify.search.url}") String spotifyUrl,
            SpotifyTokenService spotifyTokenService) {
        this.restTemplate = restTemplate;
        this.spotifyUrl = spotifyUrl;
        this.spotifyTokenService = spotifyTokenService;
    }

    private HttpEntity<String> header() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",
                "Bearer " + spotifyTokenService.capturarToken());

        return new HttpEntity<String>(headers);

    }

    public TrackResource buscarMusicas(String genero) {

        return restTemplate.exchange(urlQuery(genero), HttpMethod.GET, header(),
                TrackResource.class).getBody();

    }

    private String urlQuery(String genero) {
        try {
            String uri = UriComponentsBuilder.fromUriString(spotifyUrl)
                    .queryParam("q", genero).queryParam("type", "track")
                    .queryParam("limit", "10").toUriString();

            return URLDecoder.decode(uri, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new ArgumentInvalidException(
                    "Error ao montar URL: " + e.getMessage());
        }
    }

}
