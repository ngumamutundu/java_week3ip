package org.javaweek3.models;


//public class Sighting {
//    private int id;
//    private Animal animal;
//    private String location;
//    private String rangerName;
//
//    public Sighting(int id, Animal animal, String location, String rangerName) {
//        this.id = id;
//        this.animal = animal;
//        this.location = location;
//        this.rangerName = rangerName;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public Animal getAnimal() {
//        return animal;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public String getRangerName() {
//        return rangerName;
//    }
//}


public class Sighting {
    private Animal animal;
    private String location;
    private String rangerName;

    public Sighting(Animal animal, String location, String rangerName) {
        this.animal = animal;
        this.location = location;
        this.rangerName = rangerName;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }
}
