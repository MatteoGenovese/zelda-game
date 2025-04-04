package org.example.characters;

import org.example.items.enums.WeaponEnum;
import org.example.rooms.Room;

public class Monster extends Character{
    private String superPower;
    private WeaponEnum weaknessTo;

    public Monster(String name, Boolean isLiving) {
        super(name, isLiving);
    }

    public Monster(String name, Boolean isLiving, String superPower, WeaponEnum weaknessTo) {
        super(name, isLiving);
        this.superPower = superPower;
        this.weaknessTo = weaknessTo;
    }
}
