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
                    if ( currentRoom.getNorthRoom().toString() != null &&
                            !currentRoom.getNorthRoom().getHasToBeOpenedFromOutside()) {
                        hero.setRoom(currentRoom.getNorthRoom());
                        movingMessage(direction, currentRoom.getNorthRoom());
                    }else {
                        signalRoomClosed(direction, currentRoom.getNorthRoom().getNumber().toString());
                    }
                }
                case "east" -> {
                    if ( currentRoom.getEastRoom().toString() != null &&
                    !currentRoom.getEastRoom().getHasToBeOpenedFromOutside()) {
                        hero.setRoom(currentRoom.getEastRoom());
                        movingMessage(direction, currentRoom.getEastRoom());
                    }else {
                        signalRoomClosed(direction, currentRoom.getEastRoom().getNumber().toString());
                    }
                }
                case "west" -> {
                    if ( currentRoom.getWestRoom().toString() != null &&
                    !currentRoom.getWestRoom().getHasToBeOpenedFromOutside()) {
                        hero.setRoom(currentRoom.getWestRoom());
                        movingMessage(direction, currentRoom.getWestRoom());
                    }else {
                        signalRoomClosed(direction, currentRoom.getWestRoom().getNumber().toString());
                    }
                }
                case "south" -> {
                    if ( currentRoom.getSouthRoom().toString() != null &&
                    !currentRoom.getSouthRoom().getHasToBeOpenedFromOutside()) {
                        hero.setRoom(currentRoom.getSouthRoom());
                        movingMessage(direction, currentRoom.getSouthRoom());
                    }else {
                        signalRoomClosed(direction, currentRoom.getSouthRoom().getNumber().toString());
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

    private static void signalRoomClosed(String direction, String currentRoomNumber) {
        System.out.println(direction +" is not available because room"+
                currentRoomNumber+
                " is closed");
    }

    private static void movingMessage(String direction, Room room) {
        System.out.println("Hero went "+ direction +" in room nr "+ room.getNumber());
        String availableRoom = "";

        if (room.getNorthRoom() != null && !room.getNorthRoom().getHasToBeOpenedFromOutside()){
            availableRoom+="room "+room.getNorthRoom().getNumber() +" is available on north\n";
        }
        if (room.getEastRoom() != null && !room.getEastRoom().getHasToBeOpenedFromOutside()){
            availableRoom+="room "+room.getEastRoom().getNumber() +" is available on east\n";
        }
        if (room.getWestRoom() != null && !room.getWestRoom().getHasToBeOpenedFromOutside()){
            availableRoom+="room "+room.getWestRoom().getNumber() +" is available on west\n";
        }
        if (room.getSouthRoom() != null && !room.getSouthRoom().getHasToBeOpenedFromOutside()){
            availableRoom+="room "+room.getSouthRoom().getNumber() +" is available on south\n";
        }

        System.out.println(availableRoom);
    }


}
