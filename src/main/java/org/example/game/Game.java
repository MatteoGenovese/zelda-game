package org.example.game;

import org.example.characters.Hero;
import org.example.characters.Monster;
import org.example.characters.Princess;
import org.example.items.Item;
import org.example.items.Treasure;
import org.example.items.Weapon;
import org.example.rooms.Room;

import java.util.List;

public class Game {
    private List<Room> roomList;
    private List<Monster> monsterList;
    private Hero hero;
    private Princess princess;

    public Game(List<Room> roomList, List<Monster> monsterList, Hero hero, Princess princess) {
        this.roomList = roomList;
        this.monsterList = monsterList;
        this.hero = hero;
        this.princess = princess;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Princess getPrincess() {
        return princess;
    }

    public void setPrincess(Princess princess) {
        this.princess = princess;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

}
