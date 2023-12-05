package test.server.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.server.demo.security.MyUserDetailsService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private MyUserDetailsService userDetailsService;

    @GetMapping("/get-logged-in-username")
    public Map<String, String> getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Map<String, String> response = new HashMap<>();
        response.put("userName", username);

        return response;
    }
}

