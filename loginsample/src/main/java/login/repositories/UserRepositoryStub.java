package login.repositories;

import login.domain.LoginSampleException;
import login.domain.models.User;

public class UserRepositoryStub implements UserRepository {
    @Override
    public User login(String email, String password) throws LoginSampleException {
        User user = new User("test@test.com", "test", "customer");
        user.setId(1);
        return user;
    }

    @Override
    public User createUser(User user) throws LoginSampleException {
        return null;
    }
}
