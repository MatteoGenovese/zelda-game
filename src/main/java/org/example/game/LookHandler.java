package org.example.game;

import org.example.characters.Hero;
import org.example.rooms.Room;

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


    public Game lookAround(Game game){
        Hero hero = game.getHero();
        Room currentRoom = hero.getRoom();

        System.out.println(currentRoom.getItem());

        System.out.println(hero);
        return game;
    }

}
