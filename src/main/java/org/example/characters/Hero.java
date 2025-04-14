package org.example.characters;

import org.example.items.Bag;
import org.example.items.Treasure;
import org.example.items.Weapon;
import org.example.rooms.Room;

public class Hero extends Character {

    Room currentRoom;
    //can contain max 10 items
    private Bag<Weapon> weaponBag = new Bag<>();
    private Bag<Treasure> treasureBag = new Bag<>();

    public Hero(String name, Boolean isLiving, Room currentRoom) {
        super(name, isLiving);
        this.currentRoom = currentRoom;
    }

    public Bag<Weapon> getWeaponBag() {
        return weaponBag;
    }

    public void setWeaponBag(Bag<Weapon> weaponBag) {
        this.weaponBag = weaponBag;
    }

    public Bag<Treasure> getTreasureBag() {
        return treasureBag;
    }

    public void setTreasureBag(Bag<Treasure> treasureBag) {
        this.treasureBag = treasureBag;
    }

    public void addTreasureInBag(Treasure treasure) {
        treasureBag.addItem(treasure);
    }

    public void dropWeaponFromBag(Weapon weapon) {
        weaponBag.removeItem(weapon);
    }

    public void dropTreasureFromBag(Treasure treasure) {
        treasureBag.removeItem(treasure);
    }

    public void addWeaponInBag(Weapon weapon) {
        weaponBag.addItem(weapon);
    }

    public boolean checkBagDimension() {
        return weaponBag.getItems().size() + treasureBag.getItems().size() <= 10;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "weaponBag=" + weaponBag +
                ", treasureBag=" + treasureBag +
                '}';
    }
}
