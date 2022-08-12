package com.arc.arcbatch.greeting;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest
public class GreetingRouterTest {
    @Autowired
    WebTestClient webTestClient;

    @Before
    public void setup() {
        String baseUri = "http://localhost:8080";
        this.webTestClient = WebTestClient.bindToServer().baseUrl(baseUri).build();
    }

    @Test
    public void GreetingTest() throws Exception {
        webTestClient.get()
                .uri("/hello")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Hello, Arc Choi!")
        ;

    }
}