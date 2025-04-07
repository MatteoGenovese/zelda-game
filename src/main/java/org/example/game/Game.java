package org.example.game;

import org.example.characters.Character;
import org.example.items.Item;
import org.example.rooms.Room;

import java.util.List;

public class Game {
    private List<Room> roomList;
    private List<Character> characterList;
    private List<Item> itemList;

    public Game(List<Room> roomList, List<Character> characterList, List<Item> itemList) {
        this.roomList = roomList;
        this.characterList = characterList;
        this.itemList = itemList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
