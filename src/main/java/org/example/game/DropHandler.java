package org.example.game;

import org.example.characters.Hero;
import org.example.enums.TreasureEnum;
import org.example.enums.WeaponEnum;
import org.example.items.Bag;
import org.example.items.Treasure;
import org.example.items.Weapon;
import org.example.rooms.Room;
import org.example.utils.MessageUtility;

import java.util.Scanner;

public class DropHandler {



    private static DropHandler instance = null;
    private Scanner scanner;

    private DropHandler(){}

    public static DropHandler getInstance(){
        if(instance == null){
            instance = new DropHandler();
        }
        return instance;
    }

    public void useScanner(Scanner scanner){
        this.scanner = scanner;
    }


    public void dropItem(Game game, String item){
        Hero hero = game.getHero();
        Room currentRoom = hero.getRoom();

        try {
            switch (item) {
                case "shield" -> {
                    dropWeaponFromBag(currentRoom, WeaponEnum.MAGIC_SHIELD.getName(), hero);
                }
                case "dagger" -> {
                    dropWeaponFromBag(currentRoom, WeaponEnum.SILVER_DAGGER.getName(), hero);
                }
                case "chalice" -> {
                    dropTreasureFromBag(currentRoom, TreasureEnum.GOLDEN_CHALICE.getName(), hero);
                }
                case "egg" -> {
                    dropTreasureFromBag(currentRoom, TreasureEnum.GOLDEN_EGG.getName(), hero);
                }
                case "paper" -> {
                    dropTreasureFromBag(currentRoom, TreasureEnum.PIECE_OF_PAPER.getName(), hero);
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

    private static void dropWeaponFromBag(Room currentRoom, String weaponName, Hero hero) {
        Weapon weaponToRemove = null;
        Bag<Weapon> weaponBag = hero.getWeaponBag();
        for (Weapon weapon: weaponBag.getItems()){
            if (weapon.getName().equals(weaponName)){
                weaponToRemove = weapon;
            }
        }
        hero.dropWeaponFromBag(weaponToRemove);
        currentRoom.getWeaponList().add(weaponToRemove);
    }

    private static void dropTreasureFromBag(Room currentRoom, String treasureName, Hero hero) {
        Treasure treasureToRemove = null;
        Bag<Treasure> treasureBag = hero.getTreasureBag();
        for (Treasure treasure: treasureBag.getItems()){
            if (treasure.getName().equals(treasureName)){
                treasureToRemove = treasure;
            }
        }
        hero.dropTreasureFromBag(treasureToRemove);
        currentRoom.getTreasureList().add(treasureToRemove);
    }

}
