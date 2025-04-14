package org.example.characters;

public abstract class Character {

    private String name;
    private Boolean isLiving;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLiving() {
        return isLiving;
    }

    public void setLiving(Boolean living) {
        isLiving = living;
    }

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
