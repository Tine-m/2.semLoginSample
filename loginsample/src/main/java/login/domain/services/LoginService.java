package login.domain.services;

import login.repositories.UserRepository;
import login.domain.LoginSampleException;
import login.domain.models.User;
import login.repositories.UserRepositoryImpl;

//AKA GRASP Controller
public class LoginService {

    private UserRepository userRepository = null;

    // Dependency injection
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String email, String password) throws LoginSampleException {
        return userRepository.login(email, password);
    }

    public User createUser(String email, String password) throws LoginSampleException {
        // By default, new users are customers
        User user = new User(email, password, "customer");
        return userRepository.createUser(user);
    }
}
