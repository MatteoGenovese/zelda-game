package org.example.items;

public class Weapon extends Item {
    private String actionDone;

    public Weapon(String name, String description, Boolean isSellable) {
        super(name, description, isSellable);
    }

    public Weapon(String name, String description, Boolean isSellable, String actionDone) {
        super(name, description, isSellable);
        this.actionDone = actionDone;
    }
}
