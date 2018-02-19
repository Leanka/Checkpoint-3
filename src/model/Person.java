package model;

public abstract class Person {
    protected String name;
    protected String city;
    protected String country;

    public Person(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return name;
    }
}
