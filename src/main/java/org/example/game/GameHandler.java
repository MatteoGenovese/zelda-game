package org.example.game;

import org.example.Main;
import org.example.characters.Hero;
import org.example.characters.Monster;
import org.example.characters.Princess;
import org.example.enums.TreasureEnum;
import org.example.enums.WeaponEnum;
import org.example.items.Treasure;
import org.example.items.Weapon;
import org.example.rooms.Room;
import org.example.utils.FileReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameHandler {

    private static GameHandler instance = null;
    private Scanner scanner;

    private GameHandler(){}

    public static GameHandler getInstance(){
        if(instance == null){
            instance = new GameHandler();
        }
        return instance;
    }

    public void useScanner(Scanner scanner){
        this.scanner = scanner;
    }

    private String enterHeroName() {

        while (true) {
            try {
                System.out.print("Inserisci il tuo nome: ");
                String name =  "";
                name = scanner.nextLine();
                if (!name.isEmpty()){
                    //scanner.close();
                    return name;
                }
            }catch (Error e){
                System.out.println("error occurred");
                e.printStackTrace();
            }
        }
    }



    public Game prepareNewGame() {

        FileReader.readFile("Start");

        List<Room> roomList = new ArrayList<>();
        List<Monster> monsterList  = new ArrayList<>();


        Treasure goldenEgg = new Treasure(TreasureEnum.GOLDEN_EGG.getName(), "" ,true,500);
        Treasure goldenChalice = new Treasure(TreasureEnum.GOLDEN_CHALICE.getName(), "" ,true,500);
        Treasure pieceOfPaper = new Treasure(TreasureEnum.PIECE_OF_PAPER.getName(), "" ,true,1000);
        Weapon magicShield = new Weapon(WeaponEnum.MAGIC_SHIELD.getName(), "", false,"specchio riflesso");
        Weapon silverDagger = new Weapon(WeaponEnum.SILVER_DAGGER.getName(), "", false,"puntellino");

        roomList.add(new Room(1, "number 1", true, false));

        roomList.add(new Room(2, "number 2", false, false));

        roomList.add(new Room(3, "number 3", false, false));

        roomList.add(new Room(4, "number 4", false, false));

        roomList.add(new Room(5, "number 5", false, false));

        roomList.add(new Room(6, "number 6", false, false));

        roomList.add(new Room(7, "number 7", false, false));

        roomList.add(new Room(8, "number 8", false, true));

        roomList.add(new Room(9, "number 9", false, true));

        roomList.get(2-1).addTreasure(goldenEgg);
        roomList.get(4-1).addTreasure(goldenChalice);
        roomList.get(8-1).addTreasure(pieceOfPaper);

        roomList.get(7-1).addWeaponInRoom(silverDagger);
        roomList.get(3-1).addWeaponInRoom(magicShield);

        roomList.get(1-1).setWestRoom(roomList.get(2-1));
        roomList.get(1-1).setSouthRoom(roomList.get(4-1));

        roomList.get(2-1).setEastRoom(roomList.get(1-1));
        roomList.get(2-1).setWestRoom(roomList.get(3-1));
        roomList.get(2-1).setSouthRoom(roomList.get(5-1));

        roomList.get(3-1).setEastRoom(roomList.get(2-1));

        roomList.get(4-1).setNorthRoom(roomList.get(1-1));

        roomList.get(5-1).setNorthRoom(roomList.get(2-1));
        roomList.get(5-1).setWestRoom(roomList.get(6-1));
        roomList.get(5-1).setSouthRoom(roomList.get(8-1));

        roomList.get(6-1).setEastRoom(roomList.get(5-1));
        roomList.get(6-1).setSouthRoom(roomList.get(9-1));

        roomList.get(7-1).setWestRoom(roomList.get(8-1));

        roomList.get(8-1).setNorthRoom(roomList.get(5-1));
        roomList.get(8-1).setEastRoom(roomList.get(7-1));

        roomList.get(9-1).setNorthRoom(roomList.get(6-1));

        Monster medusa = new Monster("Medusa", true, WeaponEnum.MAGIC_SHIELD, "congelamento", roomList.get(8-1));
        Monster mrDracula = new Monster("Dracula", true, WeaponEnum.SILVER_DAGGER, "succhiasangue", roomList.get(9-1));

        Princess princess = new Princess("Gabriella", true, false);


        roomList.get(5-1).setMonster(medusa);
        roomList.get(6-1).setMonster(mrDracula);
        roomList.get(9-1).setPrincess(princess);

        Hero hero = new Hero(enterHeroName(), true, roomList.get(1-1));

        return new Game(roomList, hero);

    }

    //readStartFile();


}
