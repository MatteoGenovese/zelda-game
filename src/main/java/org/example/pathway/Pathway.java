package org.example.pathway;

import org.example.enums.CoordinateEnum;
import org.example.rooms.Room;

public class Pathway {
    private Boolean isOpen;
    private Room fromRoom;
    private Room toRoom;
    private CoordinateEnum coordinate;

    public Pathway(Boolean isOpen, Room fromRoom, Room toRoom, CoordinateEnum coordinate) {
        this.isOpen = isOpen;
        this.fromRoom = fromRoom;
        this.toRoom = toRoom;
        this.coordinate = coordinate;
    }
}
