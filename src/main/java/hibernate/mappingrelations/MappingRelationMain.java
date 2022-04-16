package hibernate.mappingrelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingRelationMain {
    public static void main(String[] args) {

        Laptop laptop = new Laptop(1000, "Dell");
        Employee employee = new Employee(100, "Chad", laptop);

        Configuration configuration = new Configuration().configure("embedded.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(employee);
        session.save(laptop);

        transaction.commit();
    }
}
