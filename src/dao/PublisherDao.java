package dao;

import model.Publisher;
import singleton.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PublisherDao {

    public Publisher importPublisher(String id){
        Publisher publisher = null;
        PreparedStatement preparedStatement = null;
        String query = "select * from Publishers where publisher_id=?;";

        try {
            preparedStatement = DbConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                publisher = new Publisher(id, name, city, country);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publisher;

    }

    public ArrayList<Publisher> importAllPublishers(){
        ArrayList<Publisher> allPublishers = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        String query = "select * from Publishers";

        try {
            preparedStatement = DbConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String id = resultSet.getString("publishers_id");

                Publisher publisher = importPublisher(id);
                if(publisher != null) {
                    allPublishers.add(publisher);
                }
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allPublishers;

    }
}
