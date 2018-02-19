package dao;

import singleton.DbConnection;

import java.sql.PreparedStatement;

public class BooksDao {

    public void insertBook(Book book){
        PreparedStatement preparedStatement= null;
        String query = "INSERT INTO Books ";

        preparedStatement = DbConnection.getConnection().prepareStatement();

    }
}
