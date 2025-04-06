package org.example.enums;

public enum CommandEnum {
   MOVE("move"),PICK("pick"),DROP("drop"),EXIT("exit"),ATTACK("attack"),LOOK("look");


   private String name;

   CommandEnum(String s ){
      name = s;
   }

   public String getName(){return name;}

}
