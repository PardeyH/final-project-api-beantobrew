package test.server.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.server.demo.user.User;
import test.server.demo.user.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createJohnDoeUser() {
        User johnDoe = new User();
        johnDoe.setUserName("JohnDoe");

        userRepository.save(johnDoe);
    }
}
