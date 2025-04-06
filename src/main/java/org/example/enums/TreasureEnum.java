package org.example.enums;

public enum TreasureEnum {
    GOLDEN_EGG("golden egg"),
    GOLDEN_CHALICE("golden chalice"),
    PIECE_OF_PAPER("Piece of paper");

    private String name;

    TreasureEnum(String s ){
        name = s;
    }

    public String getName(){return name;}

}
