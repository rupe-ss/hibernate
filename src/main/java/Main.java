import jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

        /*//How to write query when data is in Variables
        String tableName = "Products";
        String query = "select * from " + tableName;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        rs.next();
        String firstName = rs.getString("FirstName");
        System.out.println(firstName);*/

        //Prepared Statements
        int id = 3;
        String firstName = "Rupa";
        String lastName = "Thapa";
        String address = "234 Dada Pari";
        String city = "Chari";
        String query = "insert into Products values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, lastName);
        ps.setString(3, firstName);
        ps.setString(4, address);
        ps.setString(5, city);
        int count = ps.executeUpdate();
        System.out.println("Row/s affected: " + count);

        /*
        We have 3 types of language in Sql
        1. DDL - Data Definition Language => Creating Database table
        2. DML - Data Manipulation Language => Updating, inserting and more.
        3. DQL - Data Query Language => Fetching data from Database
        4. TCL - Transition Control Language => Grant permission, revoke permission.
         */
    }
}
