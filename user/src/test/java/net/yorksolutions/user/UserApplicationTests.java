package net.yorksolutions.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserApplicationTests {
    @LocalServerPort
    int port;

    @Test
    void contextLoads() {
    }

    @Test
    void itShouldRespondUnauthWhenTokenIsWrong() {
        TestRestTemplate rest = new TestRestTemplate();
        final UUID token = UUID.randomUUID();
        String url = "http://localhost:" + port + "/isAuthorized?token=" + token;
        final ResponseEntity<Void> response = rest.getForEntity(url, Void.class);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

//    @Test
//    void itShouldRespondOKWhenTokenIsGood() {
//        TestRestTemplate rest = new TestRestTemplate();
//        final UUID token = UUID.randomUUID();
//        String url = "http://localhost:" + port + "/isAuthorized?token=" + token;
//        final ResponseEntity<Void> response = rest.getForEntity(url, Void.class);
//        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
//    }

}
