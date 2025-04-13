package org.example.characters;

import org.example.items.Item;
import org.example.rooms.Room;

import java.util.List;

public class Hero extends Character {

    //can contain max 10 items
    private List<Item> bag;

    public Hero(String name, Boolean isLiving, Room withinRoom, List<Item> bag) {
        super(name, isLiving, withinRoom);
        this.bag = bag;
    }

    public List<Item> getBag() {
        return bag;
    }

    public void setBag(List<Item> bag) {
        this.bag = bag;
    }

    @Override
    public String toString() {
        return super.toString()+
                " Hero{" +
                "bag=" + bag +
                '}';
    }
}
