package org.example.pathway;

import org.example.rooms.Room;

import java.util.Map;

public class Pathway {
    private Boolean isOpen;
    private Map<Room,Room> linkedRooms;

    public Pathway(Boolean isOpen, Map<Room, Room> linkedRooms) {
        this.isOpen = isOpen;
        this.linkedRooms = linkedRooms;
    }
}
