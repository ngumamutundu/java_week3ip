package org.javaweek3.models;

public class EndangeredAnimal extends Animal {
    private String health;
    private String age;

    public EndangeredAnimal(int id, String name, String health, String age) {
        super(id, name);
        this.health = health;
        this.age = age;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }
}

