package hibernate.embedded;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    int streetNumber;
    String streetName;
    String city;
    String state;
    int zipCode;

    public Address() {
    }

    public Address(int number, String name, String city, String state, int zipCode) {
        this.streetNumber = number;
        this.streetName = name;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public int getNumber() {
        return streetNumber;
    }

    public void setNumber(int number) {
        this.streetNumber = number;
    }

    public String getName() {
        return streetName;
    }

    public void setName(String name) {
        this.streetName = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number=" + streetNumber +
                ", name='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
