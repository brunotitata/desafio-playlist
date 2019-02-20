package br.com.ifood.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.ifood.model.TokenResource;

@Service
public class SpotifyTokenService {

    private String urlToken;
    private RestTemplate restTemplate;

    public SpotifyTokenService(@Value("${spotify.token.url}") String urlToken,
            @Qualifier("restTemplateSpotify") RestTemplate restTemplate,
            TokenResource token) {
        this.urlToken = urlToken;
        this.restTemplate = restTemplate;
    }

    public String capturarToken() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
        param.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(
                param, headers);

        return restTemplate
                .postForObject(urlToken, request, TokenResource.class)
                .getAccessToken();
    }

}
