package org.example;

import org.example.characters.Character;
import org.example.characters.Hero;
import org.example.characters.Monster;
import org.example.characters.Princess;
import org.example.enums.CoordinateEnum;
import org.example.game.ActionHandler;
import org.example.game.GameHandler;
import org.example.items.Item;
import org.example.items.Treasure;
import org.example.items.Weapon;
import org.example.enums.TreasureEnum;
import org.example.enums.WeaponEnum;
import org.example.pathway.Pathway;
import org.example.rooms.Room;

import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GameHandler gameHandler = GameHandler.getInstance();
        ActionHandler actionHandler = ActionHandler.getInstance();
        gameHandler.useScanner(scanner);
        actionHandler.useScanner(scanner);

        gameHandler.startNewGame();
        actionHandler.action();
        scanner.close();
    }
}