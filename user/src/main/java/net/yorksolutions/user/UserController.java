package net.yorksolutions.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(@NonNull UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    @CrossOrigin
    UUID login(@RequestParam String username, @RequestParam String password) {
        return service.login(username, password);
    }

    @GetMapping("/register")
    public void register(@RequestParam String username, @RequestParam String password) {
        service.register(username, password);
    }

    @GetMapping("/isAuthorized")
    public void isAuthorized(@RequestParam UUID token) {
        service.isAuthorized(token);
    }

    public void setService(UserService service) {
        this.service = service;
    }
}
