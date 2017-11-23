package wor;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Write a description of class World here.
 *
 * @author (Group2)
 * @version (11/23/17)
 */
public class World
{
    
    
    private JFrame frame;
    private JButton btUp, btDown, btLeft, btRight, btSpeak, btExplore, btTake;
    private JPanel bBar,lMap,rActions;
    public JLabel map, cPicture, text;
    private JTextArea zoneTexte = new JTextArea(1,10);
    private String lastTeam;
    private String lastAction;
    private Player thePlayer;
    private ArrayList<Room> listRoom;
    private boolean win;  
    private Icon feuvert;
    
    
    // instance variables - replace the example below with your own

    //private ArrayList<Room> listRoom;
    private Room fountain, library, poolRoom, office, veranda, barn1, barn2, barn3,
        garden, hall, smallHall, kiosk, livingRoom, diningRoom, kitchen, corridor1, corridor2,
        corridor3, corridor4, corridor5, corridor6, corridor7, corridor8, corridor9, corridor10, corridor11,
        corridor12, corridor13, corridor14, corridor15, corridor16, corridor17, corridor18;
    
    private Door libraryDoor,officeDoor,verandaDoor,barn3Door,smallHallDoor,poolRoomDoor,kitchenDoor,diningRoomDoor,livingRoomDoor; 
     
    private Talking clnMoutarde, missRose,prOlive, missLeblanc,generalLegris, misterRouge, countOrange, countnessOrange; 
    private Killer drViolet;
    private Follower missPrunelle;


     
     private Item clothSoaked, scarf,footPrints, rope, dagger, ironBar, revolver,candlestick, wrench, poison, axe, keyLibrary, keyVeranda, keyLivingRoom, keyDiningRoom, codeOffice, codeKitchen, irGlasses, gasMask;
     private Inventory inventory;
     private NoteBook notebook;
     public Player player1;
     
        private Icon imagefountain, imagelibrary, imagepoolRoom, imageoffice, imageveranda, imagebarn1, imagebarn2, imagebarn3,
        imagegarden, imagehall, imagesmallHall, imagekiosk, imagelivingRoom, imagediningRoom, imagekitchen, imagecorridor1, imagecorridor2,
        imagecorridor3, imagecorridor4, imagecorridor5, imagecorridor6, imagecorridor7, imagecorridor8, imagecorridor9, imagecorridor10, imagecorridor11,
        imagecorridor12, imagecorridor13, imagecorridor14, imagecorridor15, imagecorridor16, imagecorridor17, imagecorridor18,carte;
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
        
        //imagehall = new ImageIcon (getClass().getResource("/pictures/c1.jpg")) ;
        
       libraryDoor = new Door ("library",true,false);
       officeDoor = new Door ("office",false,true);
       verandaDoor = new Door ("veranda",true, false);
       barn3Door = new Door ("Thirdbarn",false,false);
       smallHallDoor = new Door ("smallhall",false,false);
       poolRoomDoor = new Door ("pool",false, false);
       kitchenDoor = new Door ("kitchen",false,true);
       diningRoomDoor = new Door ("dining",true,false);
       livingRoomDoor = new Door ("living",true,false);
       
