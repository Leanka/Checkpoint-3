package dao;

import model.Author;
import singleton.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorDao {

    public Author importAuthor(Integer id){
        Author author = null;
        PreparedStatement preparedStatement = null;
        String query = "select * from Authors where author_id=?;";

        try {
            preparedStatement = DbConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                Integer birthYear = resultSet.getInt("birth_year");
                author = new Author(id, name, surname, city, country, birthYear);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;

    }

    public ArrayList<Author> importAllAuthors(){
        ArrayList<Author> allAuthors = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        String query = "select * from Authors";

        try {
            preparedStatement = DbConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Integer authorId = resultSet.getInt("author_id");

                Author author = importAuthor(authorId);
                if(author != null) {
                    allAuthors.add(author);
                }
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allAuthors;

    }
}
