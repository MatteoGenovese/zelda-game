package org.example.enums;

public enum WeaponEnum {
   MAGIC_SHIELD("Magic shield"),
   SILVER_DUGGER("Silver Dugger");

   private final String name;
   WeaponEnum(String s){ name= s;}
   public String getName(){return name;}
}
