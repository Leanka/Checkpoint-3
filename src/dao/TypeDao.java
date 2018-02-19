package dao;

import model.TypeBook;
import singleton.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeDao {

    public TypeBook importType(Integer id){
        TypeBook typeBook = null;
        PreparedStatement preparedStatement = null;
        String query = "select * from TypeBook where type_id=?;";

        try {
            preparedStatement = DbConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String name = resultSet.getString("name");
                typeBook = new TypeBook(id, name);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typeBook;

    }

    public ArrayList<TypeBook> importAllTypes(){
        ArrayList<TypeBook> allBookTypes = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        String query = "select * from TypeBook;";

        try {
            preparedStatement = DbConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Integer typeId = resultSet.getInt("type_id");
                String name = resultSet.getString("name");

                TypeBook typeBook = new TypeBook(typeId, name);
                allBookTypes.add(typeBook);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allBookTypes;

    }
}
