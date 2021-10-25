package login.domain;

import login.data.UserRepository;

public class LoginService {

    private UserRepository userRepository = null;

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
