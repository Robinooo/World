package wor;

import java.awt.*;
import javax.swing.*;
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
public class World {

    private JFrame frame, journalFrame;
    private JButton btUp, btDown, btLeft, btRight, btSpeak, btExplore, btTake, btJournal;
    private JPanel bBar, rActions; //lMap
    public JLabel map, cPicture, text, lMap;
    JTextArea zoneTexte = new JTextArea(1,10);
    private JTextArea textJournal;
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

    private Door libraryDoor, officeDoor, verandaDoor, barn3Door, smallHallDoor, poolRoomDoor, kitchenDoor, diningRoomDoor, livingRoomDoor;

    private KeyLock libraryKey, verandaKey, livingRoomKey, diningRoomKey;
    private CodeLock officeCode, kitchenCode;
    
    private Talking clnMoutarde, missRose, prOlive, missLeblanc, generalLegris, misterRouge, countOrange, countnessOrange;
    private Killer drViolet;
    private Follower missPrunelle;

    private Item hippocraticOath, clothSoaked, scarf, footPrints, rope, dagger, ironBar, revolver, candlestick, wrench, poison, axe, keyLibrary, keyVeranda, keyLivingRoom, keyDiningRoom, codeOffice, codeKitchen, irGlasses, gasMask;
    private Inventory inventory;
    private NoteBook notebook;
    public Player player1;

