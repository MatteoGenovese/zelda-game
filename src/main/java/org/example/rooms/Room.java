package org.example.rooms;

import org.example.characters.Character;
import org.example.characters.Monster;
import org.example.items.Item;
import org.example.pathway.Pathway;

import java.util.*;

public class Room {
    private Integer number;
    private String description;
    private Boolean hasExit;
    private Boolean hasToBeOpenedFromOutside;
    private List<Pathway> pathwayList;

    //optionals
    private Item item;
    private List<Character> characterList;

    public Room(Integer number, String description, Boolean hasExit, Boolean hasToBeOpenedFromOutside) {
        this.number = number;
        this.description = description;
        this.hasExit = hasExit;
        this.hasToBeOpenedFromOutside = hasToBeOpenedFromOutside;
        this.characterList = new ArrayList<>();
    }

    public List<Pathway> getPathwayList() {
        return pathwayList;
    }

    public void setPathwayList(List<Pathway> pathwayList) {
        this.pathwayList = pathwayList;
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

    //Currently you are in Room 1. A cool shudder trickles down your spine. Glancing around nervously, you see somber portrait
    //s staring at you from behind layers of dust, seemingly penetrating your very being. The Exit to Castle is to your West.

}
