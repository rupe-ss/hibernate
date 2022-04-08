package jdbc;

import jdbc.Entity.Product;
import jdbc.dao.ProductDao;

public class JDBCMain {
    public static void main(String[] args) throws Exception {
        /*//Fetching data from database
        ProductDao productDao = new ProductDao();
        Product product = productDao.getProduct(1);
        System.out.println(product.getFirstName());*/

        //Let's create a Object of class Product and Update data to database
        Product product1 = new Product();
        product1.setId(4);
        product1.setFirstName("Chandra");
        product1.setLastName("Jodaic");
        product1.setAddress("123 Balbitar St");
        product1.setCity("Chandani");

        ProductDao productDao = new ProductDao();
        boolean check = productDao.addProduct(product1);
        if(check){
            System.out.println("Database updated successfully.");
        } else{
            System.out.println("Something went wrong.");
        }
    }
}
