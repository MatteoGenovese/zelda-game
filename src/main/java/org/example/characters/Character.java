package org.example.characters;

public class Character {

    private String name;
    private Boolean isLiving;

    public Character(String name, Boolean isLiving) {
        this.name = name;
        this.isLiving = isLiving;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", isLiving=" + isLiving +
                '}';
    }
}
