package org.example.items;

import org.example.rooms.Room;

public abstract class Item {
    public String name;
    public String description;
    public Boolean isSellable;

    public Item(String name, String description, Boolean isSellable) {
        this.name = name;
        this.description = description;
        this.isSellable = isSellable;
    }
}
