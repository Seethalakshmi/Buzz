package net.yorksolutions.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserAccountRepository repository;
    private final HashMap<UUID, Long> tokenMap;

    @Autowired
    public UserController(@NonNull UserAccountRepository repository) {
        this.repository = repository;
        tokenMap = new HashMap<>();
    }

    public UserController(@NonNull UserAccountRepository repository,
                          @NonNull HashMap<UUID, Long> tokenMap) {
        this.repository = repository;
        this.tokenMap = tokenMap;
    }

    @GetMapping("/login")
    UUID login(@RequestParam String username, @RequestParam String password) {
        var result = repository.findByUsernameAndPassword(username, password);

        if (result.isEmpty())
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

        final var token = UUID.randomUUID();
        tokenMap.put(token, result.get().id);
        return token;
    }

    @GetMapping("/register")
    public void register(@RequestParam String username, @RequestParam String password) {
        if (repository.findByUsername(username).isPresent())
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        repository.save(new UserAccount());
    }
}
