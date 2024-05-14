package co.com.pragma.flux.trainee;

import co.com.pragma.flux.util.ReactiveUtil;
import reactor.core.publisher.Flux;

import java.io.Serializable;

public class BasicDemo implements Serializable {
    public void demonstrateMapWithFluxOfStrings() {
        Flux<String> fluxOfStringNumbers = Flux.just("1", "2", "3");
        Flux<Integer> fluxOfIntegers = fluxOfStringNumbers.map(Integer::parseInt);
        ReactiveUtil.subscribe(fluxOfIntegers, "demostrateMapWithFluxOfStrings");
    }

    public void demonstrateFlatMapWithSingleValueFlux() {
        Flux<String> fluxOfStringNumbers = Flux.just("4", "5", "6");
        Flux<Integer> fluxOfIntegers = fluxOfStringNumbers.flatMap(s -> Flux.just(Integer.parseInt(s)));
        ReactiveUtil.subscribe(fluxOfIntegers, "demostrateFlatMapWithSingleValueFlux");
    }

    public void demonstrateFlatMapWithMultipleFluxes() {
        Flux<String> fluxOfStringNumbersOne = Flux.just("7", "8", "9");
        Flux<String> fluxOfStringNumbersTwo = Flux.just("10", "11", "12");
        Flux<Integer> fluxOfIntegers = Flux.concat(fluxOfStringNumbersOne, fluxOfStringNumbersTwo).flatMap(s -> Flux.just(Integer.parseInt(s)));
        ReactiveUtil.subscribe(fluxOfIntegers, "demostrateConcatAndFlatMap");
    }
}
