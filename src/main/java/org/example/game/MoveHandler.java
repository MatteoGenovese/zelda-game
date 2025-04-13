package org.example.game;

import org.example.characters.Hero;
import org.example.rooms.Room;

import java.util.List;
import java.util.Scanner;

public class MoveHandler {

    private static MoveHandler instance = null;
    private Scanner scanner;

    private MoveHandler(){}

    public static MoveHandler getInstance(){
        if(instance == null){
            instance = new MoveHandler();
        }
        return instance;
    }

    public void useScanner(Scanner scanner){
        this.scanner = scanner;
    }


    public Game moveHero(Game game, String direction){
        Hero hero = game.getHero();
        Room currentRoom = hero.getRoom();

        try {
            switch (direction) {
                case "north" -> {
                    if ( currentRoom.getNorthRoom().toString() != null) {
                        hero.setRoom(currentRoom.getNorthRoom());
                        movingMessage(direction);
                    }
                }
                case "east" -> {
                    if ( currentRoom.getEastRoom().toString() != null){
                        hero.setRoom(currentRoom.getEastRoom());
                        movingMessage(direction);
                    }
                }
                case "west" -> {
                    if ( currentRoom.getWestRoom().toString() != null){
                        hero.setRoom(currentRoom.getWestRoom());
                        movingMessage(direction);
                    }
                }
                case "south" -> {
                    if ( currentRoom.getSouthRoom().toString() != null){
                        hero.setRoom(currentRoom.getSouthRoom());
                        movingMessage(direction);
                    }
                }
                default -> {
                    System.out.println("Not a valid direction: " + direction);
                }
            };
        }
        catch (NullPointerException e){
            System.out.println("It is not possible going: "+ direction);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println(hero);
        return game;
    }

    private static void movingMessage(String direction) {
        System.out.println("Hero went "+ direction);
    }


}
