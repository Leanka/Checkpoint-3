package controller;

import dao.AuthorDao;
import dao.BooksDao;
import dao.PublisherDao;
import dao.TypeDao;
import model.Author;
import model.Book;
import model.Publisher;
import model.TypeBook;
import view.ViewRoot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Root {
    private String name;
    private ViewRoot viewRoot;

    public Root(){
        this.name = "Jerzy";
        this.viewRoot = new ViewRoot();
    }

    public void runMenu(){
        boolean toContinue = true;
        do{
            viewRoot.showMainOptions(name);
            String option = viewRoot.getUserInput("Choose option: ");
            switch(option){
                case "1":
                viewRoot.showMessage(getBook().toString());
                break;
                case "2": viewRoot.showMessage("2");
                break;
                case "3": deleteBook();
                    break;
                case "4": viewRoot.showMessage("4");
                    break;
                case "5": getAllBooksSorted();
                    break;
                case "6": getBooksByChosenAuthor();
                    break;
                case "0": toContinue = false;
                    break;
                default:
                    viewRoot.showMessage("There is no such option!");
            }
        }while(toContinue);

    }

    private Book getBook(){
        ArrayList<Book> allBooks = new BooksDao().importAllBooks();
        Book book = null;

        if(allBooks.size() == 0){
            viewRoot.showMessage("No books to show");
        }else {
            viewRoot.showCollecton(allBooks);
            Integer bookId = viewRoot.getUserIntInput("Choose book by id: ");
            if(bookId < 0 || bookId > allBooks.size()){
                viewRoot.showMessage("No such id!");
            }else {
                book = allBooks.get(bookId);
            }
        }
        return book;
    }

    private Author getAuthor(){
        ArrayList<Author> allAuthors = new AuthorDao().importAllAuthors();
        Author author = null;

        if(allAuthors.size() == 0){
            viewRoot.showMessage("No authors to show");
        }else {
            viewRoot.showCollecton(allAuthors);
            Integer id = viewRoot.getUserIntInput("Choose author by id: ");
            if(id < 0 || id > allAuthors.size()){
                viewRoot.showMessage("No such id!");
            }else {
                author = allAuthors.get(id);
            }
        }
        return author;
    }

    private <T> T getItem(ArrayList<T> collection){
        T item = null;

        if(collection.size() == 0){
            viewRoot.showMessage("No items to show");
        }else {
            viewRoot.showCollecton(collection);
            Integer id = viewRoot.getUserIntInput("Choose item by id: ");
            if(id < 0 || id > collection.size()){
                viewRoot.showMessage("No such id!");
            }else {
                item = collection.get(id);
            }
        }
        return item;
    }

    public void getAllBooksSorted(){
        ArrayList<Book> allBooks = new BooksDao().importAllBooks();
        Collections.sort(allBooks, Comparator.comparing(Book::getTitle));

        viewRoot.showCollecton(allBooks);

    }

    public void getBooksByChosenAuthor(){
        Author author = getAuthor();
        if(author != null) {
            viewRoot.showCollecton(new BooksDao().getBooksByAuthor(author));
        }

    }

    public void deleteBook(){
        Book book = getBook();
        if(book != null){
            new BooksDao().deleteBook(book.getISBN());
        }

    }

    public void addNewBook(){
        Long isbn = viewRoot.getUserLongInput("Choose ISBN: ");

        String title = viewRoot.getUserInput("Choose titile: ");

        Author author = getAuthor();

        Publisher publisher = getItem(new PublisherDao().importAllPublishers());

        Integer publicationYear = viewRoot.getUserIntInput("Choose publication year: ");
        Float price = viewRoot.getUserFloatInput("Choose books price: ");

        TypeBook typeBook = getItem(new TypeDao().importAllTypes());

        Book newBook = new Book(isbn, author, title, publisher, publicationYear, price, typeBook);

    }
}
