package model;

public class Author extends Person{
    private Integer authorId;
    private String surname;
    private Integer birthYear;

    public Author(Integer authorId, String name, String surname, String city, String country, Integer birthYear) {
        super(name, city, country);
        this.authorId = authorId;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return super.toString() + " " + surname;
    }
}
