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

    JTextArea zoneTexte = new JTextArea(7, 40);
    public ArrayList<JButton> InventoryList;

    private PersuasionBar pBar;
    private TimeBar tBar;
    private LifeBar lBar;

    private Icon pImg, tImg, lImg, pic1, pic2, pic3;
    private JPanel myPanelBar;

    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class World
     *
     * @param playerClass
     * @param playerName
     */
    public World(Player player1, ArrayList<JButton> InventoryList, NoteBook notebook, String playerClass, JButton btTest,
            JButton btTest2, JButton btTest3, JButton btTest4, JButton btTest5, JButton btTest6,
            JButton btTest7, JButton btTest8, JButton btTest9, JButton btTest10, JButton btTest11) {

        // Setting the Journal Frame, where all the text from the notebook is displayed
        journalFrame = new JFrame();
        journalFrame.setTitle("Notebook");
        journalFrame.setSize(900, 200);
        journalFrame.setLocationRelativeTo(null);
        JTextArea textJournal = new JTextArea();
        textJournal.setEditable(false);
        textJournal.setLineWrap(true);
        journalFrame.add(textJournal);

        JLabel co = new JLabel(new ImageIcon(getClass().getResource("/pictures2/hall.png")));
        co.setLayout(new BorderLayout());
        //co.add(panelTest,BorderLayout.SOUTH);
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
        rActions.setLayout(new GridLayout(5, 1));
        //btSpeak = new JButton("Speak");
        btExplore = new JButton("Explore");
        btTake = new JButton("Take");
        btTake.setEnabled(false);
        btHelp = new JButton("Help");
        btAccuse = new JButton("Accuse");
        //rActions.add(btSpeak);
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

        JLabel Life = new JLabel("Vie : ");
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

//        JLabel myLabelNiveau1 = new JLabel("Easy Level");
//        JLabel myLabelNiveau2 = new JLabel("Medium Level");
//        JLabel myLabelNiveau3 = new JLabel("Hard Level");
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

        JOptionPane.showMessageDialog(this,
                "Miss Pervenche has been killed in the manor\n"
                + "You have to find the killer ! \n "
                + "You are " + player1.getName() + " the detective !\n"
                + "Speak to everyone and found the clues. They help you to found the killer \n ",
                "Manor's investigation!",
                JOptionPane.INFORMATION_MESSAGE);

        this.zoneTexte.setText(player1.getCurrentRoom().getDescription());
        zoneTexte.setLineWrap(true);

        btRight.addActionListener(ae -> {
            player1.move("right");

            //cPicture.setIcon(player1.getCurrentRoom().getImage());
            co.removeAll();
            co.setIcon(player1.getCurrentRoom().getImage());
            co.setLayout(new BorderLayout());
            //co.add(panelTest,BorderLayout.SOUTH);
            co.setPreferredSize(new Dimension(800, 800));
            co.setMaximumSize(new Dimension(800, 800));
            co.setMinimumSize(new Dimension(800, 800));
            co.setIcon(player1.getCurrentRoom().getImage());

            if (player1.getCurrentRoom().getButton() != null) {
                player1.getCurrentRoom().getPanel().removeAll();
                player1.getCurrentRoom().getPanel().add(player1.getCurrentRoom().getButton());
                co.add(player1.getCurrentRoom().getPanel(), BorderLayout.SOUTH);
            }

            //btTest.setEnabled(false);
//            co.remove(btTest);
//            co.revalidate();
//            co.repaint();
            lMap.setIcon(player1.getCurrentRoom().getImagePlan());
            this.zoneTexte.setText(player1.getCurrentRoom().getDescription() + "\n");
            btTake.setEnabled(false);
            //btSpeak.setEnabled(true);
            tBar.setValueBar(player1.getTime());
            //Container c = new JLabel(player1.getCurrentRoom().getImage());
            if (player1.getTime() <= 0 | player1.getLife() <= 0) {
                InterfaceGameOver go = new InterfaceGameOver();
            }

        });
        btLeft.addActionListener(ae -> {
            player1.move("left");
            //cPicture.setIcon(player1.getCurrentRoom().getImage());
            co.removeAll();
            co.setIcon(player1.getCurrentRoom().getImage());
            co.setLayout(new BorderLayout());
            //co.add(panelTest,BorderLayout.SOUTH);
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
            //btSpeak.setEnabled(true);
            tBar.setValueBar(player1.getTime());
            if (player1.getTime() <= 0 | player1.getLife() <= 0) {
                InterfaceGameOver go = new InterfaceGameOver();
            }

        });
        btUp.addActionListener(ae -> {
            player1.move("up");
            //cPicture.setIcon(player1.getCurrentRoom().getImage());
//            co.removeAll();
//            co.setIcon(player1.getCurrentRoom().getImage());

            co.removeAll();
            co.setIcon(player1.getCurrentRoom().getImage());
            co.setLayout(new BorderLayout());
            //co.add(panelTest,BorderLayout.SOUTH);
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
            //btSpeak.setEnabled(true);

            tBar.setValueBar(player1.getTime());
            if (player1.getTime() <= 0 | player1.getLife() <= 0) {
                InterfaceGameOver go = new InterfaceGameOver();
            }

        });
        btDown.addActionListener(ae -> {
            player1.move("down");
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

            if (player1.getTime() <= 0 | player1.getLife() <= 0) {
                InterfaceGameOver go = new InterfaceGameOver();
            }

        });

        btExplore.addActionListener(ae -> {
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
            }

        });
        btTake.addActionListener(ae -> {
            player1.takeItem(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
        });

        btTest.addActionListener(ae -> {
            player1.speak(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());

        });

        btTest2.addActionListener(ae -> {
            player1.speak(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
        });

        btTest3.addActionListener(ae -> {
            player1.speak(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
        });
        btTest4.addActionListener(ae -> {
            player1.speak(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());

        });

        btTest5.addActionListener(ae -> {
            player1.speak(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
        });

        btTest6.addActionListener(ae -> {
            player1.speak(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
        });

        btTest7.addActionListener(ae -> {
            player1.speak(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());

        });

        btTest8.addActionListener(ae -> {
            player1.speak(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
        });

        btTest9.addActionListener(ae -> {
            player1.speak(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());
        });

        btTest10.addActionListener(ae -> {
            player1.speak(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());

        });

        btTest11.addActionListener(ae -> {
            player1.speak(zoneTexte);
            player1.getTime();
            btTake.setEnabled(false);
            pBar.setValueBar(player1.getPersuasion());
            tBar.setValueBar(player1.getTime());
            lBar.setValueBar(player1.getLife());

        });

        btJournal.addActionListener(ae -> {
            textJournal.setText(notebook.getText());
            journalFrame.setVisible(true);
            journalFrame.setAlwaysOnTop(true);
            btTake.setEnabled(false);
            tBar.setValueBar(player1.getTime());

        });
        btHelp.addActionListener(ae -> {
            // Supposed to redirect the player to a PDF page (user manual)
            try {
                Runtime r = Runtime.getRuntime();
                r.exec("explorer.exe Bomb.pdf");
            } catch (IOException err) {
                System.out.println("err" + err);
            }
            btTake.setEnabled(false);
        });

        // Setting the Inventory Frame
        btInventory.addActionListener(ae -> {
            JFrame inventoryFrame = new JFrame();
            inventoryFrame.setTitle("Inventory");
            inventoryFrame.setSize(500, 500);
            inventoryFrame.setLayout(new GridLayout(5, 5));
            tBar.setValueBar(player1.getTime());

            for (int i = 0; i < player1.getInventory().ItemsList.size(); i++) {
                InventoryList.add(new JButton("", player1.getInventory().ItemsList.get(i).getImageItem()));
                InventoryList.get(i).setPreferredSize(new Dimension(100, 100));
                inventoryFrame.add(InventoryList.get(i));
            };

            JLabel litem = new JLabel();

            inventoryFrame.setEnabled(true);
            inventoryFrame.setVisible(true);
            inventoryFrame.setAlwaysOnTop(true);

        });

    }

    private void printWelcome() {

    }

}