    private Icon imagefountain, imagelibrary, imagepoolRoom, imageoffice, imageveranda, imagebarn1, imagebarn2, imagebarn3,
            imagegarden, imagehall, imagesmallHall, imagekiosk, imagelivingRoom, imagediningRoom, imagekitchen, imagecorridor1, imagecorridor2,
            imagecorridor3, imagecorridor4, imagecorridor5, imagecorridor6, imagecorridor7, imagecorridor8, imagecorridor9, imagecorridor10, imagecorridor11,
            imagecorridor12, imagecorridor13, imagecorridor14, imagecorridor15, imagecorridor16, imagecorridor17, imagecorridor18, carte;
    
    
    private Icon mapimagefountain, mapimagelibrary, mapimagepoolRoom, mapimageoffice, mapimageveranda, mapimagebarn1, mapimagebarn2, mapimagebarn3,
            mapimagegarden, mapimagehall, mapimagesmallHall, mapimagekiosk, mapimagelivingRoom, mapimagediningRoom, mapimagekitchen, mapimagecorridor1, mapimagecorridor2,
            mapimagecorridor3, mapimagecorridor4, mapimagecorridor5, mapimagecorridor6, mapimagecorridor7, mapimagecorridor8, mapimagecorridor9, mapimagecorridor10, mapimagecorridor11,
            mapimagecorridor12, mapimagecorridor13, mapimagecorridor14, mapimagecorridor15, mapimagecorridor16, mapimagecorridor17, mapimagecorridor18;
    /**
     * Constructor for objects of class World
     */
    public World(String playerClass, String playerName) {

      

        //imagehall = new ImageIcon (getClass().getResource("/pictures/c1.jpg")) ;
        libraryDoor = new Door("library");
        libraryKey = new KeyLock("Keylibrary");
        libraryDoor.addKeyLock(libraryKey);
        
        officeDoor = new Door("office");
        officeCode = new CodeLock("Codeoffice", "Codeoffice");
        officeDoor.addCodeLock(officeCode);
        
        verandaDoor = new Door("veranda");
        verandaKey = new KeyLock("Keyveranda");
        verandaDoor.addKeyLock(verandaKey);
        
        barn3Door = new Door("Thirdbarn");
        
        smallHallDoor = new Door("smallhall");
        
        poolRoomDoor = new Door("pool");
        
        kitchenDoor = new Door("kitchen");
        kitchenCode = new CodeLock("Codekitchen", "Codekitchen");
        kitchenDoor.addCodeLock(officeCode);
        
        diningRoomDoor = new Door("dining");
        diningRoomKey = new KeyLock("Keydining");
        diningRoomDoor.addKeyLock(diningRoomKey);
        
        livingRoomDoor = new Door("living");
        livingRoomKey = new KeyLock("Keyliving");
        livingRoomDoor.addKeyLock(livingRoomKey);

        // Creation of the images associated with the rooms 
        carte = new ImageIcon(getClass().getResource("/pictures/Map_code.jpg"));
        imagefountain = new ImageIcon(getClass().getResource("/pictures2/fontaine.jpg"));
        imagelibrary = new ImageIcon(getClass().getResource("/pictures2/library.jpg"));
        imagepoolRoom = new ImageIcon(getClass().getResource("/pictures2/poolroom.jpg"));
        imageoffice = new ImageIcon(getClass().getResource("/pictures2/office.jpeg"));
        imageveranda = new ImageIcon(getClass().getResource("/pictures2/veranda.jpg"));
        imagebarn3 = new ImageIcon(getClass().getResource("/pictures2/grange.jpg"));
        imagebarn2 = new ImageIcon(getClass().getResource("/pictures2/grange2.jpg"));
        imagebarn1 = new ImageIcon(getClass().getResource("/pictures2/grange3.jpg"));
        imagegarden = new ImageIcon(getClass().getResource("/pictures2/garden.png"));
        imagehall = new ImageIcon(getClass().getResource("/pictures2/hall.png"));
        imagesmallHall = new ImageIcon(getClass().getResource("/pictures2/smallhall.png"));
        imagekiosk = new ImageIcon(getClass().getResource("/pictures2/kiosque.jpg"));
        imagelivingRoom = new ImageIcon(getClass().getResource("/pictures2/livingroom.png"));
        imagediningRoom = new ImageIcon(getClass().getResource("/pictures2/diningroom.png"));
        imagekitchen = new ImageIcon(getClass().getResource("/pictures2/cuisine.jpg"));
        imagecorridor1 = new ImageIcon(getClass().getResource("/pictures2/c1.png"));
        imagecorridor2 = new ImageIcon(getClass().getResource("/pictures2/c2.png"));
        imagecorridor3 = new ImageIcon(getClass().getResource("/pictures2/c3.png"));
        imagecorridor4 = new ImageIcon(getClass().getResource("/pictures2/c4-c13.png"));
        imagecorridor5 = new ImageIcon(getClass().getResource("/pictures2/c5-c14.png"));
        imagecorridor6 = new ImageIcon(getClass().getResource("/pictures2/c6-c15.png"));
        imagecorridor7 = new ImageIcon(getClass().getResource("/pictures2/c7-c16.png"));
        imagecorridor8 = new ImageIcon(getClass().getResource("/pictures2/c8.png"));
        imagecorridor9 = new ImageIcon(getClass().getResource("/pictures2/c10-c9-c18.png"));
        imagecorridor10 = new ImageIcon(getClass().getResource("/pictures2/c10-c9-c18.png"));
        imagecorridor11 = new ImageIcon(getClass().getResource("/pictures2/c11.png"));
        imagecorridor12 = new ImageIcon(getClass().getResource("/pictures2/c12.png"));
        imagecorridor13 = new ImageIcon(getClass().getResource("/pictures2/c4-c13.png"));
        imagecorridor14 = new ImageIcon(getClass().getResource("/pictures2/c5-c14.png"));
        imagecorridor15 = new ImageIcon(getClass().getResource("/pictures2/c6-c15.png"));
        imagecorridor16 = new ImageIcon(getClass().getResource("/pictures2/c7-c16.png"));
        imagecorridor17 = new ImageIcon(getClass().getResource("/pictures2/c17.png"));
        imagecorridor18 = new ImageIcon(getClass().getResource("/pictures2/c10-c9-c18.png"));
        
        
        // Creation of the image (plan) associated with the rooms 
        mapimagefountain = new ImageIcon(getClass().getResource("/picturesplan/Map_code_fountain.jpg"));
        mapimagelibrary = new ImageIcon(getClass().getResource("/picturesplan/Map_code_library.jpg"));
        mapimagepoolRoom = new ImageIcon(getClass().getResource("/picturesplan/Map_code_pool.jpg"));
        mapimageoffice = new ImageIcon(getClass().getResource("/picturesplan/Map_code_office.jpg"));
        mapimageveranda = new ImageIcon(getClass().getResource("/picturesplan/Map_code_veranda.jpg"));
        mapimagebarn1 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_barn1.jpg"));
        mapimagebarn2 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_barn2.jpg"));
        mapimagebarn3 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_barn3.jpg"));
        mapimagegarden = new ImageIcon(getClass().getResource("/picturesplan/Map_code_garden.jpg"));
        mapimagehall = new ImageIcon(getClass().getResource("/picturesplan/Map_code_hall.jpg"));
        mapimagesmallHall = new ImageIcon(getClass().getResource("/picturesplan/Map_code_smallhall.jpg"));
        mapimagekiosk = new ImageIcon(getClass().getResource("/picturesplan/Map_code_kiosk.jpg"));
        mapimagelivingRoom = new ImageIcon(getClass().getResource("/picturesplan/Map_code_living.jpg"));
        mapimagediningRoom = new ImageIcon(getClass().getResource("/picturesplan/Map_code_dining.jpg"));
        mapimagekitchen = new ImageIcon(getClass().getResource("/picturesplan/Map_code_kitchen.jpg"));
        mapimagecorridor1 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c1.jpg"));
        mapimagecorridor2 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c2.jpg"));
        mapimagecorridor3 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c3.jpg"));
        mapimagecorridor4 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c4.jpg"));
        mapimagecorridor5 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c5.jpg"));
        mapimagecorridor6 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c6.jpg"));
        mapimagecorridor7 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c7.jpg"));
        mapimagecorridor8 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c8.jpg"));
        mapimagecorridor9 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c9.jpg"));
        mapimagecorridor10 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c10.jpg"));
        mapimagecorridor11 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c11.jpg"));
        mapimagecorridor12 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c12.jpg"));
        mapimagecorridor13 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c13.jpg"));
        mapimagecorridor14 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c14.jpg"));
        mapimagecorridor15 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c15.jpg"));
        mapimagecorridor16 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c16.jpg"));
        mapimagecorridor17 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c17.jpg"));
        mapimagecorridor18 = new ImageIcon(getClass().getResource("/picturesplan/Map_code_c18.jpg"));
        
        

        // Creation of all the rooms
        fountain = new Room("fountain", "A beautiful fountain", null, imagefountain, mapimagefountain);
        library = new Room("library", "The library, where you can read quietly", libraryDoor, imagelibrary,mapimagelibrary);
        poolRoom = new Room("pool", "a small game of pool ?", poolRoomDoor, imagepoolRoom, mapimagepoolRoom);
        office = new Room("office", "the ideal place to work in peace", officeDoor, imageoffice,mapimageoffice);
        veranda = new Room("veranda", "a warm place to watch the garden during winter", verandaDoor, imageveranda,mapimageveranda);
        barn1 = new Room("barn 1", "the first barn of the house", null, imagebarn1,mapimagebarn1);
        barn2 = new Room("barn 2", "the second barn of the house", null, imagebarn2,mapimagebarn2);
        barn3 = new Room("barn 3", "a third small barn", barn3Door, imagebarn3,mapimagebarn3);
        garden = new Room("garden", "a big beautiful garden", null, imagegarden,mapimagegarden);
        hall = new Room("hall", "the hall of the house, to welcome visitors", null, imagehall,mapimagehall);
        smallHall = new Room("small hall", "a second small hall", smallHallDoor, imagesmallHall,mapimagesmallHall);
        kiosk = new Room("kiosk", "A quiet kiosk to rest", null, imagekiosk,mapimagekiosk);
        livingRoom = new Room("living", "the most cosy living room you have ever seen", livingRoomDoor, imagelivingRoom,mapimagelivingRoom);
        diningRoom = new Room("dining", "a large, friendly room", diningRoomDoor, imagediningRoom,mapimagediningRoom);
        kitchen = new Room("kitchen", "the heart of the house : the kitchen", kitchenDoor, imagekitchen,mapimagekitchen);
        corridor1 = new Room("corridor 1", "A simple corridor", null, imagecorridor1,mapimagecorridor1);
        corridor2 = new Room("corridor 2", "A simple corridor", null, imagecorridor2,mapimagecorridor2);
        corridor3 = new Room("corridor 3", "A simple corridor", null, imagecorridor3,mapimagecorridor3);
        corridor4 = new Room("corridor 4", "A simple corridor", null, imagecorridor4,mapimagecorridor4);
        corridor5 = new Room("corridor 5", "A simple corridor", null, imagecorridor5,mapimagecorridor5);
        corridor6 = new Room("corridor 6", "A simple corridor", null, imagecorridor6,mapimagecorridor6);
        corridor7 = new Room("corridor 7", "A simple corridor", null, imagecorridor7,mapimagecorridor7);
        corridor8 = new Room("corridor 8", "A simple corridor", null, imagecorridor8,mapimagecorridor8);
        corridor9 = new Room("corridor 9", "A simple corridor", null, imagecorridor9,mapimagecorridor9);
        corridor10 = new Room("corridor 10", "A simple corridor", null, imagecorridor10,mapimagecorridor10);
        corridor11 = new Room("corridor 11", "A simple corridor", null, imagecorridor11,mapimagecorridor11);
        corridor12 = new Room("corridor 12", "A simple corridor", null, imagecorridor12,mapimagecorridor12);
        corridor13 = new Room("corridor 13", "A simple corridor", null, imagecorridor13,mapimagecorridor13);
        corridor14 = new Room("corridor 14", "A simple corridor", null, imagecorridor14,mapimagecorridor14);
        corridor15 = new Room("corridor 15", "A simple corridor", null, imagecorridor15,mapimagecorridor15);
        corridor16 = new Room("corridor 16", "A simple corridor", null, imagecorridor16,mapimagecorridor16);
        corridor17 = new Room("corridor 17", "A simple corridor", null, imagecorridor17,mapimagecorridor17);
        corridor18 = new Room("corridor 18", "A simple corridor", null, imagecorridor18,mapimagecorridor18);

        // Creation of the exits in the rooms
        fountain.setExit("down", corridor1);
        fountain.setExit("left", corridor2);

        corridor1.setExit("up", fountain);
        corridor1.setExit("left", corridor3);

        library.setExit("left", corridor4);

        poolRoom.setExit("left", corridor5);

        office.setExit("left", corridor6);

        veranda.setExit("left", corridor7);

        corridor2.setExit("right", fountain);
        corridor2.setExit("down", corridor3);
        corridor2.setExit("left", corridor8);

        corridor3.setExit("right", corridor1);
        corridor3.setExit("down", corridor4);
        corridor3.setExit("left", garden);
        corridor3.setExit("up", corridor2);

        corridor4.setExit("right", library);
        corridor4.setExit("down", corridor5);
        corridor4.setExit("left", corridor9);
        corridor4.setExit("up", corridor3);

        corridor5.setExit("up", corridor4);
        corridor5.setExit("right", poolRoom);
        corridor5.setExit("down", corridor6);
        corridor5.setExit("left", hall);

        corridor6.setExit("right", office);
        corridor6.setExit("down", corridor7);
        corridor6.setExit("left", corridor10);
        corridor6.setExit("up", corridor5);

        corridor7.setExit("right", veranda);
        corridor7.setExit("up", corridor6);

        barn3.setExit("left", barn2);

        corridor8.setExit("right", corridor2);
        corridor8.setExit("down", garden);
        corridor8.setExit("left", corridor11);

        garden.setExit("right", corridor3);
        garden.setExit("down", corridor9);
        garden.setExit("left", corridor12);
        garden.setExit("up", corridor8);

        corridor9.setExit("right", corridor4);
        corridor9.setExit("down", hall);
        corridor9.setExit("left", corridor13);
        corridor9.setExit("up", garden);

        hall.setExit("right", corridor5);
        hall.setExit("down", corridor10);
        hall.setExit("left", corridor14);
        hall.setExit("up", corridor9);

        corridor10.setExit("right", corridor6);
        corridor10.setExit("down", smallHall);
        corridor10.setExit("left", corridor15);
        corridor10.setExit("up", hall);

        smallHall.setExit("up", corridor10);

        barn2.setExit("right", barn3);
        barn2.setExit("left", barn1);

        barn1.setExit("up", corridor16);
        barn1.setExit("right", barn2);

        corridor11.setExit("right", corridor8);
        corridor11.setExit("down", corridor12);
        corridor11.setExit("left", kiosk);

        corridor12.setExit("right", garden);
        corridor12.setExit("down", corridor13);
        corridor12.setExit("left", corridor17);
        corridor12.setExit("up", corridor11);

        corridor13.setExit("right", corridor9);
        corridor13.setExit("down", corridor14);
        corridor13.setExit("left", livingRoom);
        corridor13.setExit("up", corridor12);

        corridor14.setExit("right", hall);
        corridor14.setExit("down", corridor15);
        corridor14.setExit("left", diningRoom);
        corridor14.setExit("up", corridor13);

        corridor15.setExit("right", corridor10);
        corridor15.setExit("down", corridor16);
        corridor15.setExit("left", corridor18);
        corridor15.setExit("up", corridor14);

        corridor16.setExit("down", barn1);
        corridor16.setExit("up", corridor15);

        kiosk.setExit("right", corridor11);
        kiosk.setExit("down", corridor17);

        corridor17.setExit("right", corridor12);
        corridor17.setExit("up", kiosk);

        livingRoom.setExit("right", corridor13);
        livingRoom.setExit("down", diningRoom);

        diningRoom.setExit("right", corridor14);
        diningRoom.setExit("up", livingRoom);

        corridor18.setExit("right", corridor15);
        corridor18.setExit("down", kitchen);

        kitchen.setExit("up", corridor18);

        // Creation of the characters   
        clnMoutarde = new Talking("Yesterday I went to have dinner early and saw the Dr. Violet with a bottle of wine in his hand ..", "On the one hand, it didn’t shock me: he's a lover of good wine…  Looking back, when I hailed him he looked restless, as if something had happened... ", "Colonel Moutarde");
        missRose = new Talking("I just came here to have a quiet weekend. I never thought that something so dramatic could happened …", "When I think about it, Madam Pervenche seemed to be dating someone in the mansion, I never knew who it was…", "miss Rose");
        prOlive = new Talking("What happened really cut my appetite ... Too bad.. they served lobster this afternoon!", "Mrs. Pervenche? Yes it's true she was cute but unfortunately for her not my style at all..", "Professeur Olive");
        missLeblanc = new Talking("I wasn’t feeling good yesterday after dinner. I went upstairs in my room and I spent the evening and night there. I needed some rest.. and that’s why I’m having a walk in the garden now.", "Mme Pervenche? A good old friend ! I know she wasn’t having a good feeling with Reverend Olive for few days.. too bad he is such a magnificent man...", "miss Leblanc");
        generalLegris = new Talking("I talked a little bit with Dr. Violet. A great scientist, this man!  Not like that idiot of \"Professor\" Olive …", "I saw someone entering the living room, unfortunately lighting is defective in this room, I could not identify who was coming in. Surely this stupid Professor Olive.", "general Legris");
        misterRouge = new Talking("Mrs. Pervenche was a good friend. We used to have good times together.", "She was supposed to spend the evening with me last night, but she never came ... ", "Mister Rouge");
        countOrange = new Talking("Hello inspector, what do you want?  Yes …  I learned for Mrs. Pervench ... It's very unfortunate. Did you find the murderer ?", "I heard Mrs. Pervenche speak to a man when I was in the living room last night, I think they were in the kiosk at this moment.", "Compte Orange");
        countnessOrange = new Talking("Me and my husband the Count Orange have been the owner of this hotel for over 20 years and this is the first time such a horrible thing happens! I am taking a deep breath of fresh air in the kiosk to recover from all these emotions.", "Mrs. Pervenche seemed so friendly, resourceful, and early in life! What a pity..", "Comptesse Orange");

        drViolet = new Killer("Docteur Violet");

        missPrunelle = new Follower("I am only the cleaning lady, but I can help you another way in your investigation.", "miss Prunelle");

        // Add the character into rooms
        fountain.addCharacter(missRose);
        library.addCharacter(clnMoutarde);
        poolRoom.addFollower(missPrunelle);
        veranda.addCharacter(misterRouge);
        barn3.addKiller(drViolet);
        garden.addCharacter(missLeblanc);
        corridor11.addCharacter(countOrange);
        kiosk.addCharacter(countnessOrange);
        livingRoom.addCharacter(prOlive);
        kitchen.addCharacter(generalLegris);

        //Creation of weapons
        rope = new Item("rope","You found a rope on a stool. This is clearly not the murder weapon. However, someone might have thought about suicide, remorse maybe …",2);
        rope.setUse(false); // this item is not usable by the player
        dagger = new Item("dagger","You found a nicely decorated dagger. You question yourself on its presence inside the veranda. But you remind that there were no cutoff marks on the victim. There may be other crimes to come...",2);
        dagger.setUse(false);
        dagger.setHidden(true);
        ironBar = new Item("ironBar","You found a quite impressive iron bare. Exactly the kind of thing that can knock out someone. Or worst. ",2);
        ironBar.setUse(false);
        revolver = new Item("revolver","Hidden into a desk drawer, you found a Revolver with only one bullet in the chamber. Maybe the one that you will keep for Ms Pervenche murderer.",2);
        revolver.setHidden(true); // the revovler is hidden in the room
        revolver.setUse(false);
        candlestick = new Item("candlestick","You found a dusty candlestick. Perfect for a candlelit dinner with Miss Prunelle once this case solved. The duty before everything !",2);
        candlestick.setUse(false);
        wrench = new Item("wrench","You found a wrench. Its implication into the murder seems unlikely. However, you have a sink that has a leakage back home, this might help you to fix it.",2);
        wrench.setUse(false);
        poison = new Item("poison","You found an half empty flask that contains a suspicious liquid. POISON ! This might be the murder weapon, but who would be perfidious enough to use it …",5);
        poison.setUse(false);
        axe = new Item("axe","You found an axe. It reminds you your childhood with your father, who was a lumberjack. You focus and notice that there is no blood on it. On one hand, it would be very barbaric to kill someone with an axe...",2);
        axe.setUse(false);
        
        // Creation of key - code
        keyLibrary = new Item ("Keylibrary","You found the library’s key. Who knows, maybe this key will allow you to open other doors ...",0);
        keyLibrary.setHidden(true);
        keyVeranda = new Item ("Keyveranda","You found the key of the veranda. People always hide strange things in there. Try your luck…",0);
        keyVeranda.setHidden(true);
        keyLivingRoom = new Item ("Keyliving","You found the key of the living room. This is the right occasion to interrogate new suspects. ", 0);
        keyLivingRoom.setHidden(true);
        keyDiningRoom = new Item ("Keydining","You found the dining room’s key. Stroke of luck, the dining room and the living room are communicating rooms !",0);
        keyDiningRoom.setHidden(true);
        
        codeOffice = new Item ("Codeoffice","You found a 4 digits code (4 4 4 4). It looks like they does not bother that much about security here.",1);
        codeOffice.setHidden(true);
        codeKitchen = new Item ("Codekitchen", "You found a 17 digits code. Yes, that is possible. Good luck to memorise the combination of the kitchen’s door.",0);
        codeKitchen.setHidden(true);
        
        //Creation of utilities 
        irGlasses = new Item ("Glasses Infrared","Your extraordinary observation capabilities allow you to discover infrared glasses hidden inside a bush. This might look useless but with it, you will have style !",0);
        irGlasses.setHidden(true);
        gasMask = new Item ("Gas Mask","You found a gas mask from the second world war. Why it is here ? Nevermind, it can be useful at some point.",0);
            
        // Creation of clues
        footPrints = new Item ("Foot prints","You noticed footprints on the ground, from two people. It seems that they were walking towards the garden...",1);
        scarf = new Item ("Scarf","A soft cashmere scarf, color periwinkle, does not fool anyone on the identity of its owner. How did Ms Pervenche lose it ...?",1);
        clothSoaked = new Item ("Soaked cloth","You found a cloth soaked in red wine. This reminds you arguing with your wife on Valentine’s Day…",5);
        hippocraticOath = new Item("Hippocatric Oath","You found a piece of the Hippocratic Oath. That is strange...",5);
        hippocraticOath.setHidden(true);

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
        smallHall.addItem(hippocraticOath);

        notebook = new NoteBook();
        inventory = new Inventory();
        inventory.addItems(rope);
        inventory.addItems(dagger);
        inventory.addItems(keyDiningRoom);

        
        if  (playerClass == "Gadget"){
        player1 = new Player(playerName, hall, notebook, inventory,0,100,500);}
        else if (playerClass == "Colombo"){
        player1 = new Player(playerName, hall, notebook, inventory,0,100,400);}
        else{
        player1 = new Player(playerName, hall, notebook, inventory,0,100,300);}

        System.out.println((player1.getCurrentRoom()).getRoomName());

        // Creation and setting of the menu 
        
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
        
        // Setting the Journal Frame, where all the text from the notebook is displayed
        JFrame journalFrame = new JFrame();
        journalFrame.setTitle("Notebook");
        journalFrame.setSize(900,200);
        journalFrame.setLocationRelativeTo(null);
        JTextArea textJournal = new JTextArea();
        textJournal.setEditable(false);
        textJournal.setLineWrap(true);
        journalFrame.add(textJournal);
        
        reset.addActionListener(ae -> {});
        quit.addActionListener(ae -> {});
        menuHelp.addActionListener(ae -> {});
        menuItems.addActionListener(ae -> {});

//        lMap = new JPanel();
//        map = new JLabel(carte);
//        lMap.add(map);
//        
        
        cPicture = new JLabel();
        cPicture.setIcon(player1.getCurrentRoom().getImage());
        
        lMap = new JLabel();
        lMap.setIcon(player1.getCurrentRoom().getImagePlan());

        
        
        rActions = new JPanel();
        rActions.setLayout(new GridLayout(4, 1));
        btSpeak = new JButton("Speak");
        btExplore = new JButton("Explore");
        btTake = new JButton("Take");
        btJournal = new JButton("Journal");
        rActions.add(btSpeak);
        rActions.add(btExplore);
        rActions.add(btTake);
        rActions.add(btJournal);

        bBar = new JPanel();
        bBar.setLayout(new GridLayout(1, 2));
        bBar.setSize(200, 300);
        JPanel moveBt = new JPanel();
        moveBt.setLayout(new BorderLayout());
        btRight = new JButton("→");
        btLeft = new JButton("←");
        btUp = new JButton("↑");
        btDown = new JButton("↓");
        moveBt.add(btRight, BorderLayout.EAST);
        moveBt.add(btLeft, BorderLayout.WEST);
        moveBt.add(btUp, BorderLayout.NORTH);
        moveBt.add(btDown, BorderLayout.CENTER);
        bBar.add(zoneTexte);
        bBar.add(moveBt);
        

        frame = new JFrame("World Of Zuul");
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(cPicture, BorderLayout.CENTER);
        frame.add(bBar, BorderLayout.SOUTH);
        frame.add(rActions, BorderLayout.EAST);
        frame.add(lMap, BorderLayout.WEST);
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        this.zoneTexte.setText(player1.getCurrentRoom().getDescription());
        
        btRight.addActionListener(ae -> {
            player1.move("right");
            cPicture.setIcon(player1.getCurrentRoom().getImage());
            lMap.setIcon(player1.getCurrentRoom().getImagePlan());
            this.zoneTexte.setText(player1.getCurrentRoom().getDescription());
        });
        btLeft.addActionListener(ae -> {
            player1.move("left");
            cPicture.setIcon(player1.getCurrentRoom().getImage());
            lMap.setIcon(player1.getCurrentRoom().getImagePlan());
            this.zoneTexte.setText(player1.getCurrentRoom().getDescription());
        });
        btUp.addActionListener(ae -> {
            player1.move("up");
            cPicture.setIcon(player1.getCurrentRoom().getImage());
            lMap.setIcon(player1.getCurrentRoom().getImagePlan());
            this.zoneTexte.setText(player1.getCurrentRoom().getDescription());
        });
        btDown.addActionListener(ae -> {
            player1.move("down");
            cPicture.setIcon(player1.getCurrentRoom().getImage());
            lMap.setIcon(player1.getCurrentRoom().getImagePlan());
            this.zoneTexte.setText(player1.getCurrentRoom().getDescription());
        });

        btExplore.addActionListener(ae -> {
            player1.explore(this.zoneTexte);
            System.out.println(player1.getCurrentRoom().getItem(0).getName());
            player1.getTime();
        });
        btTake.addActionListener(ae -> {
            player1.takeItem(zoneTexte);
            player1.getTime();
        });
        
        btSpeak.addActionListener(ae -> {
            player1.speak(zoneTexte);
            player1.getTime();
        });
        btJournal.addActionListener(ae -> {
            textJournal.setText(notebook.getText());
            journalFrame.setVisible(true);
            journalFrame.setAlwaysOnTop(true);
        });
    }

    private void printWelcome() {

    }

    public Player getPlayer() {
        return player1;
    }
}
