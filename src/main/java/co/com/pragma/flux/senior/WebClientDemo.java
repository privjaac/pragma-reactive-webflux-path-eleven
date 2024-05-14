package co.com.pragma.flux.senior;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.function.Function;

public class WebClientDemo implements Serializable {
    private final String BASE_URL = "https://example.com";
    private final String ERROR_MESSAGE = "API not found";
    WebClient webClient = WebClient.builder().baseUrl(BASE_URL).build();

    public Mono<String> getResource() {
        Function<ClientResponse, Mono<? extends Throwable>> errorHandler = response -> Mono.error(new RuntimeException(ERROR_MESSAGE));
        return null;
    }
}
