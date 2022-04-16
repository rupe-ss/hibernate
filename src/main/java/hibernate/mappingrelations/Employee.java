package hibernate.mappingrelations;

public class Employee {
    private int oid;
    private String name;

    public Employee() {
    }

    public Employee(int oid, String name) {
        this.oid = oid;
        this.name = name;
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

    @Override
    public String toString() {
        return "Employee{" +
                "oid=" + oid +
                ", name='" + name + '\'' +
                '}';
    }
}
