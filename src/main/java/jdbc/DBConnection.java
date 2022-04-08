package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
    public Connection getConnectionToAwsDatabase() throws Exception {
        /*
        Load a driver, it will throw a checked Exception so handle it.
         */
        Connection connection = null;

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://aws-my-test.c4wcvnoajtmt.us-east-1.rds.amazonaws.com:3306/test", "admin", "aws-mysql");

        return connection;
    }
}
