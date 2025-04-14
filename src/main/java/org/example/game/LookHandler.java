package org.example.game;

import org.example.characters.Hero;
import org.example.rooms.Room;
import org.example.utils.MessageUtility;

import java.util.Scanner;

public class LookHandler {



    private static LookHandler instance = null;
    private Scanner scanner;

    private LookHandler(){}

    public static LookHandler getInstance(){
        if(instance == null){
            instance = new LookHandler();
        }
        return instance;
    }

    public void useScanner(Scanner scanner){
        this.scanner = scanner;
    }


    public void lookAround(Game game){
        Hero hero = game.getHero();
        Room currentRoom = hero.getCurrentRoom();

        MessageUtility.printItems(currentRoom);
        MessageUtility.printMonster(currentRoom);
        MessageUtility.printPrincess(currentRoom);
        MessageUtility.printAvailableRooms(currentRoom);
        MessageUtility.printHeroCurrentRoom(currentRoom);

        System.out.println(hero);
    }

}
