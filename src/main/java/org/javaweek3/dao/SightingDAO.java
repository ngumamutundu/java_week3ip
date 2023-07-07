package org.javaweek3.dao;
import org.javaweek3.db.DatabaseConnection;
import org.javaweek3.models.Animal;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.sql.Connection;


public class SightingDAO {
    public void createSighting(Animal animal, String location, String rangerName) throws SQLException {
        String sql = "INSERT INTO sightings (animal_id, location, ranger_name) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, animal.getId());
            statement.setString(2, location);
            statement.setString(3, rangerName);
            statement.executeUpdate();
        }
    }
}
