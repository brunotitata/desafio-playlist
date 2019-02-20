package br.com.ifood.model;

import java.math.BigDecimal;

public class PlaylistDTO {

    private BigDecimal temperatura;
    private String clima;
    private TrackDTO tracks;

    public PlaylistDTO(BigDecimal temperatura, String clima, TrackDTO tracks) {
        this.temperatura = temperatura;
        this.clima = clima;
        this.tracks = tracks;
    }

    @SuppressWarnings("unused")
    private PlaylistDTO() {
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public TrackDTO getTracks() {
        return tracks;
    }

    public void setTracks(TrackDTO tracks) {
        this.tracks = tracks;
    }

    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

}
