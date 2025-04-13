package org.example.utils;

import org.example.characters.Monster;
import org.example.game.Game;
import org.example.rooms.Room;

import java.util.Objects;

public class MessageUtility {


    public static void printMonster(Room room, Game game) {
        String monsterInsideRoom = "";
        for (Monster monster : game.getMonsterList()){
            if (Objects.equals(monster.getRoom().getNumber(), room.getNumber())){
                monsterInsideRoom = monster.getName()+" is inside the room";
            }
        }
        if (monsterInsideRoom.isBlank()){
            monsterInsideRoom = "no moster detected";
        }
        System.out.println(monsterInsideRoom);
    }


    public static void printPrincess(Room room, Game game) {
        String monsterInsideRoom = "";
        for (Monster monster : game.getMonsterList()){
            if (Objects.equals(monster.getRoom().getNumber(), room.getNumber())){
                monsterInsideRoom = monster.getName()+" is inside the room";
            }
        }
        System.out.println(monsterInsideRoom);
    }

    public static void printAvailableRooms(Room room) {
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
    public static void printMoveAndAvailableRooms(String direction, Room room) {
        System.out.println("Hero went "+ direction +" in room nr "+ room.getNumber());
        printAvailableRooms(room);
    }

    public static void signalRoomClosed(String direction, String currentRoomNumber) {
        System.out.println(direction +" is not available because room"+
                currentRoomNumber+
                " is closed");
    }

    public static void printItems(Room room) {
        System.out.println(room.getItem()!=null? room.getItem(): "No items in this room");
    }
}
