package org.example.enums;

public enum TreasureEnum {
    GOLDEN_EGG("egg"),
    GOLDEN_CHALICE("chalice"),
    PIECE_OF_PAPER("paper");

    private String name;

    TreasureEnum(String s ){
        name = s;
    }

    public String getName(){return name;}

}
