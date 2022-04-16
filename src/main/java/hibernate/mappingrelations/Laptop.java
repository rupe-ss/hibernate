package hibernate.mappingrelations;

public class Laptop {
    private int lid;
    private String name;

    public Laptop() {
    }

    public Laptop(int lid, String name) {
        this.lid = lid;
        this.name = name;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
