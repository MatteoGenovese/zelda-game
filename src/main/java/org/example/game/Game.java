package org.example.game;

import org.example.characters.Hero;
import org.example.rooms.Room;

import java.util.List;

public class Game {
    private List<Room> roomList;
    private Hero hero;

    public Game(List<Room> roomList, Hero hero) {
        this.roomList = roomList;
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

}
