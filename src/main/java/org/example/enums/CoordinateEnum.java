package org.example.enums;

public enum CoordinateEnum {
   NORTH("n"), SOUTH("s"), EAST("e"), WEST("w");

   private String name;

   CoordinateEnum(String s ){
      name = s;
   }

   public String getName(){return name;}

}
