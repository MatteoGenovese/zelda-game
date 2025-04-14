package org.example.utils;

import org.example.rooms.Room;

public class MessageUtility {


    public static void printMonster(Room room) {
        String monsterInsideRoom = "";
        if (room.getMonster() != null && room.getMonster().getLiving()){
            monsterInsideRoom = room.getMonster().getName()+" is inside the room and is living";
        }
        if (room.getMonster() != null && !room.getMonster().getLiving()){
            monsterInsideRoom = room.getMonster().getName()+" is inside the room dead on the floor";
        }

        if (monsterInsideRoom.isBlank()){
            monsterInsideRoom = "No monster detected";
        }
        System.out.println(monsterInsideRoom);
    }

    public static void printPrincess(Room room) {
        String princessInsideRoom = "";
        if (room.getPrincess() != null){
            princessInsideRoom = room.getPrincess().getName()+" is inside the room";
        }
        if (princessInsideRoom.isBlank()){
            princessInsideRoom = "No princess detected";
        }
        System.out.println(princessInsideRoom);
    }


    public static void printHeroCurrentRoom(Room room) {
        System.out.println(room);
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
        System.out.println(room.getTreasureList().isEmpty() ? "No Treasure in this room": room.getTreasureList() );
        System.out.println(room.getWeaponList().isEmpty() ? "No Weapon in this room": room.getWeaponList());
    }
}