    // Creation of the images associated with the rooms   
       imagefountain = new ImageIcon (getClass().getResource("/pictures/fontaine.jpg")) ;   
       imagelibrary = new ImageIcon (getClass().getResource("/pictures/bibliothèque2.jpg")) ;   
       imagepoolRoom = new ImageIcon (getClass().getResource("/pictures/billard1.jpg")) ;
       imageoffice = new ImageIcon (getClass().getResource("/pictures/bureau.jpg")) ;
       imageveranda = new ImageIcon (getClass().getResource("/pictures/veranda5.jpg")) ;
       imagebarn1 = new ImageIcon (getClass().getResource("/pictures/grange.jpg")) ;
       imagebarn2 = new ImageIcon (getClass().getResource("/pictures/grange2.jpg")) ;
       imagebarn3 = new ImageIcon (getClass().getResource("/pictures/grange3.jpg")) ;
       imagegarden = new ImageIcon (getClass().getResource("/pictures/jardin3.jpg")) ;
       imagehall = new ImageIcon (getClass().getResource("/pictures/Hall.jpg")) ;
       imagesmallHall = new ImageIcon (getClass().getResource("/pictures/petitsalon2.jpg")) ;
       imagekiosk = new ImageIcon (getClass().getResource("/pictures/kiosque.jpg")) ;
       imagelivingRoom = new ImageIcon (getClass().getResource("/pictures/grandsalon.jpg")) ;
       imagediningRoom = new ImageIcon (getClass().getResource("/pictures/salle_manger.jpg")) ;
       imagekitchen = new ImageIcon (getClass().getResource("/pictures/cuisine2.jpg")) ;
       imagecorridor1 = new ImageIcon (getClass().getResource("/pictures/c1.jpg")) ;   
       imagecorridor2 = new ImageIcon (getClass().getResource("/pictures/c2.jpg")) ;   
       imagecorridor3 = new ImageIcon (getClass().getResource("/pictures/c3.jpg")) ;   
       imagecorridor4 = new ImageIcon (getClass().getResource("/pictures/c4.jpg")) ;   
       imagecorridor5 = new ImageIcon (getClass().getResource("/pictures/c5.jpg")) ;   
       imagecorridor6 = new ImageIcon (getClass().getResource("/pictures/c6.jpg")) ;   
       imagecorridor7 = new ImageIcon (getClass().getResource("/pictures/c7.jpg")) ;   
       imagecorridor8 = new ImageIcon (getClass().getResource("/pictures/c8.jpg")) ;   
       imagecorridor9 = new ImageIcon (getClass().getResource("/pictures/c9.jpg")) ;   
       imagecorridor10 = new ImageIcon (getClass().getResource("/pictures/c10.jpg")) ;   
       imagecorridor11 = new ImageIcon (getClass().getResource("/pictures/c11.jpg")) ;   
       imagecorridor12 = new ImageIcon (getClass().getResource("/pictures/c12.jpg")) ;   
       imagecorridor13 = new ImageIcon (getClass().getResource("/pictures/c13.jpg")) ;   
       imagecorridor14 = new ImageIcon (getClass().getResource("/pictures/c14.jpg")) ;   
       imagecorridor15 = new ImageIcon (getClass().getResource("/pictures/c15.jpg")) ;   
       imagecorridor16 = new ImageIcon (getClass().getResource("/pictures/c16.jpg")) ;   
       imagecorridor17 = new ImageIcon (getClass().getResource("/pictures/c17.jpg")) ;   
       imagecorridor18 = new ImageIcon (getClass().getResource("/pictures/c18.jpg")) ;   

