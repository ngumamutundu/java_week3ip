
package org.javaweek3.dao;

import org.javaweek3.db.DatabaseConnection;
import org.javaweek3.models.Sighting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingDAO {
    public void createSighting(Sighting sighting) throws SQLException {
        String sql = "INSERT INTO sightings (animal_id, location, ranger_name) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, sighting.getAnimal().getId());
            statement.setString(2, sighting.getLocation());
            statement.setString(3, sighting.getRangerName());
            statement.executeUpdate();
        }
    }

    public List<Sighting> getAllSightings() throws SQLException {
        List<Sighting> sightings = new ArrayList<>();
        String sql = "SELECT * FROM sightings";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int animalId = resultSet.getInt("animal_id");
                String location = resultSet.getString("location");
                String rangerName = resultSet.getString("ranger_name");
                // Create an Animal object using the animalId, e.g., Animal animal = new Animal(animalId, ...);
                // Create a Sighting object using the Animal object, location, and rangerName
                // Add the Sighting object to the sightings list
            }
        }
        return sightings;
    }

    // Other methods for CRUD operations on sightings
}
