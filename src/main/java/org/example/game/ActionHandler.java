package org.example.game;

import org.example.enums.CommandEnum;

import java.lang.reflect.Array;
import java.util.List;
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

    public void startGame(Game game){
       Boolean gameOn = true;
       while (gameOn){
           gameOn = action(game);
       }
    }

    public Boolean action(Game game) {

        boolean gameOn = true;

        while (gameOn) {
            try {
                System.out.println("Insert the action (MOVE, PICK, DROP, LOOK, ATTACK, or EXIT to left the game):");

                if (!scanner.hasNextLine()) {
                    System.out.println("No line found");
                    break;
                }

                String command = scanner.nextLine().trim().toLowerCase();
                List<String> action = List.of(command.split(" "));

                if (action.getFirst().isEmpty()) {
                    System.out.println("You didn't insert anything");
                    continue;
                }

                gameOn = switch (action.getFirst()) {
                    case "attack"-> {
                        AttackHandler attackHandler = AttackHandler.getInstance();
                        yield attackHandler.attackMonster(game, action.getLast());
                    }
                    case "drop"-> {
                        DropHandler dropHandler = DropHandler.getInstance();
                        dropHandler.dropItem(game, action.getLast());
                        yield true;
                    }
                    case "pick"-> {
                        PickHandler pickHandler = PickHandler.getInstance();
                        pickHandler.pickItem(game, action.getLast());
                        yield true;
                    }
                    case "look"-> {
                        LookHandler lookHandler = LookHandler.getInstance();
                        lookHandler.lookAround(game);
                        yield true;
                    }
                    case "move"-> {
                        MoveHandler moveHandler = MoveHandler.getInstance();
                        moveHandler.moveHero(game, action.getLast());
                        yield true;
                    }
                    case "exit" -> {
                        ExitHandler exitHandler = ExitHandler.getInstance();
                        exitHandler.quitTheGame(game);
                        yield false;
                    }
                    default -> {
                        System.out.println("Not a valid action: " + action);
                        yield true;
                    }
                };
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return true;
            }
        }
        return gameOn;
    }
}
