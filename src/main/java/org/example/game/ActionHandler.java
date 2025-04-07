package org.example.game;

import org.example.enums.CommandEnum;

import java.util.Scanner;

public class ActionHandler {

    private static ActionHandler instance = null;
    private Scanner scanner;

    private ActionHandler(){}

    public static ActionHandler getInstance(){
        if(instance == null){
            instance = new ActionHandler();
        }
        return instance;
    }

    public void useScanner(Scanner scanner){
        this.scanner = scanner;
    }

    public void startGame(){
       Boolean gameOn = true;
       while (gameOn){
           gameOn = action();
       }
    }

    public Boolean action() {

        boolean gameOn = true;

        while (gameOn) {
            try {
                System.out.println("Insert the action (MOVE, PICK, DROP, EXIT, ATTACK, LOOK or QUIT to left the game):");

                if (!scanner.hasNextLine()) {
                    System.out.println("No line found");
                    break;
                }

                String action = scanner.nextLine().trim().toLowerCase();

                if (action.isEmpty()) {
                    System.out.println("You didn't insert anything");
                    continue;
                }

                gameOn = switch (action) {
                    case "move", "pick", "drop", "exit", "attack", "look" -> {
                        System.out.println("You choose: " + action.toUpperCase());
                        yield true;
                    }
                    case "quit" -> {
                        System.out.println("You quit the game: " + action.toUpperCase());
                        yield false;
                    }
                    default -> {
                        System.out.println("Not a valid action: " + action);
                        yield true;
                    }
                };
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
                return true;
            }

        }

        return gameOn;
    }


}
