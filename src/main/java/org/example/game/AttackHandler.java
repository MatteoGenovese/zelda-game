package org.example.game;

import org.example.characters.Hero;
import org.example.characters.Monster;
import org.example.enums.WeaponEnum;
import org.example.items.Weapon;
import org.example.rooms.Room;
import org.example.utils.FileReader;

import java.util.List;
import java.util.Scanner;

public class AttackHandler {



    private static AttackHandler instance = null;
    private Scanner scanner;

    private AttackHandler(){}

    public static AttackHandler getInstance(){
        if(instance == null){
            instance = new AttackHandler();
        }
        return instance;
    }

    public void useScanner(Scanner scanner){
        this.scanner = scanner;
    }


    public boolean attackMonster(Game game, String item){
        Hero hero = game.getHero();
        Room currentRoom = hero.getCurrentRoom();
        List<Room> roomList = game.getRoomList();

        try {
            if (currentRoom.getMonster()!=null){
                attack(hero, currentRoom.getMonster(), roomList);
            }

            System.out.println("hero is living:"+hero.getLiving());
            if (!hero.getLiving()){
               FileReader.readFile("EndDead");
               return false;
            }
        } catch (NullPointerException e){
            System.out.println("cannot attack: "+ item);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return true;
    }

    private void attack(Hero hero, Monster monster, List<Room> roomList){
        WeaponEnum weaponToFightMonster = monster.getWeaknessTo();
        boolean isMonsterLiving = true;
        if (monster.getLiving()){
            System.out.println(hero.getWeaponBag().getItems());
            for (Weapon weapon : hero.getWeaponBag().getItems()){
                if (weaponToFightMonster.getName().equals(weapon.getName())) {
                    roomList.get(monster.getUnlockRoom().getNumber()-1).setHasToBeOpenedFromOutside(false);
                    isMonsterLiving = false;
                    break;
                }
            }
        }
        monster.setLiving(isMonsterLiving);
        hero.setLiving(!isMonsterLiving);
    }
}
