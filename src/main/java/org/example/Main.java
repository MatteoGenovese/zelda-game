package org.example;

import org.example.characters.Monster;
import org.example.characters.Princess;
import org.example.items.Item;
import org.example.items.Treasure;
import org.example.items.Weapon;
import org.example.items.enums.TreasureEnum;
import org.example.items.enums.WeaponEnum;
import org.example.pathway.Pathway;
import org.example.rooms.Room;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        startNewGame();


    }

    private static void startNewGame() {
        Monster medusa = new Monster("Medusa", true, "congelamento", WeaponEnum.MAGIC_SHIELD );
        Monster mrDracula = new Monster("Dracula", true, "succhiasangue", WeaponEnum.SILVER_DUGGER);
        Princess princess = new Princess("Gabriella", true, false);

        Item goldenEgg = new Treasure(TreasureEnum.GOLDEN_EGG.getName(), "" ,true,500);
        Item goldenChalice = new Treasure(TreasureEnum.GOLDEN_CHALICE.getName(), "" ,true,500);
        Item pieceOfPaper = new Treasure(TreasureEnum.PIECE_OF_PAPER.getName(), "" ,true,1000);
        Item magicShield = new Weapon(WeaponEnum.MAGIC_SHIELD.getName(), "", false,"specchio riflesso");
        Item silverDugger = new Weapon(WeaponEnum.SILVER_DUGGER.getName(), "", false,"puntellino");

        Room room1 = new Room(null, 1, "number 1", true, false, new ArrayList<>());
        Room room2 = new Room(null, 2, "number 2", false, false, new ArrayList<>());
        Room room3 = new Room(null, 3, "number 3", false, false, new ArrayList<>());
        Room room4 = new Room(null, 4, "number 4", false, false, new ArrayList<>());
        Room room5 = new Room(null, 5, "number 5", false, false, new ArrayList<>());
        Room room6 = new Room(null, 6, "number 6", false, false, new ArrayList<>());
        Room room7 = new Room(null, 7, "number 7", false, false, new ArrayList<>());
        Room room8 = new Room(null, 8, "number 8", false, true, new ArrayList<>());
        Room room9 = new Room(null, 9, "number 9", false, true,new ArrayList<>());

        room2.setItem(goldenEgg);
        room3.setItem(magicShield);
        room4.setItem(goldenChalice);
        room7.setItem(silverDugger);
        room8.setItem(pieceOfPaper);

        room5.getCharacterList().add(medusa);
        room6.getCharacterList().add(mrDracula);
        room9.getCharacterList().add(princess);

        Map<Room,Room> map12 = new HashMap<>();
        map12.put(room1,room3);
        Pathway path12 = new Pathway(true, map12);

        Map<Room,Room> map14 = new HashMap<>();
        map14.put(room1,room4);
        Pathway path14 = new Pathway(true, map14);

        Map<Room,Room> map23 = new HashMap<>();
        map23.put(room2,room3);
        Pathway path23 = new Pathway(true, map23);

        Map<Room,Room> map25 = new HashMap<>();
        map25.put(room2,room5);
        Pathway path25 = new Pathway(true, map25);

        Map<Room,Room> map56 = new HashMap<>();
        map56.put(room5,room6);
        Pathway path56 = new Pathway(true, map56);

        Map<Room,Room> map69 = new HashMap<>();
        map69.put(room6,room9);
        Pathway path69 = new Pathway(false, map69);

        Map<Room,Room> map58 = new HashMap<>();
        map58.put(room5,room8);
        Pathway path58 = new Pathway(false, map58);

        Map<Room,Room> map78 = new HashMap<>();
        map78.put(room7,room8);
        Pathway path78 = new Pathway(true, map78);

    }
}