package br.com.ifood.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3407985342132249754L;

    public NotFoundException(String msg) {
        super(msg);
    }
}
