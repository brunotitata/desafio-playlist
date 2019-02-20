package br.com.ifood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifood.model.PlaylistDTO;
import br.com.ifood.service.OpenWeatherCityService;
import br.com.ifood.service.OpenWeatherLatLonService;

@RestController
public class SpotifyController {

    @Autowired
    private OpenWeatherCityService openWeatherCityService;

    @Autowired
    private OpenWeatherLatLonService openWeatherLatLonService;

    @GetMapping("/cidade")
    public ResponseEntity<PlaylistDTO> sugerirTracks(
            @RequestParam String nome) {

        return ResponseEntity.ok()
                .body(openWeatherCityService.listarTracks(nome));
    }

    @GetMapping("/coordenadas")
    public ResponseEntity<PlaylistDTO> sugerirTracks(@RequestParam String lat,
            @RequestParam String lon) {

        return ResponseEntity.ok()
                .body(openWeatherLatLonService.listarTracks(lat, lon));
    }

}
