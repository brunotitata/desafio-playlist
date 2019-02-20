package br.com.ifood.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.ifood.model.enums.Clima;

@Component
public class TemperatureService {

    public static String capturarClima(BigDecimal temperatura) {

        if (temperatura.compareTo(new BigDecimal(10.0)) < 0) {
            return Clima.CLASSICAL.name();

        } else if (isBetween(temperatura, new BigDecimal(10.0),
                new BigDecimal(14.0))) {
            return Clima.ROCK.name();

        } else if (isBetween(temperatura, new BigDecimal(15.0),
                new BigDecimal(30.0))) {
            return Clima.POP.name();

        } else
            return Clima.PARTY.name();

    }

    private static <T extends Comparable<T>> boolean isBetween(T value, T start,
            T end) {
        return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
    }

}
