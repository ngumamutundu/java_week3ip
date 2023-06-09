package org.javaweek3.dao;

import org.javaweek3.models.EndangeredAnimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;


public class EndangeredAnimalDAO {
    public EndangeredAnimal createEndangeredAnimal(String name, String health, String age) throws SQLException {
        String sql = "INSERT INTO endangered_animals (name, health, age) VALUES (?, ?, ?) RETURNING id";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, health);
            statement.setString(3, age);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                return new EndangeredAnimal(id, name, health, age);
            }
        }
        return null;
    }
}
