package org.javaweek3.dao;

import org.javaweek3.models.Animal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;


public class AnimalDAO {
    public Animal createAnimal(String name) throws SQLException {
        String sql = "INSERT INTO animals (name) VALUES (?) RETURNING id";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                return new Animal(id, name);
            }
        }
        return null;
    }
}

