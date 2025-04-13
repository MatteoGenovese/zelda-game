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

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isSellable=" + isSellable +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSellable() {
        return isSellable;
    }

    public void setSellable(Boolean sellable) {
        isSellable = sellable;
    }
}
