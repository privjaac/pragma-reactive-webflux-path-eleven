package co.com.pragma.flux.senior;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@SpringBootTest
class WebClientDemoTest {
    private WebClientDemo webClientDemoMock;

    @BeforeEach
    void setUp() {
        webClientDemoMock = Mockito.mock(WebClientDemo.class);
    }

    @Test
    void getResourceWhenApiCallNotFound() {
        String ERROR_MESSAGE = "API not found";
        when(this.webClientDemoMock.getResource()).thenReturn(Mono.error(new RuntimeException(ERROR_MESSAGE)));
        StepVerifier
                .create(this.webClientDemoMock.getResource())
                .expectErrorMessage(ERROR_MESSAGE)
                .verify();
    }
}
