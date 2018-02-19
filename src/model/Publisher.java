package model;

public class Publisher {
    private String publisherId;
    private String name;
    private String city;
    private String country;

    public Publisher(String publisherId, String name, String city, String country) {
        this.publisherId = publisherId;
        this.name = name;
        this.city = city;
        this.country = country;
    }
}
