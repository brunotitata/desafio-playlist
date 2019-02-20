package br.com.ifood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class IfoodTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(IfoodTestApplication.class, args);
    }

}
