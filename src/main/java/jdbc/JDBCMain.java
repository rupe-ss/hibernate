package jdbc;

import jdbc.Entity.Product;
import jdbc.dao.ProductDao;

public class JDBCMain {
    public static void main(String[] args) throws Exception {
        ProductDao productDao = new ProductDao();
        Product product = productDao.getProduct(1);
        System.out.println(product.getFirstName());
    }
}
