package co.com.pragma.flux.util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;

public class ReactiveUtil implements Serializable {

    public static <T> void subscribe(Flux<T> flux, String demoMethod) {
        System.out.println("\nStarting " + demoMethod + ":");
        flux.subscribe(
                value -> System.out.println("Next: " + value),
                error -> System.out.println("Error, end of flow for: " + demoMethod + ":" + error),
                () -> System.out.println("Success, end of flow for " + demoMethod)
        );
    }

    public static <T> void subscribe(Mono<T> mono, String demoMethod) {
        System.out.println("\nStarting " + demoMethod + ":");
        mono.subscribe(
                value -> System.out.println("Next: " + value),
                error -> System.out.println("Error, end of flow for: " + demoMethod + ":" + error),
                () -> System.out.println("Success, end of flow for " + demoMethod)
        );
    }
}
