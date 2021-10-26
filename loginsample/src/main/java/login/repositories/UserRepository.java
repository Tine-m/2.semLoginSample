package login.repositories;

import login.domain.LoginSampleException;
import login.domain.models.User;

public interface UserRepository {

    public User login(String email, String password) throws LoginSampleException;
    public User createUser(User user) throws LoginSampleException;

}