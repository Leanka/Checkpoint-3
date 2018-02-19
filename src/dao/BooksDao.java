package dao;

import model.Author;
import model.Book;
import model.Publisher;
import model.TypeBook;
import singleton.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BooksDao {

    public Book importBook(Long isbn){
        Book book = null;
        PreparedStatement preparedStatement = null;
        String query = "select * from Books where ISBN=?;";

        try {
            preparedStatement = DbConnection.getConnection().prepareStatement(query);
            preparedStatement.setLong(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Integer authorId = resultSet.getInt("author");
                Author bookAuthor = new AuthorDao().importAuthor(authorId);

                String title = resultSet.getString("title");

                String publishersId = resultSet.getString("publisher");
                Publisher bookPublisher = new PublisherDao().importPublisher(publishersId);

                Integer publicationYear = resultSet.getInt("publication_year");
                Float price = resultSet.getFloat("price");

                Integer typeId = resultSet.getInt("type");
                TypeBook typeBook = new TypeDao().importType(typeId);

                book = new Book(isbn, bookAuthor, title, bookPublisher, publicationYear, price, typeBook);

            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;

    }

    public ArrayList<Book> importAllBooks(){
        ArrayList<Book> allBooks = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        String query = "select * from Books";

        try {
            preparedStatement = DbConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Long isbn = resultSet.getLong("ISBN");

                Book book = importBook(isbn);
                if(book != null) {
                    allBooks.add(book);
                }
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allBooks;

    }

    public ArrayList<Book> getBooksByAuthor(Author author){
        ArrayList<Book> allBooks = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        String query = "select * from Books where author=?";

        try {
            preparedStatement = DbConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, author.getAuthorId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Long isbn = resultSet.getLong("ISBN");

                Book book = importBook(isbn);
                if(book != null) {
                    allBooks.add(book);
                }
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allBooks;
    }

    public void deleteBook(Long isbn){
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM Books WHERE ISBN=?;";

        try {
            preparedStatement = DbConnection.getConnection().prepareStatement(query);
            preparedStatement.setLong(1, isbn);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
