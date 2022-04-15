package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
Add, dependency
Here, we will create and add rows in Database Table.
So, I have a Student class in this package. We will use this class as Entity class or pojo class.
To use hibernate save() method we need session Object.
Session is interface so we need a Object that implements Session.
To create Session Object we need SessionFactory Object.
Again to create SessionFactory Object we need Configuration class.
After all this we can use save() method to save student in database.
To make things easier we need

How to create configure file ?
 */
public class HibernateMain {
    static HibernateSetup hs = new HibernateSetup();
    public static void main(String[] args) {
        //addStudent(3, "Champa", 2.9);
        System.out.println(getStudent(1));
    }

    public static void addStudent(int id, String name, double gpa){
        Student student = new Student(id, name,gpa);
        hs.getSession().save(student);
        hs.getTransaction().commit();
    }

    public static Student getStudent(int id){
        Student student = new Student();
        student = hs.getSession().get(Student.class,id);
        return student;
    }

}
class HibernateSetup{
    //We need to provide configure file for Configuration Object, we need configure() method to do it.
    Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
    SessionFactory sf = con.buildSessionFactory();
    Session session = sf.openSession();

    public Session getSession(){
        return session;
    }

    public Transaction getTransaction(){
        Transaction transaction = session.beginTransaction();
        return transaction;
    }
}


