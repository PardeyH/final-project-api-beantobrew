package test.server.demo.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.server.demo.user.User;
import test.server.demo.user.UserRepository;

import java.util.Optional;

@RestController
public class RegistrationController {

    private final MyUserDetailsService userDetailsService;
    private final UserRepository userRepository;

    public RegistrationController(MyUserDetailsService userDetailsService, UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User newUser) {
        if (!StringUtils.hasLength(newUser.getUserName()) || !StringUtils.hasLength(newUser.getPassword())) {
            return new ResponseEntity<>("Username and password are required", HttpStatus.BAD_REQUEST);
        }

        Optional<User> existingUser = userRepository.findByUserName(newUser.getUserName());

        if (existingUser.isPresent()) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        } else {
            User user = userDetailsService.saveUser(newUser);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
    }

    @GetMapping(path = "/current-user")
    public String foo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        return null;
    }

}