    // Creation of all the rooms
       fountain = new Room ("fountain","A beautiful fountain",null,imagefountain);
       library = new Room ("library","The library, where you can read quietly",libraryDoor,imagelibrary);
       poolRoom = new Room ("pool","a small game of pool ?",poolRoomDoor,imagepoolRoom);
       office = new Room ("office","the ideal place to work in peace",null,imageoffice);
       veranda = new Room ("veranda","a warm place to watch the garden during winter",verandaDoor,imageveranda);
       barn1 = new Room ("barn 1","the first barn of the house",null,imagebarn1);
       barn2 = new Room ("barn 2","the second barn of the house",null,imagebarn2);
       barn3 = new Room ("barn 3","a third small barn",barn3Door,imagebarn3);
       garden = new Room ("garden","a big beautiful garden",null,imagegarden);
       hall = new Room ("hall","the hall of the house, to welcome visitors",null,imagehall);
       smallHall = new Room ("small hall","a second small hall",smallHallDoor,imagesmallHall);
       kiosk = new Room ("kiosk","A quiet kiosk to rest", null, imagekiosk);
       livingRoom = new Room ("living","the most cosy living room you have ever seen",livingRoomDoor,imagelivingRoom);
       diningRoom = new Room ("dining","a large, friendly room",diningRoomDoor,imagediningRoom);
       kitchen = new Room ("kitchen","the heart of the house : the kitchen",kitchenDoor,imagekitchen);
       corridor1 = new Room ("corridor 1","A simple corridor",null,imagecorridor1);
       corridor2 = new Room ("corridor 2","A simple corridor",null,imagecorridor2);
       corridor3 = new Room ("corridor 3","A simple corridor",null,imagecorridor3);
       corridor4 = new Room ("corridor 4","A simple corridor",null,imagecorridor4);
       corridor5 = new Room ("corridor 5","A simple corridor",null,imagecorridor5);
       corridor6 = new Room ("corridor 6","A simple corridor",null,imagecorridor6);
       corridor7 = new Room ("corridor 7","A simple corridor",null,imagecorridor7);
       corridor8 = new Room ("corridor 8","A simple corridor",null,imagecorridor8);
       corridor9 = new Room ("corridor 9","A simple corridor",null,imagecorridor9);
       corridor10 = new Room ("corridor 10","A simple corridor",null,imagecorridor10);
       corridor11 = new Room ("corridor 11","A simple corridor",null,imagecorridor11);
       corridor12 = new Room ("corridor 12","A simple corridor",null,imagecorridor12);
       corridor13 = new Room ("corridor 13","A simple corridor",null,imagecorridor13);
       corridor14 = new Room ("corridor 14","A simple corridor",null,imagecorridor14);
       corridor15 = new Room ("corridor 15","A simple corridor",null,imagecorridor15);
       corridor16 = new Room ("corridor 16","A simple corridor",null,imagecorridor16);
       corridor17 = new Room ("corridor 17","A simple corridor",null,imagecorridor17);
       corridor18 = new Room ("corridor 18","A simple corridor",null,imagecorridor18);
        
       
    // Creation of the exits in the rooms
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


     // Creation of the characters   
     clnMoutarde = new Talking ("Yesterday I went to have dinner early and saw the Dr. Violet with a bottle of wine in his hand ..","On the one hand, it didn’t shock me: he's a lover of good wine…  Looking back, when I hailed him he looked restless, as if something had happened... ", "Colonel Moutarde");
     missRose = new Talking ("I just came here to have a quiet weekend. I never thought that something so dramatic could happened …","When I think about it, Madam Pervenche seemed to be dating someone in the mansion, I never knew who it was…", "miss Rose");
     prOlive = new Talking ("What happened really cut my appetite ... Too bad.. they served lobster this afternoon!","Mrs. Pervenche? Yes it's true she was cute but unfortunately for her not my style at all..", "Professeur Olive");
     missLeblanc = new Talking ("I wasn’t feeling good yesterday after dinner. I went upstairs in my room and I spent the evening and night there. I needed some rest.. and that’s why I’m having a walk in the garden now.","Mme Pervenche? A good old friend ! I know she wasn’t having a good feeling with Reverend Olive for few days.. too bad he is such a magnificent man...", "miss Leblanc");
     generalLegris = new Talking ("I talked a little bit with Dr. Violet. A great scientist, this man!  Not like that idiot of \"Professor\" Olive …","I saw someone entering the living room, unfortunately lighting is defective in this room, I could not identify who was coming in. Surely this stupid Professor Olive.", "general Legris");
     misterRouge = new Talking ("Mrs. Pervenche was a good friend. We used to have good times together.","She was supposed to spend the evening with me last night, but she never came ... ", "Mister Rouge");
     countOrange = new Talking ("Hello inspector, what do you want?  Yes …  I learned for Mrs. Pervench ... It's very unfortunate. Did you find the murderer ?","I heard Mrs. Pervenche speak to a man when I was in the living room last night, I think they were in the kiosk at this moment.", "Compte Orange");
     countnessOrange = new Talking ("Me and my husband the Count Orange have been the owner of this hotel for over 20 years and this is the first time such a horrible thing happens! I am taking a deep breath of fresh air in the kiosk to recover from all these emotions.","Mrs. Pervenche seemed so friendly, resourceful, and early in life! What a pity..", "Comptesse Orange");
      
     drViolet = new Killer("Docteur Violet");

     missPrunelle = new Follower ("I am only the cleaning lady, but I can help you another way in your investigation.", "miss Prunelle");

