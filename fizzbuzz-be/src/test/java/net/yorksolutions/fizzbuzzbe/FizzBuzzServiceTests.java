package net.yorksolutions.fizzbuzzbe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FizzBuzzServiceTests {

    @InjectMocks
    @Spy
    FizzBuzzController controller;

    @Mock
    HttpServletRequest request;

    @Mock
    RestTemplate rest;

//    @Test
//    void itShouldThrowUnauthWhenOtherStatusIsUnauth() {
//        final UUID token = UUID.randomUUID();
//        String url = "http://localhost:8081/isAuthorized?token=" + token;
//        when(rest.getForEntity(url, Void.class))
//                .thenReturn(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
//        final ResponseStatusException exception = assertThrows(ResponseStatusException.class,
//                () -> controller.checkAuthorized(token));
//        assertEquals(HttpStatus.UNAUTHORIZED, exception.getStatus());
//    }
//
//    @Test
//    void itShouldThrowIntErrWhenOtherStatusIsOther() {
//        final UUID token = UUID.randomUUID();
//        String url = "http://localhost:8081/isAuthorized?token=" + token;
//        when(rest.getForEntity(url, Void.class))
//                .thenReturn(new ResponseEntity<>(HttpStatus.CONFLICT));
//        final ResponseStatusException exception = assertThrows(ResponseStatusException.class,
//                () -> controller.checkAuthorized(token));
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatus());
//    }
//
//    @Test
//    void itShouldNotThrowWhenOtherStatusIsOK() {
//        final UUID token = UUID.randomUUID();
//        String url = "http://localhost:8081/isAuthorized?token=" + token;
//        when(rest.getForEntity(url, Void.class))
//                .thenReturn(new ResponseEntity<>(HttpStatus.OK));
//        assertDoesNotThrow(() -> controller.checkAuthorized(token));
//    }
//
//    @Test
//    void itShouldReturnTheClientsIP() {
//        final String ip = "1.2.3.4";
//        final IP expected = new IP(ip);
//        final var token = UUID.randomUUID();
//        when(request.getRemoteAddr()).thenReturn(ip);
//        doNothing().when(controller).checkAuthorized(any());
//        assertEquals(expected, controller.ip(token, request));
//    }
//
//    @Test
//    void itShouldCallPlay() {
//        final String expected = "some string";
//        final var token = UUID.randomUUID();
//
//        doNothing().when(controller).checkAuthorized(any());
//        try (final var mocked = Mockito.mockStatic(FizzBuzz.class)) {
//            mocked.when(() -> FizzBuzz.play(99)).thenReturn(expected);
//            assertEquals(expected, controller.fizzbuzz(token, 99));
//        }
//    }
}
