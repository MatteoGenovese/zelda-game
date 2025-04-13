package org.example.characters;

import org.example.rooms.Room;

public class Character {

    private String name;
    private Boolean isLiving;
    private Room room;

    public Character(String name, Boolean isLiving, Room room) {
        this.name = name;
        this.isLiving = isLiving;
        this.room = room;
    }

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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", isLiving=" + isLiving +
                ", room=" + room +
                '}';
    }
}
