import jdbc.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Testing");

        DBConnection connection = new DBConnection();
        if(connection != null)
            System.out.println("Connection made to Database.");
        Connection con = connection.getConnectionToAwsDatabase();

        /*String updateQuery = "insert into Products (PersonID, LastName, FirstName, Address, City) values ('2', 'Manan', 'Roshani', '140 Mati Rd', 'Charikot')";
        String query = "SELECT * FROM Products";
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query);
        resultSet.next();
        String firstName = resultSet.getString("FirstName");
        System.out.println(firstName);
        int rows = st.executeUpdate(updateQuery);
        System.out.println("Number of rows affected: " + rows );*/

        //How to write query when data is in Variables
        String tableName = "Products";
        String query = "select * from " + tableName;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        rs.next();
        String firstName = rs.getString("FirstName");
        System.out.println(firstName);

        /*
        We have 3 types of language in Sql
        1. DDL - Data Definition Language => Creating Database table
        2. DML - Data Manipulation Language => Updating, inserting and more.
        3. DQL - Data Query Language => Fetching data from Database
        4. TCL - Transition Control Language => Grant permission, revoke permission.
         */
    }
}
