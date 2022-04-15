package hibernate.embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
This is a main practice class for Embedded annotation.
Steps
1. Create a connection, it is done by configuration
 */
public class EmbeddedMain {
    public static void main(String[] args) {
        Address address = new Address(1202, "High Hill", "Luca", "OH", 3456);
        Person person = new Person(234, "Tan", "Colie", "", address);
        Configuration configure = new Configuration().configure("embedded.cfg.xml").addAnnotatedClass(Person.class);
        SessionFactory sf = configure.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
    }
}
