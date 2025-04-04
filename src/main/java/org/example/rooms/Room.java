package org.example.rooms;

import org.example.characters.Character;
import org.example.characters.Monster;
import org.example.items.Item;

import java.util.List;
import java.util.Map;

public class Room {
    private Map<String, Room> linkedRooms;
    private Integer number;
    private String description;
    private Boolean hasExit;
    private Boolean hasToBeOpenedFromOutside;
    private List<Character> characterList ;

    //optionals
    private Item item;
    private Map<String, Room> magicalPath;
    private Monster monsterContained;

    public Room(Map<String, Room> linkedRooms, Integer number, String description, Boolean hasExit, Boolean hasToBeOpenedFromOutside, List<Character> characterList) {
        this.linkedRooms = linkedRooms;
        this.number = number;
        this.description = description;
        this.hasExit = hasExit;
        this.hasToBeOpenedFromOutside = hasToBeOpenedFromOutside;
        this.characterList = characterList;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setMagicalPath(Map<String, Room> magicalPath) {
        this.magicalPath = magicalPath;
    }

    public void setMonsterContained(Monster monsterContained) {
        this.monsterContained = monsterContained;
    }

    public Map<String, Room> getMagicalPath() {
        return magicalPath;
    }

    public Monster getMonsterContained() {
        return monsterContained;
    }

    public void setLinkedRooms(Map<String, Room> linkedRooms) {
        this.linkedRooms = linkedRooms;
    }

    public Map<String, Room> getLinkedRooms() {
        return linkedRooms;
    }
    //Currently you are in Room 1. A cool shudder trickles down your spine. Glancing around nervously, you see somber portrait
    //s staring at you from behind layers of dust, seemingly penetrating your very being. The Exit to Castle is to your West.


}
