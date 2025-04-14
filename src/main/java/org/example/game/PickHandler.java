package org.example.game;

import org.example.characters.Hero;
import org.example.enums.TreasureEnum;
import org.example.enums.WeaponEnum;
import org.example.items.Item;
import org.example.items.Treasure;
import org.example.items.Weapon;
import org.example.rooms.Room;
import org.example.utils.MessageUtility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PickHandler {



    private static PickHandler instance = null;
    private Scanner scanner;

    private PickHandler(){}

    public static PickHandler getInstance(){
        if(instance == null){
            instance = new PickHandler();
        }
        return instance;
    }

    public void useScanner(Scanner scanner){
        this.scanner = scanner;
    }


    public void pickItem(Game game, String item){
        Hero hero = game.getHero();
        Room currentRoom = hero.getCurrentRoom();

        try {
            switch (item) {
                case "shield" -> {
                    removeWeaponAndInsertItInHeroBag(currentRoom, WeaponEnum.MAGIC_SHIELD.getName(), hero);
                }
                case "dagger" -> {
                    removeWeaponAndInsertItInHeroBag(currentRoom, WeaponEnum.SILVER_DAGGER.getName(), hero);
                }
                case "chalice" -> {
                    removeTreasureAndInsertItInHeroBag(currentRoom, TreasureEnum.GOLDEN_CHALICE.getName(), hero);
                }
                case "egg" -> {
                    removeTreasureAndInsertItInHeroBag(currentRoom, TreasureEnum.GOLDEN_EGG.getName(), hero);
                }
                case "paper" -> {
                    removeTreasureAndInsertItInHeroBag(currentRoom, TreasureEnum.PIECE_OF_PAPER.getName(), hero);
                }
                default -> {
                    System.out.println("Not a valid item: " + item);
                }
            };
        } catch (NullPointerException e){
            System.out.println("It is not possible to pick, it is not here: "+ item);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void removeWeaponAndInsertItInHeroBag(Room currentRoom, String weaponName, Hero hero) {
        Weapon weaponToRemove = null;
        for (Weapon weapon: currentRoom.getWeaponList()){
            if (weapon.getName().equals(weaponName)){
                weaponToRemove = weapon;
            }
        }
        currentRoom.getWeaponList().remove(weaponToRemove);
        hero.addWeaponInBag(weaponToRemove);
    }

    private static void removeTreasureAndInsertItInHeroBag(Room currentRoom, String treasureName, Hero hero) {
        Treasure treasureToRemove = null;
        for (Treasure treasure: currentRoom.getTreasureList()){
            if (treasure.getName().equals(treasureName)){
                treasureToRemove = treasure;
            }
        }
        currentRoom.getTreasureList().remove(treasureToRemove);
        hero.addTreasureInBag(treasureToRemove);
    }

}
