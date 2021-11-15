package login.repositories;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBManagerTest {

    @Test
    public void test_GetConnectionToDatabase() {
        Connection conn = DBManager.getConnection();
        assertNotNull(conn);
    }
    @Test
    public void test_ConnectionIsSingleton() {
        Connection conn1 = DBManager.getConnection();
        Connection conn2 = DBManager.getConnection();
        assertEquals(conn1,conn2);
    }


}