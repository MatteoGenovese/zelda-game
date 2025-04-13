package org.example.characters;

import org.example.rooms.Room;

public class Princess extends Character {
    private Boolean isWithTheHero;

    public Princess(String name, Boolean isLiving, Room withinRoom, Boolean isWithTheHero) {
        super(name, isLiving, withinRoom);
        this.isWithTheHero = isWithTheHero;
    }
}
