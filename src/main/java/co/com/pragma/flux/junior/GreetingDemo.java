package co.com.pragma.flux.junior;


import lombok.SneakyThrows;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import reactor.core.publisher.Flux;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

public class GreetingDemo implements Serializable {

    @SneakyThrows
    public Flux<String> sayHello() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("people.txt");
        String people = resource.getContentAsString(StandardCharsets.UTF_8);
        return null;
    }
}
