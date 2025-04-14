package org.example.enums;

public enum WeaponEnum {
   MAGIC_SHIELD("shield"),
   SILVER_DAGGER("dagger");

   private final String name;
   WeaponEnum(String s){ name= s;}
   public String getName(){return name;}
}
