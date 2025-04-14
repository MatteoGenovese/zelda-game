package org.example.items;

public class Treasure extends Item {
    private Integer value;

    public Treasure(String name, String description, Boolean isSellable) {
        super(name, description, isSellable);
    }

    public Treasure(String name, String description, Boolean isSellable, Integer value) {
        super(name, description, isSellable);
        this.value = value;
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isSellable=" + isSellable +
                '}';
    }
}
