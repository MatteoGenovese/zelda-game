package org.example.game;

import org.example.characters.Hero;
import org.example.characters.Princess;
import org.example.rooms.Room;
import org.example.utils.MessageUtility;

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


    public void moveHero(Game game, String direction){
        Hero hero = game.getHero();
        try {
            switch (direction) {
                case "north" -> {
                    goToRoom(direction, hero.getCurrentRoom().getNorthRoom(), hero);
                    checkIfPrincessIsPresent(hero.getCurrentRoom());
                }
                case "east" -> {
                    goToRoom(direction, hero.getCurrentRoom().getEastRoom(), hero);
                    checkIfPrincessIsPresent(hero.getCurrentRoom());
                }
                case "west" -> {
                    goToRoom(direction, hero.getCurrentRoom().getWestRoom(), hero);
                    checkIfPrincessIsPresent(hero.getCurrentRoom());
                }
                case "south" -> {
                    goToRoom(direction, hero.getCurrentRoom().getSouthRoom(), hero);
                    checkIfPrincessIsPresent(hero.getCurrentRoom());
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
    }

    private static void goToRoom(String direction, Room roomToGo, Hero hero) {
        if ( roomToGo.toString() != null &&
                !roomToGo.getHasToBeOpenedFromOutside()) {
            hero.setCurrentRoom(roomToGo);
            MessageUtility.printMoveAndAvailableRooms(direction, roomToGo);
        }else {
            MessageUtility.signalRoomClosed(direction, roomToGo.getNumber().toString());
        }
    }

    private static void checkIfPrincessIsPresent(Room room) {
        if (room.getPrincess() != null){
            room.getPrincess().setWithTheHero(true);
        }
    }
}
