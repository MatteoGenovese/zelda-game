package org.example.characters;

import org.example.enums.WeaponEnum;
import org.example.rooms.Room;

public class Monster extends Character{
    private String superPower;
    private WeaponEnum weaknessTo;

    public Monster(String name, Boolean isLiving, Room withinRoom, String superPower, WeaponEnum weaknessTo) {
        super(name, isLiving, withinRoom);
        this.superPower = superPower;
        this.weaknessTo = weaknessTo;
    }
}
