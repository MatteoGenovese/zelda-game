package org.example.game;

import org.example.Main;
import org.example.characters.Hero;
import org.example.characters.Monster;
import org.example.characters.Princess;
import org.example.enums.CoordinateEnum;
import org.example.enums.TreasureEnum;
import org.example.enums.WeaponEnum;
import org.example.items.Item;
import org.example.items.Treasure;
import org.example.items.Weapon;
import org.example.rooms.Room;

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

    private static void readStartFile() {
        InputStream input = Main.class.getClassLoader().getResourceAsStream("Start.txt");
        if (input == null) {
            System.out.println("File not found");
            return;
        }

        try (Scanner myReader = new Scanner(input)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }


    public Game prepareNewGame() {

        List<Room> roomList = new ArrayList<>();
        List<Monster> monsterList  = new ArrayList<>();


        Item goldenEgg = new Treasure(TreasureEnum.GOLDEN_EGG.getName(), "" ,true,500);
        Item goldenChalice = new Treasure(TreasureEnum.GOLDEN_CHALICE.getName(), "" ,true,500);
        Item pieceOfPaper = new Treasure(TreasureEnum.PIECE_OF_PAPER.getName(), "" ,true,1000);
        Item magicShield = new Weapon(WeaponEnum.MAGIC_SHIELD.getName(), "", false,"specchio riflesso");
        Item silverDugger = new Weapon(WeaponEnum.SILVER_DUGGER.getName(), "", false,"puntellino");

        List<Item> itemList = new ArrayList<>();
        itemList.add(goldenEgg);
        itemList.add(goldenChalice);
        itemList.add(pieceOfPaper);
        itemList.add(magicShield);
        itemList.add(silverDugger);


        roomList.add(new Room(1, "number 1", true, false));

        roomList.add(new Room(2, "number 2", false, false));

        roomList.add(new Room(3, "number 3", false, false));

        roomList.add(new Room(4, "number 4", false, false));

        roomList.add(new Room(5, "number 5", false, false));

        roomList.add(new Room(6, "number 6", false, false));

        roomList.add(new Room(7, "number 7", false, false));

        roomList.add(new Room(8, "number 8", false, true));

        roomList.add(new Room(9, "number 9", false, true));

        roomList.get(2-1).setItem(goldenEgg);
        roomList.get(3-1).setItem(magicShield);
        roomList.get(4-1).setItem(goldenChalice);
        roomList.get(7-1).setItem(silverDugger);
        roomList.get(8-1).setItem(pieceOfPaper);



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

        roomList.get(9-1).setNorthRoom(roomList.get(6-1));

        Monster medusa = new Monster("Medusa", true, roomList.get(6-1), "congelamento", WeaponEnum.MAGIC_SHIELD );
        Monster mrDracula = new Monster("Dracula", true,roomList.get(5-1),  "succhiasangue", WeaponEnum.SILVER_DUGGER);

        Princess princess = new Princess("Gabriella", true, roomList.get(9-1),  false);

        Hero hero = new Hero(enterHeroName(), true, roomList.get(1-1), new ArrayList<>());

        monsterList.add(medusa);
        monsterList.add(mrDracula);

        return new Game(roomList, monsterList, itemList, hero, princess);

    }

    //readStartFile();


}
