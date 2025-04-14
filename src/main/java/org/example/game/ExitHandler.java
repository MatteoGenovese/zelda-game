package org.example.game;

import org.example.characters.Hero;
import org.example.characters.Monster;
import org.example.enums.WeaponEnum;
import org.example.items.Weapon;
import org.example.rooms.Room;
import org.example.utils.FileReader;

import java.util.List;
import java.util.Scanner;

public class ExitHandler {



    private static ExitHandler instance = null;
    private Scanner scanner;

    private ExitHandler(){}

    public static ExitHandler getInstance(){
        if(instance == null){
            instance = new ExitHandler();
        }
        return instance;
    }

    public void useScanner(Scanner scanner){
        this.scanner = scanner;
    }


    public void quitTheGame(Game game){
        Hero hero = game.getHero();
        List<Room> roomList = game.getRoomList();

        try {
            displayEnd(hero);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void displayEnd(Hero hero){
        if (hero.getCurrentRoom().getPrincess() != null){
            FileReader.readFile("EndWin");
        }else {
            FileReader.readFile("EndLose");
        }
    }

}
