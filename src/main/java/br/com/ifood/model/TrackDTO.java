package br.com.ifood.model;

import java.util.List;

public class TrackDTO {

    private List<ItemsDTO> items;

    public TrackDTO(List<ItemsDTO> items) {
        this.items = items;
    }

    @SuppressWarnings("unused")
    private TrackDTO() {
    }

    public List<ItemsDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemsDTO> items) {
        this.items = items;
    }

}
