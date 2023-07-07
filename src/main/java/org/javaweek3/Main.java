package org.javaweek3;

import org.javaweek3.dao.AnimalDAO;
import org.javaweek3.dao.SightingDAO;
import org.javaweek3.models.Animal;
import org.javaweek3.models.Sighting;

import java.sql.SQLException;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(4567);

        AnimalDAO animalDAO = new AnimalDAO();
        try {
            animalDAO.createAnimal("Douglas Fir");
            animalDAO.createAnimal("Endangered Species");
        } catch (SQLException e) {
            // Handle the exception, e.g., log the error or show an error message
            e.printStackTrace();
        }

        SightingDAO sightingDAO = new SightingDAO();

        // Create a new sighting
        post("/sightings", (req, res) -> {
            res.type("application/json");
            int animalId = Integer.parseInt(req.queryParams("animalId"));
            String location = req.queryParams("location");
            String rangerName = req.queryParams("rangerName");

            Animal animal = animalDAO.getAnimalById(animalId);
            if (animal == null) {
                res.status(400);
                return "{\"error\": \"Invalid animal ID\"}";
            }

            Sighting sighting = new Sighting(animal, location, rangerName);
            try {
                sightingDAO.createSighting(sighting);
            } catch (SQLException ex) {
                // Handle the exception, e.g., log the error or show an error message
                ex.printStackTrace();
            }

            return sightingDAO.getAllSightings();
        });

        // Other routes and configurations
    }
}

