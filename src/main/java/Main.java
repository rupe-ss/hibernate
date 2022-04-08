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

//        String query = "insert into test.Products (PersonID, LastName, FirstName, Address, City) values (\"2\", \"Manan\", \"Roshani\", \"140 Mati Rd\", \"Charikot\");";
        String query = "SELECT * FROM Products";
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query);
        resultSet.next();
        String firstName = resultSet.getString("FirstName");
        System.out.println(firstName);
    }
}
