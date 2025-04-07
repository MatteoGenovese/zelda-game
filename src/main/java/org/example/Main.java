package org.example;

import org.example.game.ActionHandler;
import org.example.game.Game;
import org.example.game.GameHandler;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GameHandler gameHandler = GameHandler.getInstance();
        ActionHandler actionHandler = ActionHandler.getInstance();
        gameHandler.useScanner(scanner);
        actionHandler.useScanner(scanner);

        Game game = gameHandler.prepareNewGame();
        actionHandler.action();
        scanner.close();

    }
}