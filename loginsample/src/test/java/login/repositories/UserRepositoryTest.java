package login.repositories;

import login.domain.LoginSampleException;
import login.domain.models.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    public void login_GivenCorrectCredentials () throws LoginSampleException {
        // Arrange
        UserRepository userRepo = new UserRepositoryImpl();
        //Act
        User user = userRepo.login("someone@nowhere.com", "sesam");
        //Assert
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

    @Test
    public void createUser_GivenCorrectUserInfo () throws LoginSampleException {
        //Arrange
        UserRepository userRepo = new UserRepositoryImpl();
        User user = new User("tine@kea.dk", "tine", "customer");
        //Act
        User newUser = userRepo.createUser(user);
        //Assert
        assertTrue(user.getId() != 0);
    }

    @Test
    public void createUser_EmailExistingAlready_ShouldThrowException() throws LoginSampleException {
        //Arrange
        UserRepository userRepo = new UserRepositoryImpl();
        User user1 = new User("tine1@kea.dk", "tine", "customer");
        User user2 = new User("tine1@kea.dk", "tine", "customer");
        //Act
        userRepo.createUser(user1);
        //Assert
        assertThrows(LoginSampleException.class, () -> userRepo.createUser(user2));
    }

}