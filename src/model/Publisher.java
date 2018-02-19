package model;

public class Publisher extends Person{
    private String publisherId;

    public Publisher(String publisherId, String name, String city, String country) {
        super(name, city, country);
        this.publisherId = publisherId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