    // Add the character into rooms
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

     
        //Creation of weapons
        rope = new Item("rope","You found a rope on a stool. This is clearly not the murder weapon. However, someone might have thought about suicide, remorse maybe …");
        rope.setUse(false); // this item is not usable by the player
        dagger = new Item("dagger","You found a nicely decorated dagger. You question yourself on its presence inside the veranda. But you remind that there were no cutoff marks on the victim. There may be other crimes to come...");
        dagger.setUse(false);
        dagger.setHidden(true);
        ironBar = new Item("ironBar","You found a quite impressive iron bare. Exactly the kind of thing that can knock out someone. Or worst. ");
        ironBar.setUse(false);
        revolver = new Item("revolver","Hidden into a desk drawer, you found a Revolver with only one bullet in the chamber. Maybe the one that you will keep for Ms Pervenche murderer.");
        revolver.setHidden(true); // the revovler is hidden in the room
        revolver.setUse(false);
        candlestick = new Item("candlestick","You found a dusty candlestick. Perfect for a candlelit dinner with Miss Prunelle once this case solved. The duty before everything !");
        candlestick.setUse(false);
        wrench = new Item("wrench","You found a wrench. Its implication into the murder seems unlikely. However, you have a sink that has a leakage back home, this might help you to fix it.");
        wrench.setUse(false);
        poison = new Item("poison","You found an half empty flask that contains a suspicious liquid. POISON ! This might be the murder weapon, but who would be perfidious enough to use it …");
        poison.setUse(false);
        axe = new Item("axe","You found an axe. It reminds you your childhood with your father, who was a lumberjack. You focus and notice that there is no blood on it. On one hand, it would be very barbaric to kill someone with an axe...");
        axe.setUse(false);
        
        // Creation of key - code
        keyLibrary = new Item ("Keylibrary","You found the library’s key. Who knows, maybe this key will allow you to open other doors ...");
        keyLibrary.setHidden(true);
        keyVeranda = new Item ("Keyveranda","You found the key of the veranda. People always hide strange things in there. Try your luck…");
        keyVeranda.setHidden(true);
        keyLivingRoom = new Item ("Key living room","You found the key of the living room. This is the right occasion to interrogate new suspects. ");
        keyLivingRoom.setHidden(true);
        keyDiningRoom = new Item ("Key dining room","You found the dining room’s key. Stroke of luck, the dining room and the living room are communicating rooms !");
        keyDiningRoom.setHidden(true);
        
        codeOffice = new Item ("Codeoffice","You found a 4 digits code (4 4 4 4). It looks like they does not bother that much about security here.");
        codeOffice.setHidden(true);
        codeKitchen = new Item ("Codekitchen", "You found a 17 digits code. Yes, that is possible. Good luck to memorise the combination of the kitchen’s door.");
        codeKitchen.setHidden(true);
        
        //Creation of utilities 

        irGlasses = new Item ("Glasses Infrared","Your extraordinary observation capabilities allow you to discover infrared glasses hidden inside a bush. This might look useless but with it, you will have style !");
        irGlasses.setHidden(true);
        gasMask = new Item ("Gas Mask","You found a gas mask from the second world war. Why it is here ? Nevermind, it can be useful at some point.");
            
        // Creation of clues
        footPrints = new Item ("Foot prints","You noticed footprints on the ground, from two people. It seems that they were walking towards the garden...");
        scarf = new Item ("Scarf","A soft cashmere scarf, color periwinkle, does not fool anyone on the identity of its owner. How did Ms Pervenche lose it ...?");
        clothSoaked = new Item ("Tissu imbibé","You found a cloth soaked in red wine. This reminds you arguing with your wife on Valentine’s Day…");
        
    // Add the items into the rooms  
        barn3.addItem(rope);
        veranda.addItem(dagger);
        barn2.addItem(ironBar);
        office.addItem(revolver);
        diningRoom.addItem(candlestick);
        fountain.addItem(wrench);
        kitchen.addItem(poison);
        barn2.addItem(axe);
        garden.addItem(irGlasses);
        veranda.addItem(gasMask);
        kiosk.addItem(keyLibrary);
        barn3.addItem(keyVeranda);
        smallHall.addItem(keyLivingRoom);
        poolRoom.addItem(keyDiningRoom);
        library.addItem(codeOffice);
        office.addItem(codeKitchen);
        
