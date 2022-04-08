package jdbc.dao;

import jdbc.DBConnection;
import jdbc.Entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao {

    public Product getProduct() {
        return new Product();
    }

    public DBConnection getDbConnection(){
        return new DBConnection();
    }

    public Connection getConnection() throws Exception {
        return getDbConnection().getConnectionToAwsDatabase();
    }

    public PreparedStatement getPreparedStatement(Connection connection, String query) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        return ps;
    }

    public Product getProduct(int id) throws Exception {
        Product product = getProduct();
        String query = "select * from Products where PersonID = ?";
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        try {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            product.setId(id);
            product.setFirstName(rs.getString("FirstName"));
            product.setLastName(rs.getString("LastName"));
        }catch (Exception e){

        }finally {
            connection.close();
            ps.close();
            return product;
        }
    }
}
