package login.repositories;

import login.domain.LoginSampleException;
import login.domain.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest2 {

    UserRepository userRepo;
    JDBCTestFixture fixture;

    @BeforeEach
    public void setUp() throws Exception
    {
        fixture = new JDBCTestFixture();
        fixture.setUp();
        userRepo = new UserRepositoryImpl();
    }

    @Test
    public void login_GivenCorrectCredentials () throws LoginSampleException {
        User user = userRepo.login("someone@nowhere.com", "sesam");
        assertNotNull(user);
        assertEquals("someone@nowhere.com",user.getEmail());
    }

    @Test
    public void createUser_GivenCorrectUserInfo () throws LoginSampleException {
        User user = new User("tine@kea.dk", "tine", "customer");
        //Act
        User newUser = userRepo.createUser(user);
        assertTrue(user.getId() != 0);
        assertEquals("tine@kea.dk",user.getEmail());
        assertEquals("tine",user.getPassword());
        // The following is dependent on other method
        //User userDB = userRepo.login("tine@kea.dk", "tine");
        //assertNotNull(userDB);
    }

}
