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

    public void action() {

        while (true) {
            try {
                System.out.println("Insert the action (MOVE, PICK, DROP, EXIT, ATTACK, LOOK):");

                if (!scanner.hasNextLine()) {
                    System.out.println("No line found");
                    break;
                }

                String action = scanner.nextLine().trim().toLowerCase();

                if (action.isEmpty()) {
                    System.out.println("You didn't insert anything");
                    continue;
                }

                switch (action) {
                    case "move":
                    case "pick":
                    case "drop":
                    case "attack":
                    case "look":
                        System.out.println("You choose: " + action.toUpperCase());
                        return;
                    default:
                        System.out.println("Not a valid action: " + action);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }


}
