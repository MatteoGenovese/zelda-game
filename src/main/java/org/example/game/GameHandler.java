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
import org.example.pathway.Pathway;
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
        List<org.example.characters.Character> characterList = new ArrayList<>();

        Monster medusa = new Monster("Medusa", true, "congelamento", WeaponEnum.MAGIC_SHIELD );
        Monster mrDracula = new Monster("Dracula", true, "succhiasangue", WeaponEnum.SILVER_DUGGER);
        Princess princess = new Princess("Gabriella", true, false);

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
        roomList.get(5-1).getCharacterList().add(medusa);
        roomList.get(6-1).getCharacterList().add(mrDracula);
        roomList.get(9-1).getCharacterList().add(princess);

        Pathway path12 = new Pathway(true, roomList.get(1-1), roomList.get(3-1), CoordinateEnum.EAST);
        Pathway path21 = new Pathway(true, roomList.get(3-1), roomList.get(1-1), CoordinateEnum.WEST);

        Pathway path14 = new Pathway(true, roomList.get(1-1), roomList.get(4-1), CoordinateEnum.SOUTH);
        Pathway path41 = new Pathway(true, roomList.get(4-1), roomList.get(1-1), CoordinateEnum.NORTH);

        Pathway path23 = new Pathway(true, roomList.get(2-1), roomList.get(3-1), CoordinateEnum.EAST);
        Pathway path32 = new Pathway(true, roomList.get(3-1), roomList.get(2-1), CoordinateEnum.WEST);

        Pathway path25 = new Pathway(true, roomList.get(2-1), roomList.get(5-1), CoordinateEnum.SOUTH);
        Pathway path52 = new Pathway(true, roomList.get(5-1), roomList.get(2-1), CoordinateEnum.NORTH);

        Pathway path56 = new Pathway(true, roomList.get(5-1), roomList.get(6-1), CoordinateEnum.EAST);
        Pathway path65 = new Pathway(true, roomList.get(6-1), roomList.get(5-1), CoordinateEnum.WEST);

        Pathway path69 = new Pathway(false, roomList.get(6-1), roomList.get(9-1), CoordinateEnum.SOUTH);
        Pathway path96 = new Pathway(false, roomList.get(9-1), roomList.get(6-1), CoordinateEnum.NORTH);

        Pathway path58 = new Pathway(false, roomList.get(5-1), roomList.get(8-1), CoordinateEnum.SOUTH);
        Pathway path85 = new Pathway(false, roomList.get(8-1), roomList.get(5-1), CoordinateEnum.NORTH);

        Pathway path78 = new Pathway(true, roomList.get(7-1), roomList.get(8-1), CoordinateEnum.EAST);
        Pathway path87 = new Pathway(true, roomList.get(8-1), roomList.get(7-1), CoordinateEnum.WEST);

        List<Pathway> room1Pathways = new ArrayList<>();
        room1Pathways.add(path12);
        room1Pathways.add(path14);
        roomList.get(1-1).setPathwayList(room1Pathways);


        List<Pathway> room2Pathways = new ArrayList<>();
        room2Pathways.add(path21);
        room2Pathways.add(path25);
        room2Pathways.add(path23);
        roomList.get(2-1).setPathwayList(room2Pathways);


        List<Pathway> room3Pathways = new ArrayList<>();
        room3Pathways.add(path32);
        roomList.get(3-1).setPathwayList(room3Pathways);


        List<Pathway> room4Pathways = new ArrayList<>();
        room4Pathways.add(path41);
        roomList.get(4-1).setPathwayList(room4Pathways);

        List<Pathway> room5Pathways = new ArrayList<>();
        room5Pathways.add(path52);
        room5Pathways.add(path56);
        room5Pathways.add(path58);
        roomList.get(5-1).setPathwayList(room5Pathways);

        List<Pathway> room6Pathways = new ArrayList<>();
        room6Pathways.add(path69);
        room6Pathways.add(path65);
        roomList.get(6-1).setPathwayList(room6Pathways);

        List<Pathway> room7Pathways = new ArrayList<>();
        room7Pathways.add(path78);
        roomList.get(7-1).setPathwayList(room7Pathways);

        List<Pathway> room8Pathways = new ArrayList<>();
        room8Pathways.add(path85);
        room8Pathways.add(path87);
        roomList.get(8-1).setPathwayList(room8Pathways);

        List<Pathway> room9Pathways = new ArrayList<>();
        room9Pathways.add(path96);
        roomList.get(9-1).setPathwayList(room9Pathways);

        Hero hero = new Hero(enterHeroName(), true, new ArrayList<>());

        roomList.get(1-1).getCharacterList().add(hero);


        characterList.add(medusa);
        characterList.add(hero);
        characterList.add(mrDracula);
        characterList.add(princess);


        return new Game(roomList, characterList, itemList);

    }

    //readStartFile();


}
