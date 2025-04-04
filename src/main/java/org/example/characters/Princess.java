package org.example.characters;

import org.example.rooms.Room;

public class Princess extends Character {
    private Boolean isWithTheHero;

    public Princess(String name, Boolean isLiving) {
        super(name, isLiving);
    }

    public Princess(String name, Boolean isLiving, Boolean isWithTheHero) {
        super(name, isLiving);
        this.isWithTheHero = isWithTheHero;
    }
}
