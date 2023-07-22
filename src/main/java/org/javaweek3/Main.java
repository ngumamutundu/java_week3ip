package org.javaweek3;

import org.javaweek3.dao.AnimalDAO;
import org.javaweek3.dao.SightingDAO;
import org.javaweek3.models.Animal;
import org.javaweek3.models.Sighting;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.sql.SQLException;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(4567);

        // Serve static files (CSS, JavaScript, etc.) from the "public" directory
        staticFileLocation("/public");
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


        // Route to serve the animal form HTML template
        get("/new-animal", (req, res) -> {
            return new ModelAndView(null, "animalForm.hbs");
        }, new HandlebarsTemplateEngine());


        // Route to serve the animalList.hbs template
        get("/animal-list", (req, res) -> {
            return new ModelAndView(null, "animalList.hbs");
        }, new HandlebarsTemplateEngine());

        // Route to serve the error.hbs template
        get("/error", (req, res) -> {
            return new ModelAndView(null, "error.hbs");
        }, new HandlebarsTemplateEngine());

        // Route to serve the home.hbs template
        get("/home", (req, res) -> {
            return new ModelAndView(null, "home.hbs");
        }, new HandlebarsTemplateEngine());

        // Route to serve the layout.hbs template (if needed)
        get("/layout", (req, res) -> {
            return new ModelAndView(null, "layout.hbs");
        }, new HandlebarsTemplateEngine());

        // Route to serve the sighting.hbs template
        get("/sighting", (req, res) -> {
            return new ModelAndView(null, "sighting.hbs");
        }, new HandlebarsTemplateEngine());

        // Route to serve the sightingForm.hbs template
        get("/sighting-form", (req, res) -> {
            return new ModelAndView(null, "sightingForm.hbs");
        }, new HandlebarsTemplateEngine());
    }
}

