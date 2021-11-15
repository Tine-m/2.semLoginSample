package login.repositories;

import login.domain.LoginSampleException;
import login.domain.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    public void login_GivenCorrectCredentials_ShouldSucceed () throws LoginSampleException {
        UserRepository userRepo = new UserRepositoryImpl();
        User user = userRepo.login("someone@nowhere.com", "sesam");
        assertNotNull(user);
    }

    @Test
    public void login_GivenCorrectWrongUserId_ShouldThrowLoginException () throws LoginSampleException {
        UserRepository userRepo = new UserRepositoryImpl();
        assertThrows(LoginSampleException.class, () -> userRepo.login("someone@nowhere", "sesam"));
    }

    @Test
    public void login_GivenCorrectWrongPassword_ShouldThrowLoginException () throws LoginSampleException {
        UserRepository userRepo = new UserRepositoryImpl();
        assertThrows(LoginSampleException.class, () -> userRepo.login("someone@nowhere.com", "1234"));
    }

}