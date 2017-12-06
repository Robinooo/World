package wor;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Write a description of class World here.
 *
 * @author (Group2)
 * @version (11/23/17)
 */
public class World extends JFrame {

    private final JFrame frame, journalFrame;
    private final JButton btUp, btDown, btLeft, btRight, btExplore, btTake, btJournal, btInventory, btHelp, btAccuse; //btSPeak
    private final JPanel bBar, rActions;
    private JLabel cPicture, lMap;
   // private JLabel test;
    private Sounds s;
    private final int u = 100;

    JTextArea zoneTexte = new JTextArea(7, 52);

    private PersuasionBar pBar;
    private TimeBar tBar;
    private LifeBar lBar;

    private Icon pImg, tImg, lImg, pic1, pic2, pic3;
    private JPanel myPanelBar;

    private JPanel journalPanel;
    private ArrayList<JButton> InventoryList;
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class World
     *
     * @param playerClass
     * @param playerName
     */
    public World(Player player1, NoteBook notebook, String playerClass, ArrayList<Room> listRoom, JButton btTest2) {

        // Setting the Journal Frame, where all the text from the notebook is displayed
        journalFrame = new JFrame();
        journalPanel = new JPanel();
        journalPanel.setName("Notebook");
        journalPanel.setLayout(new BorderLayout());
        JTextArea textJournal = new JTextArea();
        journalPanel.add(textJournal);
        JScrollPane jScrollPane = new JScrollPane(journalPanel);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        journalFrame.getContentPane().add(jScrollPane);

        journalFrame.setTitle("Notebook");
        journalFrame.setSize(900, 200);
        journalFrame.setLocationRelativeTo(null);
        textJournal.setEditable(false);
        textJournal.setLineWrap(true);

        JLabel co = new JLabel(new ImageIcon(getClass().getResource("/pictures2/hall.png")));
        co.setLayout(new BorderLayout());
        co.setPreferredSize(new Dimension(800, 800));
        co.setMaximumSize(new Dimension(800, 800));
        co.setMinimumSize(new Dimension(800, 800));

        if (player1.getCurrentRoom().getButton() != null) {
            player1.getCurrentRoom().getPanel().removeAll();
            player1.getCurrentRoom().getPanel().add(player1.getCurrentRoom().getButton());
            co.add(player1.getCurrentRoom().getPanel(), BorderLayout.SOUTH);
        }

        cPicture = new JLabel();
        cPicture.setIcon(player1.getCurrentRoom().getImage());

        lMap = new JLabel();
        lMap.setIcon(player1.getCurrentRoom().getImagePlan());

        rActions = new JPanel();
        rActions.setLayout(new GridLayout(6, 1));
        //btExplore = new JButton(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));;
        btExplore = new JButton();
        btExplore.setPreferredSize(new Dimension(240,75));
        btExplore.setIcon(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));
        btExplore.setText("Explore");
        btExplore.setForeground(Color.red);
        btExplore.setDisabledIcon(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));
        btExplore.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 25));
        btExplore.setVerticalTextPosition(SwingConstants.CENTER);
        btExplore.setHorizontalTextPosition(SwingConstants.CENTER);
        
        
        btTake = new JButton("Take");
        btTake.setEnabled(false);
        btTake.setPreferredSize(new Dimension(240,75));
        btTake.setIcon(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));
        btTake.setText("Take");
        btTake.setForeground(Color.red);
        btTake.setDisabledIcon(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));
        btTake.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 25));
        btTake.setVerticalTextPosition(SwingConstants.CENTER);
        btTake.setHorizontalTextPosition(SwingConstants.CENTER);
        
        btHelp = new JButton("Help");
        btHelp.setPreferredSize(new Dimension(240,75));
        btHelp.setIcon(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));
        btHelp.setText("Help");
        btHelp.setForeground(Color.red);
        btHelp.setDisabledIcon(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));
        btHelp.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 25));
        btHelp.setVerticalTextPosition(SwingConstants.CENTER);
        btHelp.setHorizontalTextPosition(SwingConstants.CENTER);
        
        
        btAccuse = new JButton("Accuse");
        btAccuse.setPreferredSize(new Dimension(240,75));
        btAccuse.setIcon(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));
        btAccuse.setText("Accuse");
        btAccuse.setForeground(Color.red);
        btAccuse.setDisabledIcon(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));
        btAccuse.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 25));
        btAccuse.setVerticalTextPosition(SwingConstants.CENTER);
        btAccuse.setHorizontalTextPosition(SwingConstants.CENTER);
        
        
        
        rActions.add(btExplore);
        rActions.add(btTake);
        rActions.add(btHelp);
        rActions.add(btAccuse);

        bBar = new JPanel();
        bBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel moveBt = new JPanel();
        moveBt.setLayout(new BorderLayout());
        btInventory = new JButton("", new ImageIcon(getClass().getResource("/pictures2/bag.png")));
        btInventory.setOpaque(false);
        btInventory.setContentAreaFilled(false);
        btInventory.setBorderPainted(false);
        btJournal = new JButton("", new ImageIcon(getClass().getResource("/pictures2/notebook.png")));
        btJournal.setOpaque(false);
        btJournal.setContentAreaFilled(false);
        btJournal.setBorderPainted(false);
        rActions.add(btInventory);

        btRight = new JButton("→");
        btLeft = new JButton("←");
        btUp = new JButton("↑");
        btDown = new JButton("↓");
        moveBt.add(btRight, BorderLayout.EAST);
        moveBt.add(btLeft, BorderLayout.WEST);
        moveBt.add(btUp, BorderLayout.NORTH);
        moveBt.add(btDown, BorderLayout.CENTER);
        bBar.add(btJournal);
        bBar.add(btInventory);
        bBar.add(zoneTexte);
        bBar.add(moveBt);

        lImg = new ImageIcon(getClass().getResource("/pictures2/life.png"));

        pImg = new ImageIcon(getClass().getResource("/pictures2/persuasion.jpg"));

        tImg = new ImageIcon(getClass().getResource("/pictures2/time.jpg"));

        pBar = new PersuasionBar();
        pBar.setValueBar(player1.getPersuasion());

        tBar = new TimeBar();
        tBar.setValueBar(player1.getTime());

        lBar = new LifeBar();
        lBar.setValueBar(player1.getLife());

        JLabel Persuasion = new JLabel("Persuasion : ");
        Persuasion.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 15));
        Persuasion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JLabel Time = new JLabel("Time : ");
        Time.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 15));
        Time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JLabel Life = new JLabel("Life Points : ");
        Life.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 15));
        Life.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JLabel myLabelPersuasion = new JLabel();
        myLabelPersuasion.setIcon(pImg);

        JLabel myLabelLife = new JLabel();
        myLabelLife.setIcon(lImg);

        JLabel myLabelTime = new JLabel();
        myLabelTime.setIcon(tImg);

        myLabelPersuasion.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 15));
        myLabelPersuasion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        myLabelLife.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 15));
        myLabelLife.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        myLabelTime.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 15));
        myLabelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        myPanelBar = new JPanel();
        myPanelBar.setLayout(new GridLayout(3, 3));

        myPanelBar.add(myLabelPersuasion);
        myPanelBar.add(Persuasion);
        myPanelBar.add(pBar.getPersuasionBar());

        myPanelBar.add(myLabelTime);
        myPanelBar.add(Time);
        myPanelBar.add(tBar.getTimeBar());

        myPanelBar.add(myLabelLife);
        myPanelBar.add(Life);
        myPanelBar.add(lBar.getLifeBar());

        pic1 = new ImageIcon(getClass().getResource("/pictures2/gadget.jpg"));
        pic2 = new ImageIcon(getClass().getResource("/pictures2/colombo.jpg"));
        pic3 = new ImageIcon(getClass().getResource("/pictures2/holmes.jpg"));

        JLabel myLabelperso = new JLabel();

        if (playerClass == "Gadget") {
            myLabelperso.setIcon(pic1);
        } else if (playerClass == "Colombo") {
            myLabelperso.setIcon(pic2);
        } else if (playerClass == "Holmes") {
            myLabelperso.setIcon(pic3);
        }

        JLabel myLabelNiveau1 = new JLabel("Easy Level");
        JLabel myLabelNiveau2 = new JLabel("Medium Level");
        JLabel myLabelNiveau3 = new JLabel("Hard Level");

        if (playerClass == "Gadget") {
            myLabelperso.setIcon(pic1);
        } else if (playerClass == "Colombo") {
            myLabelperso.setIcon(pic2);
        } else {
            myLabelperso.setIcon(pic3);
        }

        myLabelperso.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 15));
        myLabelperso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        //JLabel myLabelNiveau = new JLabel("test");
        myLabelNiveau1.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 30));
        myLabelNiveau1.setForeground(Color.red);
        myLabelNiveau1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myLabelNiveau2.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 30));
        myLabelNiveau2.setForeground(Color.red);
        myLabelNiveau2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myLabelNiveau3.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 30));
        myLabelNiveau3.setForeground(Color.red);
        myLabelNiveau3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JPanel myPaneltout = new JPanel();
        myPaneltout.setLayout(new BorderLayout());
        myPaneltout.add(myPanelBar, BorderLayout.WEST);
        myPaneltout.add(myLabelperso, BorderLayout.EAST);

        if (playerClass == "Gadget") {
            myPaneltout.add(myLabelNiveau1, BorderLayout.CENTER);
        } else if (playerClass == "Colombo") {
            myPaneltout.add(myLabelNiveau2, BorderLayout.CENTER);
        } else if (playerClass == "Holmes") {
            myPaneltout.add(myLabelNiveau3, BorderLayout.CENTER);
        };

        frame = new JFrame();
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(co, BorderLayout.CENTER);
        frame.add(bBar, BorderLayout.SOUTH);
        frame.add(rActions, BorderLayout.EAST);
        frame.add(lMap, BorderLayout.WEST);
        frame.add(myPaneltout, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        JOptionPane.showMessageDialog(this,
                "Miss Pervenche has been killed in the manor.\n"
                + "You have to find the killer ! \n "
                + "You are " + player1.getName() + " the detective !\n"
                + "Speak to everyone and found the clues. They help you to found the killer.",
                "Manor's investigation!",
                JOptionPane.INFORMATION_MESSAGE);

        this.zoneTexte.setText(player1.getCurrentRoom().getDescription());
        zoneTexte.setLineWrap(true);

        btRight.addActionListener(ae -> {
            Killer k = new Killer("test");
            int v = -1;
            k.kill(player1, v);

            if (v == 1) {
                btExplore.setEnabled(true);
            };

            if (v == 0) {
                removeAllBt();
            };

            player1.move("right");
            if ("office".equals(player1.getCurrentRoom().getRoomName())) {
                if (player1.getCurrentRoom().getNoir()) {
                    btExplore.setEnabled(false);
                    boolean find = false;
                    if (!player1.getInventory().ItemsList.isEmpty()) {
                        for (int i = 0; i < player1.getInventory().ItemsList.size(); i++) {
                            if ("Glasses Infrared".equals(player1.getInventory().ItemsList.get(i).getName())) {
                                player1.getCurrentRoom().setImage(new ImageIcon(getClass().getResource("/pictures2/office.jpeg")));
                                player1.getCurrentRoom().setNoir(false);
                                JOptionPane.showMessageDialog(null, "Your night vision goggles allow you to see what's in this room.",
                                        "Ambush", JOptionPane.INFORMATION_MESSAGE);
                                btExplore.setEnabled(true);
                                find = true;
                                break;
                            }
                        }
                        if (!find) {
                            JOptionPane.showMessageDialog(null, "This room is plunged into darkness.\n"
                                    + "You would need something that lets you see in the dark like cat's eyes\n"
                                    + "... or night vision goggles",
                                    "Ambush", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }

            if ("hall".equals(player1.getCurrentRoom().getRoomName())) {
                btAccuse.setEnabled(true);
            } else {
                btAccuse.setEnabled(false);
            }
            if ("barn 2".equals(player1.getCurrentRoom().getRoomName()) && player1.getCurrentRoom().getNoir()) {
                JOptionPane.showMessageDialog(null, "The light goes out suddenly.",
                        "Black room", JOptionPane.INFORMATION_MESSAGE);
                btExplore.setEnabled(false);
            }

            if ("kiosk".equals(player1.getCurrentRoom().getRoomName())
                    || "garden".equals(player1.getCurrentRoom().getRoomName())
                    || "veranda".equals(player1.getCurrentRoom().getRoomName())) {
                s.playSoundSingle("music/birds.wav");
            }

            if ("fountain".equals(player1.getCurrentRoom().getRoomName())) {
                s.playSoundSingle("music/source.wav");
            }

            co.removeAll();
            co.setIcon(player1.getCurrentRoom().getImage());
            co.setLayout(new BorderLayout());
            co.setPreferredSize(new Dimension(800, 800));
            co.setMaximumSize(new Dimension(800, 800));
            co.setMinimumSize(new Dimension(800, 800));
            co.setIcon(player1.getCurrentRoom().getImage());

            if (player1.getCurrentRoom().getButton() != null) {
                player1.getCurrentRoom().getPanel().removeAll();
                player1.getCurrentRoom().getPanel().add(player1.getCurrentRoom().getButton());
                co.add(player1.getCurrentRoom().getPanel(), BorderLayout.SOUTH);
            }

            lMap.setIcon(player1.getCurrentRoom().getImagePlan());
            this.zoneTexte.setText(player1.getCurrentRoom().getDescription() + "\n");
            btTake.setEnabled(false);
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
            if (player1.getTime() == 0 | player1.getLife() == 0) {
                InterfaceGameOver go = new InterfaceGameOver();
                btUp.setEnabled(false);
                btDown.setEnabled(false);
                btLeft.setEnabled(false);
                btRight.setEnabled(false);
                btExplore.setEnabled(false);
                btHelp.setEnabled(false);
                btAccuse.setEnabled(false);
            }
        }
        );
        btLeft.addActionListener(ae
                -> {
            if ("office".equals(player1.getCurrentRoom().getRoomName())) {
                btExplore.setEnabled(true);
            }
            if ("barn 2".equals(player1.getCurrentRoom().getRoomName())) {
                if (player1.getCurrentRoom().getNoir()) {
                    boolean survival = false;
                    JOptionPane.showMessageDialog(null, "You hear something approaching. It attacks you!",
                            "Ambush", JOptionPane.INFORMATION_MESSAGE);
                    if (!player1.getInventory().ItemsList.isEmpty()) {
                        for (int i = 0; i < player1.getInventory().ItemsList.size(); i++) {
                            if (player1.getInventory().ItemsList.get(i).getName().equals("Shield")) {
                                JOptionPane.showMessageDialog(null, "You take out your shield in haste.\n "
                                        + "The weapon hits your shield and your attacker runs away.\n "
                                        + "You turn on the light, there is no one in the room.",
                                        "Ambush", JOptionPane.INFORMATION_MESSAGE);
                                survival = true;
                                player1.getCurrentRoom().setImage(new ImageIcon(getClass().getResource("/pictures2/grange2.jpg")));
                                player1.getCurrentRoom().setNoir(false);
                                btExplore.setEnabled(true);
                                break;
                            }
                        }
                    }
                    if (!survival) {
                        JOptionPane.showMessageDialog(null, "You had nothing to deflect the blade that hit you. "
                                + "The blow touched a vital point. "
                                + "You will not get away this time ...",
                                "Ambush", JOptionPane.INFORMATION_MESSAGE);
                        InterfaceGameOver theEnd = new InterfaceGameOver();
                        btUp.setEnabled(false);
                        btDown.setEnabled(false);
                        btLeft.setEnabled(false);
                        btRight.setEnabled(false);
                        btExplore.setEnabled(false);
                        btHelp.setEnabled(false);
                        btAccuse.setEnabled(false);
                    }
                } else {
                    btExplore.setEnabled(true);
                }
            }
            player1.move("left");
            if ("hall".equals(player1.getCurrentRoom().getRoomName())) {
                btAccuse.setEnabled(true);
            } else {
                btAccuse.setEnabled(false);
            }
            co.removeAll();
            co.setIcon(player1.getCurrentRoom().getImage());
            co.setLayout(new BorderLayout());
            co.setPreferredSize(new Dimension(800, 800));
            co.setMaximumSize(new Dimension(800, 800));
            co.setMinimumSize(new Dimension(800, 800));
            if (player1.getCurrentRoom().getButton() != null) {
                player1.getCurrentRoom().getPanel().removeAll();
                player1.getCurrentRoom().getPanel().add(player1.getCurrentRoom().getButton());
                co.add(player1.getCurrentRoom().getPanel(), BorderLayout.SOUTH);
            }

            lMap.setIcon(player1.getCurrentRoom().getImagePlan());
            this.zoneTexte.setText(player1.getCurrentRoom().getDescription() + "\n");
            btTake.setEnabled(false);
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
            if (player1.getTime() <= 0 | player1.getLife() <= 0) {
                InterfaceGameOver go = new InterfaceGameOver();
                btUp.setEnabled(false);
                btDown.setEnabled(false);
                btLeft.setEnabled(false);
                btRight.setEnabled(false);
                btExplore.setEnabled(false);
                btHelp.setEnabled(false);
                btAccuse.setEnabled(false);
            }

            if ("kiosk".equals(player1.getCurrentRoom().getRoomName())
                    || "garden".equals(player1.getCurrentRoom().getRoomName())
                    || "veranda".equals(player1.getCurrentRoom().getRoomName())) {
                s.playSoundSingle("music/birds.wav");
            }

            if ("fountain".equals(player1.getCurrentRoom().getRoomName())) {
                s.playSoundSingle("music/source.wav");
            }

        }
        );
        btUp.addActionListener(ae
                -> {
            player1.move("up");
            if ("hall".equals(player1.getCurrentRoom().getRoomName())) {
                btAccuse.setEnabled(true);
            } else {
                btAccuse.setEnabled(false);
            }
            co.removeAll();
            co.setIcon(player1.getCurrentRoom().getImage());
            co.setLayout(new BorderLayout());
            co.setPreferredSize(new Dimension(800, 800));
            co.setMaximumSize(new Dimension(800, 800));
            co.setMinimumSize(new Dimension(800, 800));
            if (player1.getCurrentRoom().getButton() != null) {
                player1.getCurrentRoom().getPanel().removeAll();
                player1.getCurrentRoom().getPanel().add(player1.getCurrentRoom().getButton());
                co.add(player1.getCurrentRoom().getPanel(), BorderLayout.SOUTH);
            }

            lMap.setIcon(player1.getCurrentRoom().getImagePlan());
            this.zoneTexte.setText(player1.getCurrentRoom().getDescription() + "\n");
            btTake.setEnabled(false);
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
            if (player1.getTime() <= 0 | player1.getLife() <= 0) {
                InterfaceGameOver go = new InterfaceGameOver();
                btUp.setEnabled(false);
                btDown.setEnabled(false);
                btLeft.setEnabled(false);
                btRight.setEnabled(false);
                btExplore.setEnabled(false);
                btHelp.setEnabled(false);
                btAccuse.setEnabled(false);
            }

            if ("kiosk".equals(player1.getCurrentRoom().getRoomName())
                    || "garden".equals(player1.getCurrentRoom().getRoomName())
                    || "veranda".equals(player1.getCurrentRoom().getRoomName())) {
                s.playSoundSingle("music/birds.wav");
            }

            if ("fountain".equals(player1.getCurrentRoom().getRoomName())) {
                s.playSoundSingle("music/source.wav");
            }
        }
        );
        btDown.addActionListener(ae
                -> {
            player1.move("down");
            if (player1.getCurrentRoom().getGaz()) {
                JOptionPane.showMessageDialog(null, "The room is full of gas. Without protection you will quickly suffocate.",
                        "Gas", JOptionPane.INFORMATION_MESSAGE);
                btExplore.setEnabled(false);
                boolean survival = false;
                if (!player1.getInventory().ItemsList.isEmpty()) {
                    for (int i = 0; i < player1.getInventory().ItemsList.size(); i++) {
                        if (player1.getInventory().ItemsList.get(i).getName().equals("Gas Mask")) {
                            JOptionPane.showMessageDialog(null, "With your gas mask you can breathe. \n"
                                    + "You can explore the room quietly.",
                                    "Gas", JOptionPane.INFORMATION_MESSAGE);
                            survival = true;
                            player1.getCurrentRoom().setImage(new ImageIcon(getClass().getResource("/pictures2/cuisine.jpg")));
                            player1.getCurrentRoom().setGaz(false);
                            btExplore.setEnabled(true);
                            break;
                        }
                    }
                }
                if (!survival) {
                    JOptionPane.showMessageDialog(null, "As you enter, you feel your lungs burn. Get out before dying of asphyxiation.",
                            "Gas", JOptionPane.INFORMATION_MESSAGE);
                    player1.setLife(15);
                }
            }
            if ("hall".equals(player1.getCurrentRoom().getRoomName())) {
                btAccuse.setEnabled(true);
            } else {
                btAccuse.setEnabled(false);
            }
            co.removeAll();
            co.setIcon(player1.getCurrentRoom().getImage());
            co.setLayout(new BorderLayout());
            co.setPreferredSize(new Dimension(800, 800));
            co.setMaximumSize(new Dimension(800, 800));
            co.setMinimumSize(new Dimension(800, 800));

            if (player1.getCurrentRoom().getButton() != null) {
                player1.getCurrentRoom().getPanel().removeAll();
                player1.getCurrentRoom().getPanel().add(player1.getCurrentRoom().getButton());
                co.add(player1.getCurrentRoom().getPanel(), BorderLayout.SOUTH);
            }

            lMap.setIcon(player1.getCurrentRoom().getImagePlan());
            this.zoneTexte.setText(player1.getCurrentRoom().getDescription() + "\n");
            btTake.setEnabled(false);
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
            if (player1.getTime() <= 0 | player1.getLife() <= 0) {
                InterfaceGameOver go = new InterfaceGameOver();
                btUp.setEnabled(false);
                btDown.setEnabled(false);
                btLeft.setEnabled(false);
                btRight.setEnabled(false);
                btExplore.setEnabled(false);
                btHelp.setEnabled(false);
                btAccuse.setEnabled(false);
            }

            if ("kiosk".equals(player1.getCurrentRoom().getRoomName())
                    || "garden".equals(player1.getCurrentRoom().getRoomName())
                    || "veranda".equals(player1.getCurrentRoom().getRoomName())) {
                s.playSoundSingle("music/birds.wav");
            }

            if ("fountain".equals(player1.getCurrentRoom().getRoomName())) {
                s.playSoundSingle("music/source.wav");
            }
        }
        );

        btExplore.addActionListener(ae
                -> {
            player1.explore(this.zoneTexte);
            player1.getTime();
            if (!player1.getCurrentRoom().listItem.isEmpty()) {
                btTake.setEnabled(true);

            }
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());

            if (player1.getTime() <= 0 | player1.getLife() <= 0) {
                InterfaceGameOver go = new InterfaceGameOver();
                btUp.setEnabled(false);
                btDown.setEnabled(false);
                btLeft.setEnabled(false);
                btRight.setEnabled(false);
                btExplore.setEnabled(false);
                btHelp.setEnabled(false);
                btAccuse.setEnabled(false);
            }

        }
        );
        btTake.addActionListener(ae
                -> {
            player1.takeItem(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
        }
        );

        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getButton() != null) {
                listRoom.get(i).getButton().addActionListener(ae
                        -> {
                    player1.speak(zoneTexte);
                    player1.getTime();
                    btTake.setEnabled(false);
                    pBar.setValueBar(player1.getPersuasion());
                    tBar.setValueBar(player1.getTime());
                    lBar.setValueBar(player1.getLife());
                }
                );
            }
        }

        btTest2.addActionListener(ae -> {
            player1.getCurrentRoom().getFollowerInTheRoom().Follow();
            player1.setTime(2);
            zoneTexte.setText(player1.getCurrentRoom().getFollowerInTheRoom().getspeach() + "\n");
            notebook.addText(player1.getCurrentRoom().getFollowerInTheRoom().getName() + " : " + player1.getCurrentRoom().getFollowerInTheRoom().getspeach() + "\n");
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
            zoneTexte.append("Miss Prunelle joined you in your investigation ! This may help you gaining some time !");
            notebook.addText("Miss Prunelle joined you in your investigation ! This may help you gaining some time !");
        });

        // Setting the Journal Frame
        btJournal.addActionListener(ae
                -> {
            textJournal.setText(notebook.getText() + " \n ");
            journalFrame.setVisible(true);
            journalFrame.setAlwaysOnTop(true);
            journalPanel.setVisible(true);
            btTake.setEnabled(false);
            tBar.setValueBar(player1.getTime());

        }
        );

        // Setting the Help Frame
        btHelp.addActionListener(ae
                -> {
            // Supposed to redirect the player to a PDF page (user manual)
            try {
                Desktop.getDesktop().open(new File("CLUEDO.pdf"));
            } catch (IOException f) {

                f.printStackTrace();
            }
            btTake.setEnabled(false);
        }
        );

        // Setting the Accuse Frame
        btAccuse.addActionListener(ae
                -> {
            JLabel label1list = new JLabel("Who is the killer");
            JLabel label2list = new JLabel("the weapon");
            JLabel label3list = new JLabel("Room");
            String[] nom = {" ", "Countesse Orange", "Count Orange", "Mr. Rouge", "Gen. Legris", "Dr. Violet", "Mrs. Leblanc", "Pr. Olive", "Ms. Rose", "Col. Moutarde"};
            String[] arme = {" ", "Rope", "Dagger", "Iron bar", "Revolver", "Candlestick", "Wrench", "Poison", "Axe"};
            String[] room = {" ", "Fountain", "Library", "Poolroom", "Office", "Veranda", "Barn first", "Barn second", "Barn fird", "Garden", "Hall", "Small hall", "Kiosk", "Living room", "Dining room", "Kitchen"};
            JComboBox comboKill = new JComboBox(nom);
            JComboBox comboWeap = new JComboBox(arme);
            JComboBox comboRoom = new JComboBox(room);
            JButton btOk = new JButton("Valid");
            JPanel myPanelList = new JPanel();
            myPanelList.setLayout(new GridLayout(7, 1));
            myPanelList.add(label1list);
            myPanelList.add(comboKill);
            myPanelList.add(label2list);
            myPanelList.add(comboWeap);
            myPanelList.add(label3list);
            myPanelList.add(comboRoom);
            myPanelList.add(btOk);
            JFrame myFrame = new JFrame("FlowLayout");
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.setLayout(new FlowLayout());
            myFrame.add(myPanelList);
            myFrame.pack();
            myFrame.setSize(300, 300);
            myFrame.setVisible(true);
            btOk.addActionListener(ee -> {
                if (!" ".equals(comboKill.getSelectedItem())
                        && !" ".equals(comboWeap.getSelectedItem())
                        && !" ".equals(comboRoom.getSelectedItem())) {
                    if (comboKill.getSelectedItem().equals("Dr. Violet") && comboWeap.getSelectedItem().equals("Poison") && comboRoom.getSelectedItem().equals("Small hall")) {
                        InterfaceWin go = new InterfaceWin();
                        myFrame.dispose();
                    } else {
                        myFrame.dispose();
                        if (comboKill.getSelectedItem().equals("Dr Violet")) {
                            if (comboWeap.getSelectedItem().equals("Poison")) {
                                JOptionPane.showMessageDialog(null, "I'm sorry to tell you that you are wrong inspector.\n"
                                        + "The murder did not happen in the " + comboRoom.getSelectedItem(), "Results", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                if (comboRoom.getSelectedItem().equals("Small hall")) {
                                    JOptionPane.showMessageDialog(null, "I'm sorry to tell you that you are wrong inspector..\n"
                                            + "The murder was not committed with the " + comboWeap.getSelectedItem(), "Results", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "I'm sorry to tell you that you are wrong inspector..\n"
                                            + "The murder did not happen in the " + comboRoom.getSelectedItem() + "\n"
                                            + "And was not committed with the " + comboWeap.getSelectedItem() + "\n", "Results", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        } else {
                            if (comboWeap.getSelectedItem().equals("Poison")) {
                                if (comboRoom.getSelectedItem().equals("Small hall")) {
                                    JOptionPane.showMessageDialog(null, "I'm sorry to tell you that you are wrong inspector..\n"
                                            + "It was not " + comboKill.getSelectedItem() + " who killed her.\n", "Results", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "I'm sorry to tell you that you are wrong inspector..\n"
                                            + "It was not " + comboKill.getSelectedItem() + " who killed her.\n"
                                            + "The murder did not happen in the " + comboRoom.getSelectedItem() + "\n", "Results", JOptionPane.INFORMATION_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "I'm sorry to tell you that you are wrong inspector..\n"
                                        + "None of your suggestions is good.\n", "Results", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        player1.setTime(10);
                    }
                }
            });
        });

        // Setting the Inventory Frame
        btInventory.addActionListener(ae
                -> {
            JFrame inventoryFrame = new JFrame();
            ArrayList<JButton> InventoryList = new ArrayList<JButton>();
            inventoryFrame.setTitle("Inventory");
            inventoryFrame.setSize(700, 370);
            
            JPanel panelinv = new JPanel();
            //inventoryFrame.setLayout(new GridLayout(5, 5));
            panelinv.setLayout(new GridLayout(3, 7));
            tBar.setValueBar(player1.getTime());


            for (int i = 0; i < player1.getInventory2().ItemsList.size(); i++) 
            {
                InventoryList.add(new JButton("", player1.getInventory2().ItemsList.get(i).getImageItem()));
                //InventoryList.add(new JButton(player1.getInventory2().ItemsList.get(i).getDescription(), player1.getInventory2().ItemsList.get(i).getImageItem()));
                InventoryList.get(i).setEnabled(false);
                //InventoryList.get(i).setPreferredSize(new Dimension(1000, 700));
                panelinv.setPreferredSize(new Dimension(1000, 1000));
                panelinv.add(InventoryList.get(i));
                
                for (int k = 0; k < player1.getInventory().ItemsList.size(); k++) 
                {
                  if (player1.getInventory2().ItemsList.get(i) == player1.getInventory().ItemsList.get(k))
                  InventoryList.get(i).setEnabled(true); 
                }     
            };

            JLabel litem = new JLabel();
            litem.setLayout(new BorderLayout());
            litem.add(panelinv);

            JLabel test = new JLabel();
            for (int i = 0; i < player1.getInventory2().ItemsList.size(); i++) 
            {
                 int u = i;
                 InventoryList.get(i).addActionListener(aeb -> {
                 test.setText(player1.getInventory2().ItemsList.get(u).getDescription());
                 });
            }
            test.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 20));
            test.setForeground(Color.red);
            litem.add(test,BorderLayout.SOUTH);
         
            inventoryFrame.add(litem);
            inventoryFrame.setEnabled(true);
            inventoryFrame.setVisible(true);
            inventoryFrame.setAlwaysOnTop(true);
  
        }
        );

    }

    private void printWelcome() {

    }

    public void removeAllBt() {
        btUp.setEnabled(false);
        btDown.setEnabled(false);
        btLeft.setEnabled(false);
        btRight.setEnabled(false);
        btExplore.setEnabled(false);
        btHelp.setEnabled(false);
        btAccuse.setEnabled(false);
    }

}