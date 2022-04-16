package hibernate.mappingrelations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {
    @Id
    private int oid;
    private String name;
    @OneToOne
    private Laptop laptop;

    public Employee() {
    }

    public Employee(int oid, String name) {
        this.oid = oid;
        this.name = name;
    }

    public Employee(int oid, String name, Laptop laptop) {
        this.oid = oid;
        this.name = name;
        this.laptop = laptop;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "oid=" + oid +
                ", name='" + name + '\'' +
                '}';
    }
}
