package co.com.pragma.flux.junior;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class GreetingDemoTest {

    @Test
    void testSayHello() {
        String hello = "Hola";
        String howAreYou = "¿Cómo estás?";
        GreetingDemo demo = new GreetingDemo();
        Flux<String> greetings = demo.sayHello();
        StepVerifier
                .create(greetings)
                .thenConsumeWhile(greeting -> greeting.startsWith(hello) && greeting.endsWith(howAreYou))
                .verifyComplete();
    }
}
