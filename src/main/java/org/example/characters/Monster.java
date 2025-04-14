package org.example.characters;

import org.example.enums.WeaponEnum;
import org.example.rooms.Room;

public class Monster extends Character{
    private String superPower;
    private WeaponEnum weaknessTo;
    private Room unlockRoom;

    public Monster(String name, Boolean isLiving, WeaponEnum weaknessTo, String superPower, Room ifDieUnlockRoom) {
        super(name, isLiving);
        this.superPower = superPower;
        this.weaknessTo = weaknessTo;
        this.unlockRoom = ifDieUnlockRoom;
    }

    public Room getUnlockRoom() {
        return unlockRoom;
    }

    public void setUnlockRoom(Room unlockRoom) {
        this.unlockRoom = unlockRoom;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public WeaponEnum getWeaknessTo() {
        return weaknessTo;
    }

    public void setWeaknessTo(WeaponEnum weaknessTo) {
        this.weaknessTo = weaknessTo;
    }
}
