package login.repositories;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCTestFixture {

    public void setUp() {
        try {
            Connection connection = DBManager.getConnection();
            Statement st = connection.createStatement();
            // start transaction
            connection.setAutoCommit(false);

            // create
            st.addBatch("drop table users ");
            st.addBatch("create table users(" +
                    "  id INT NOT NULL AUTO_INCREMENT," +
                    "  email VARCHAR(90) NOT NULL," +
                    "  password VARCHAR(45) NOT NULL," +
                    "  role VARCHAR(20) NOT NULL DEFAULT 'customer'," +
                    "   PRIMARY KEY (id)," +
                    "  UNIQUE INDEX email_UNIQUE (email ASC) VISIBLE) ");

            // insert
            st.addBatch("insert into users (email, password) values ('someone@nowhere.com','sesam')");
            st.addBatch("insert into users (email, password, role) values ('me@anywhere.com','secret', 'employee')");

            int[] updateCounts = st.executeBatch();
            // end transaction

            connection.commit();

        } catch (Exception e) {
            System.out.println("Fail in JDBCTestFixture - setup");
            System.out.println(e.getMessage());
        }
    }

}