        // Creation of clues
        kiosk.addItem(footPrints);
        garden.addItem(scarf);
        smallHall.addItem(clothSoaked);

        

        notebook = new NoteBook();
        inventory = new Inventory();
        // test    
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
        //player1.move("down");
         //player1.move("down");


        //testajout

      
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenu menuHelp = new JMenu("Help");
        JMenu menuJournal = new JMenu("Journal");
        JMenu menuItems = new JMenu("Items");
        
        JMenuItem reset = new JMenuItem("Reset game");
        JMenuItem quit = new JMenuItem("Exit the game");
        
        menu.add(reset);
        menu.add(quit);
        
        menuBar.add(menu);
        menuBar.add(menuHelp);
        menuBar.add(menuJournal);
        menuBar.add(menuItems);
        
        lMap = new JPanel();
        map = new JLabel(carte);
        lMap.add(map);     
//         cPicture = new JPanel();
//        picture = new JLabel(new ImageIcon("/pictures/c1.jpg"));
//                cPicture.add(picture);   

//         Icon feuVert = new ImageIcon("green.jpg");
//                JLabel feuGreen = new JLabel();
//                feuGreen.setIcon(feuVert);

                
                
         
         
       
       
                cPicture = new JLabel();
                cPicture.setIcon(player1.getCurrentRoom().getImage());
                
                //System.out.println((player1.getCurrentRoom()).getImage());
                //System.out.println((player1.getCurrentRoom()).getImage());


                //feuGreen.setIcon(hall.getImage());

        
        rActions = new JPanel();
        rActions.setLayout(new GridLayout(3,1));
        btSpeak = new JButton("Speak");
        btExplore = new JButton("Explore");
        btTake = new JButton("Take");
        rActions.add(btSpeak);
        rActions.add(btExplore);
        rActions.add(btTake);
        
        bBar = new JPanel();
        bBar.setLayout(new GridLayout(1,2));
        bBar.setSize(200,300);
        JPanel moveBt = new JPanel();
        moveBt.setLayout(new BorderLayout());
        btRight = new JButton("→");
        btLeft = new JButton("←");
        btUp = new JButton("↑");
        btDown = new JButton("↓");
        moveBt.add(btRight,BorderLayout.EAST);
        moveBt.add(btLeft,BorderLayout.WEST);
        moveBt.add(btUp,BorderLayout.NORTH);
        moveBt.add(btDown,BorderLayout.CENTER);
        bBar.add(zoneTexte);
        bBar.add(moveBt);
        
        frame = new JFrame("TestWoZ");
        frame.setSize(1000,700);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.setLayout(new BorderLayout());
        frame.add(cPicture, BorderLayout.CENTER);
        frame.add(bBar, BorderLayout.SOUTH);
        frame.add(rActions, BorderLayout.EAST);
        frame.add(lMap, BorderLayout.WEST);
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
     
        
        btRight.addActionListener(ae -> {player1.move("right");  
                                cPicture.setIcon(player1.getCurrentRoom().getImage());

                                });
        btLeft.addActionListener(ae -> {player1.move("left");   
                                cPicture.setIcon(player1.getCurrentRoom().getImage());

                                });
        btUp.addActionListener(ae -> {player1.move("up");  
                                                cPicture.setIcon(player1.getCurrentRoom().getImage());

                                });
        btDown.addActionListener(ae -> {player1.move("down");
                                                cPicture.setIcon(player1.getCurrentRoom().getImage());

                                });
        
        btExplore.addActionListener(ae -> {player1.explore();
                                               
                                player1.getTime();
                                });
        btTake.addActionListener(ae -> {player1.takeItem();
                                               
                                player1.getTime();
                                });
          
        
       
    }   
        
    private void printWelcome() {

    }

    public Player getPlayer(){
        return player1;
    }  
}
