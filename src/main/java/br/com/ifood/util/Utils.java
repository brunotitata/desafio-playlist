package br.com.ifood.util;

import br.com.ifood.service.exception.NotFoundException;

public class Utils {

    public static void assertArgumentNotEmpty(String field, String errMessage) {
        if (field == null || field.isEmpty())
            throw new NotFoundException(errMessage);
    }

    public static void assertArgumentNotNull(Object obj, String errMessage) {
        if (obj == null)
            throw new NotFoundException(errMessage);
    }

}
