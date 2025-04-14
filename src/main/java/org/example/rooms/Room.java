package org.example.rooms;

import org.example.characters.Monster;
import org.example.characters.Princess;
import org.example.items.Treasure;
import org.example.items.Weapon;

import java.util.ArrayList;
import java.util.List;

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
    private Monster monster;
    private Princess princess;
    private List<Weapon> weaponList = new ArrayList<>();
    private List<Treasure> treasureList = new ArrayList<>();

    public Room(Integer number, String description, Boolean hasExit, Boolean hasToBeOpenedFromOutside) {
        this.number = number;
        this.description = description;
        this.hasExit = hasExit;
        this.hasToBeOpenedFromOutside = hasToBeOpenedFromOutside;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Princess getPrincess() {
        return princess;
    }

    public void setPrincess(Princess princess) {
        this.princess = princess;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void addWeaponInRoom(Weapon weaponList) {
        this.weaponList.add(weaponList);
    }

    public List<Treasure> getTreasureList() {
        return treasureList;
    }

    public void addTreasure(Treasure treasureList) {
        this.treasureList.add(treasureList);
    }

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
