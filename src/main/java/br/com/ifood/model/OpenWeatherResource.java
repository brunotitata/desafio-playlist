
package br.com.ifood.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "message", "cod", "count", "list" })
public class OpenWeatherResource {

    @JsonProperty("message")
    private String message;
    @JsonProperty("cod")
    private String cod;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("list")
    private List<ListInfo> list = null;

    public List<ListInfo> getList() {
        return list;
    }

    public void setList(List<ListInfo> list) {
        this.list = list;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({ "temp" })
    public static class Main {

        private BigDecimal temp;

        public BigDecimal getTemp() {
            return temp;
        }

        private Main() {
        }

        public void setTemp(BigDecimal temp) {
            this.temp = temp;
        }

        @Override
        public String toString() {
            return "Main [temp=" + temp + "]";
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({ "main" })
    public static class ListInfo {

        private Main main;

        public ListInfo(Main main) {
            this.main = main;
        }

        @SuppressWarnings("unused")
        private ListInfo() {
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        @Override
        public String toString() {
            return "ListInfo [main=" + main + "]";
        }

    }

    @Override
    public String toString() {
        return "OpenWeatherResource [message=" + message + ", cod=" + cod
                + ", count=" + count + ", list=" + list + "]";
    }

}
