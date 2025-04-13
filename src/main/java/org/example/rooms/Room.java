package org.example.rooms;

import org.example.characters.Character;
import org.example.characters.Monster;
import org.example.items.Item;

import java.util.*;

public class Room {
    private Integer number;
    private String description;
    private Boolean hasExit;
    private Boolean hasToBeOpenedFromOutside;
    private Room northRoom;
    private Room southRoom;
    private Room eastRoom;
    private Room westRoom;

    //optionals
    private Item item;

    public Room(Integer number, String description, Boolean hasExit, Boolean hasToBeOpenedFromOutside) {
        this.number = number;
        this.description = description;
        this.hasExit = hasExit;
        this.hasToBeOpenedFromOutside = hasToBeOpenedFromOutside;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    //Currently you are in Room 1. A cool shudder trickles down your spine. Glancing around nervously, you see somber portrait
    //s staring at you from behind layers of dust, seemingly penetrating your very being. The Exit to Castle is to your West.


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHasExit() {
        return hasExit;
    }

    public void setHasExit(Boolean hasExit) {
        this.hasExit = hasExit;
    }

    public Boolean getHasToBeOpenedFromOutside() {
        return hasToBeOpenedFromOutside;
    }

    public void setHasToBeOpenedFromOutside(Boolean hasToBeOpenedFromOutside) {
        this.hasToBeOpenedFromOutside = hasToBeOpenedFromOutside;
    }

    public Room getNorthRoom() {
        return northRoom;
    }

    public void setNorthRoom(Room northRoom) {
        this.northRoom = northRoom;
    }

    public Room getSouthRoom() {
        return southRoom;
    }

    public void setSouthRoom(Room southRoom) {
        this.southRoom = southRoom;
    }

    public Room getEastRoom() {
        return eastRoom;
    }

    public void setEastRoom(Room eastRoom) {
        this.eastRoom = eastRoom;
    }

    public Room getWestRoom() {
        return westRoom;
    }

    public void setWestRoom(Room westRoom) {
        this.westRoom = westRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", description='" + description + '\'' +
                ", hasExit=" + hasExit +
                ", hasToBeOpenedFromOutside=" + hasToBeOpenedFromOutside +
                '}';
    }
}
