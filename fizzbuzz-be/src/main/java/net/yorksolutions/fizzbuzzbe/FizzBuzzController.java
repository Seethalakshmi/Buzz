package net.yorksolutions.fizzbuzzbe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class FizzBuzzController {
    FizzBuzzService service;

    @Autowired
    public FizzBuzzController(@NonNull FizzBuzzService service) {
        this.service = service;
    }

    @GetMapping("/fizzbuzz")
    @CrossOrigin
    String fizzbuzz(@RequestParam UUID token, @RequestParam Integer input) {
        return service.fizzbuzz(token, input);
    }

    @GetMapping("/ip")
    public IP ip(@RequestParam UUID token, HttpServletRequest request) {
        return service.ip(token, request);
    }

    public void setService(FizzBuzzService service) {
        this.service = service;
    }
}
