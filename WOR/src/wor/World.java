package wor;

import java.util.ArrayList;

/**
 * Write a description of class World here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class World
{
    // instance variables - replace the example below with your own

    //private ArrayList<Room> listRoom;
    private boolean win;
    private Room fountain, library, poolRoom, office, veranda, barn1, barn2, barn3,
        garden, hall, smallHall, kiosk, livingRoom, diningRoom, kitchen, corridor1, corridor2,
        corridor3, corridor4, corridor5, corridor6, corridor7, corridor8, corridor9, corridor10, corridor11,
        corridor12, corridor13, corridor14, corridor15, corridor16, corridor17, corridor18;
    private Door libraryDoor,officeDoor,verandaDoor,barn3Door,smallHallDoor,poolRoomDoor,kitchenDoor,diningRoomDoor,livingRoomDoor; 
     
    private Talking clnMoutarde, missRose,prOlive, missLeblanc,generalLegris, misterRouge, countOrange, countnessOrange; 
    private Killer drViolet;
    private Follower missPrunelle;


     
     private Item rope, dagger, ironBar, revolver,candlestick, wrench, poison, axe, keyLibrary, keyVeranda, keyLivingRoom, keyDiningRoom, codeOffice, codeKitchen, irgGlasses, gasMask;
     private Inventory inventory;
     private NoteBook notebook;
     public Player player1;
     



    /**
     * Constructor for objects of class World
     */
    public World()
    {
    Game(); 
    }
    
    private void Game() {
        // Room Fontaine, Bibliotheque, SalleDeBillard, Bureau, veranda, Grange1, Grange2, Grange3,
        // Jardin, hall, PetitSalon, Kiosque, GrandSalon, SalleAManger, Cuisine, Couloir1, Couloir2,
        // Couloir3, Couloir4, Couloir5, Couloir6, Couloir7, Couloir8, Couloir9, Couloir10, Couloir11,
        // Couloir12, Couloir13, Couloir14, Couloir15, Couloir16, Couloir17, Couloir18;
        
          

       libraryDoor = new Door ("library",true,false);
       officeDoor = new Door ("office",false,true);
       verandaDoor = new Door ("veranda",true, false);
       barn3Door = new Door ("Thirdbarn",false,false);
       smallHallDoor = new Door ("smallhall",false,false);
       poolRoomDoor = new Door ("pool",false, false);
       kitchenDoor = new Door ("kitchen",false,true);
       diningRoomDoor = new Door ("dining",true,false);
       livingRoomDoor = new Door ("living",true,false);
       fountain = new Room ("fountain","A beautiful fountain",null,"image");
       library = new Room ("library","The library, where you can read quietly",libraryDoor,"image");
       poolRoom = new Room ("pool","a small game of pool ?",poolRoomDoor,"image");
       office = new Room ("office","the ideal place to work in peace",null,"image");
       veranda = new Room ("veranda","a warm place to watch the garden during winter",verandaDoor,"image");
       barn1 = new Room ("barn 1","the first barn of the house",null,"image");
       barn2 = new Room ("barn 2","the second barn of the house",null,"image");
       barn3 = new Room ("barn 3","a third small barn",barn3Door,"image");
       garden = new Room ("garden","a big beautiful garden",null,"image");
       hall = new Room ("hall","the hall of the house, to welcome visitors",null,"image");
       smallHall = new Room ("small hall","a second small hall",smallHallDoor,"image");
       kiosk = new Room ("kiosk","A quiet kiosk to rest", null, "image");
       livingRoom = new Room ("living","the most cosy living room you have ever seen",livingRoomDoor,"image");
       diningRoom = new Room ("dining","a large, friendly room",diningRoomDoor,"image");
       kitchen = new Room ("kitchen","the heart of the house : the kitchen",kitchenDoor,"image");
       corridor1 = new Room ("corridor 1","A simple corridor",null,"image");
       corridor2 = new Room ("corridor 2","A simple corridor",null,"image");
       corridor3 = new Room ("corridor 3","A simple corridor",null,"image");
       corridor4 = new Room ("corridor 4","A simple corridor",null,"image");
       corridor5 = new Room ("corridor 5","A simple corridor",null,"image");
       corridor6 = new Room ("corridor 6","A simple corridor",null,"image");
       corridor7 = new Room ("corridor 7","A simple corridor",null,"image");
       corridor8 = new Room ("corridor 8","A simple corridor",null,"image");
       corridor9 = new Room ("corridor 9","A simple corridor",null,"image");
       corridor10 = new Room ("corridor 10","A simple corridor",null,"image");
       corridor11 = new Room ("corridor 11","A simple corridor",null,"image");
       corridor12 = new Room ("corridor 12","A simple corridor",null,"image");
       corridor13 = new Room ("corridor 13","A simple corridor",null,"image");
       corridor14 = new Room ("corridor 14","A simple corridor",null,"image");
       corridor15 = new Room ("corridor 15","A simple corridor",null,"image");
       corridor16 = new Room ("corridor 16","A simple corridor",null,"image");
       corridor17 = new Room ("corridor 17","A simple corridor",null,"image");
       corridor18 = new Room ("corridor 18","A simple corridor",null,"image");
        
       
      
        fountain.setExit("right",corridor1);
        fountain.setExit("down",corridor2);
        
        corridor1.setExit("left",fountain);
        corridor1.setExit("down",corridor3);
        
        library.setExit("down",corridor4);
        
        poolRoom.setExit("down",corridor5);
        
        office.setExit("down",corridor6);
        
        veranda.setExit("down",corridor7);
        
        corridor2.setExit("up",fountain);
        corridor2.setExit("right",corridor3);
        corridor2.setExit("down",corridor8);
        
        corridor3.setExit("up",corridor1);
        corridor3.setExit("right",corridor4);
        corridor3.setExit("down",garden);
        corridor3.setExit("left",corridor2);
        
        corridor4.setExit("up",library);
        corridor4.setExit("right",corridor5);
        corridor4.setExit("down",corridor9);
        corridor4.setExit("left",corridor3);
        
        corridor5.setExit("left",corridor4);
        corridor5.setExit("up",poolRoom);
        corridor5.setExit("right",corridor6);
        corridor5.setExit("down",hall);
        
        corridor6.setExit("up",office);
        corridor6.setExit("right",corridor7);
        corridor6.setExit("down",corridor10);
        corridor6.setExit("left",corridor5);
        
        corridor7.setExit("up",veranda);
        corridor7.setExit("left",corridor6);
        
        barn1.setExit("down",barn2);
        
        corridor8.setExit("up",corridor2);
        corridor8.setExit("right",garden);
        corridor8.setExit("down",corridor11);
        
        garden.setExit("up",corridor3);
        garden.setExit("right",corridor9);
        garden.setExit("down",corridor12);
        garden.setExit("left",corridor8);
        
        corridor9.setExit("up",corridor4);
        corridor9.setExit("right",hall);
        corridor9.setExit("down",corridor13);
        corridor9.setExit("left",garden);
    
        hall.setExit("up", corridor5);
        hall.setExit("right", corridor10);
        hall.setExit("down", corridor14);       
        hall.setExit("left",corridor9);
        
        
      

        corridor10.setExit("up",corridor6);
        corridor10.setExit("right",smallHall);
        corridor10.setExit("down",corridor15);
        corridor10.setExit("left",hall);
        
        smallHall.setExit("left", corridor10);
        
        barn2.setExit("up", barn1);
        barn2.setExit("down", barn3);
        
        barn3.setExit("left", corridor16);
        barn3.setExit("up", barn2);
        
        corridor11.setExit("up", corridor8);
        corridor11.setExit("right", corridor12);
        corridor11.setExit("down", kiosk);
        
        corridor12.setExit("up", garden);
        corridor12.setExit("right", corridor13);
        corridor12.setExit("down", corridor17);
        corridor12.setExit("left", corridor11);
        
        corridor13.setExit("up", corridor9);
        corridor13.setExit("right", corridor14);
        corridor13.setExit("down", livingRoom);
        corridor13.setExit("left", corridor12);
        
        corridor14.setExit("up", hall);
        corridor14.setExit("right", corridor15);
        corridor14.setExit("down", diningRoom);
        corridor14.setExit("left", corridor13);
        
        corridor15.setExit("up", corridor10);
        corridor15.setExit("right", corridor16);
        corridor15.setExit("down", corridor18);
        corridor15.setExit("left", corridor14);
        
        corridor16.setExit("right", barn3);
        corridor16.setExit("left", corridor15);
                
        kiosk.setExit("up", corridor11);
        kiosk.setExit("right", corridor17);

        corridor17.setExit("up", corridor12);
        corridor17.setExit("left", kiosk);
        
        livingRoom.setExit("up", corridor13);
        livingRoom.setExit("right", diningRoom);
        
        diningRoom.setExit("up", corridor14);
        diningRoom.setExit("left", livingRoom);
        
        corridor18.setExit("up", corridor15);
        corridor18.setExit("right", kitchen);
       
        kitchen.setExit("left", corridor18);


        
     clnMoutarde = new Talking ("Speach1","Speach2", "Colonel Moutarde");
     missRose = new Talking ("Speach1","Speach2", "miss Rose");
     prOlive = new Talking ("Speach1","Speach2", "Professeur Olive");
     missLeblanc = new Talking ("Speach1","Speach2", "miss Leblanc");
     generalLegris = new Talking ("Speach1","Speach2", "general Legris");
     misterRouge = new Talking ("Speach1","Speach2", "Mister Rouge");
     countOrange = new Talking ("Speach1","Speach2", "Compte Orange");
     countnessOrange = new Talking ("Speach1","Speach2", "Comptesse Orange");
      
     drViolet = new Killer("Docteur Violet");
     
     missPrunelle = new Follower ("Speach", "miss Prunelle");
     
     
     fountain.addCharacter(missRose);
     library.addCharacter(clnMoutarde);
     poolRoom.addCharacter(missPrunelle);
     veranda.addCharacter(misterRouge);
     barn1.addCharacter(drViolet);
     garden.addCharacter(missLeblanc);
     corridor11.addCharacter(countOrange);
     kiosk.addCharacter(countnessOrange);
     livingRoom.addCharacter(prOlive);
     kitchen.addCharacter(generalLegris);
     
     
     // weapons
        rope = new Item("rope");
        dagger = new Item("dagger");
        ironBar = new Item("ironBar");
        revolver = new Item("revolver");
        candlestick = new Item("candlestick");
        wrench = new Item("wrench");
        poison = new Item("poison");
        axe = new Item("axe");
       
    // key - code
        keyLibrary = new Item ("Keylibrary");
        keyVeranda = new Item ("Keyveranda");
        keyLivingRoom = new Item ("Keyliving");
        keyDiningRoom = new Item ("Keydining");
        
        codeOffice = new Item ("Codeoffice");
        codeKitchen = new Item ("Codekitchen");
        
        
    //utilities 
    
        irgGlasses = new Item ("Glasses Infrared");
        gasMask = new Item ("Gas Mask");
        
        notebook = new NoteBook();
        inventory = new Inventory();
        
      
        barn3.addItem(rope);
        veranda.addItem(dagger);
        barn2.addItem(ironBar);
        office.addItem(revolver);
        diningRoom.addItem(candlestick);
        fountain.addItem(wrench);
        kitchen.addItem(poison);
        barn2.addItem(axe);
        garden.addItem(irgGlasses);
        veranda.addItem(gasMask);
        kiosk.addItem(keyLibrary);
        barn3.addItem(keyVeranda);
        smallHall.addItem(keyLivingRoom);
        poolRoom.addItem(keyDiningRoom);
        library.addItem(codeOffice);
        office.addItem(codeKitchen);    
    
        
        inventory.addItems(rope);
        inventory.addItems(dagger);
        inventory.addItems(keyDiningRoom);
        
        

        
        
         // System.out.println("test 2 , a droite de hall , ca doit etre c10 ");
        // System.out.println((hall.getRoom("right")).getRoomName());

        player1 = new Player("NomPlayer",hall,notebook,inventory);
        
         // System.out.println("test 3 , ca doit etre hall");
        // System.out.println((player1.getCurrentRoom()).getRoomName());
        
        // System.out.println("test 4 , a droite de hall , ca doit etre c10 ");
        // System.out.println((hall.getRoom("right")).getRoomName());
                        
       
        
         // System.out.println("test 5 ,ca doit etre c10 ");
                // System.out.println((hall.getRoom("right")).getRoomName());
           
                
                
       System.out.println((player1.getCurrentRoom()).getRoomName());
       
       
        //player1.move("right");
        //player1.move("right");
        //player1.move("left");
        //player1.move("up");
        //player1.move("up");

        
        
        // test office
         //player1.move("down");
         //player1.move("right");
         //player1.move("up"); 
         //player1.move("up");
         //player1.move("up");               
               
        //test diningroom
        player1.move("down");
         //player1.move("down");


        //testajout

    }   
        

    private void play(){
    }
    
    
    private void printWelcome() {

     }
     
    public Player getPlayer(){
        return player1;
    }
    
    
    
    
   
    
}
