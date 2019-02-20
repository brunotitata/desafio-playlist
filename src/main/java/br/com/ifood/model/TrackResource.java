package br.com.ifood.model;

import java.util.List;

public class TrackResource {

    private Track tracks;

    public TrackResource(Track tracks) {
        this.tracks = tracks;
    }

    @SuppressWarnings("unused")
    private TrackResource() {
    }

    public Track getTracks() {
        return tracks;
    }

    public void setTracks(Track tracks) {
        this.tracks = tracks;
    }

    public static class Track {
        private List<Items> items;

        public Track(List<Items> items) {
            this.items = items;
        }

        @SuppressWarnings("unused")
        private Track() {
        }

        public List<Items> getItems() {
            return items;
        }

        public void setItems(List<Items> items) {
            this.items = items;
        }

        @Override
        public String toString() {
            return "Track [items=" + items + "]";
        }

        public static class Items {
            private String name;

            public Items(String name) {
                this.name = name;
            }

            @SuppressWarnings("unused")
            private Items() {
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Items [name=" + name + "]";
            }

        }

    }

    @Override
    public String toString() {
        return "TrackResource [tracks=" + tracks + "]";
    }

}
