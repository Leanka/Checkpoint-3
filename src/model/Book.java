package model;

public class Book {
    private Long ISBN;

    private Author author;
    private String title;
    private Publisher publisher;
    private Integer publicationYear;
    private Float price;
    private TypeBook typeBook;

    public Book(Long ISBN, Author author, String title, Publisher publisher, Integer publicationYear, Float price, TypeBook typeBook) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.price = price;
        this.typeBook = typeBook;
    }

    public String getTitle() {
        return title;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String toString(){
        return ISBN + " \"" + title + "\", " + author.toString();
    }
}
