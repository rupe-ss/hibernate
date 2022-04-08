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
            System.out.println("Something went while fetching data." + e.getStackTrace());
        }finally {
            connection.close();
            ps.close();
            return product;
        }
    }

    public boolean addProduct(Product product1) throws Exception {
        Connection connection = getConnection();
        String query = "insert into Products values (?,?,?,?,?)";
        int row = 0;
        try{
            PreparedStatement ps = getPreparedStatement(connection, query);
            ps.setInt(1, product1.getId());
            ps.setString(2, product1.getLastName());
            ps.setString(3, product1.getFirstName());
            ps.setString(4, product1.getAddress());
            ps.setString(5, product1.getCity());
            row = ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Something went wrong while executing the update query" + e.getStackTrace());
        }finally {
            if(row > 0)
                return true;
            else return false;
        }
    }
}
