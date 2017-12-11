/**
 * This class is used to create the interface for the first window of the game
 *
 * @author (Group2)
 * @version (11/12/17)
 */
package wor;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author G2
 */
public class InterfaceDebut extends JFrame implements ActionListener {

    private final JButton butChar1;
    private final JButton butChar2;
    private final JButton butChar3;
    private final JButton butStart;
    private final JButton butChange;
    //////////////////
    private final JPanel panelBut1 = new JPanel();
    private final JLabel labBut1 = new JLabel("Inspecteur Gadget", JLabel.CENTER); //"Gadget
    private final JLabel labBut4 = new JLabel("EASY LEVEL", JLabel.CENTER);
    private final JPanel pBut1 = new JPanel();

    private final JPanel panelBut2 = new JPanel();
    private final JLabel labBut2 = new JLabel("Inspecteur Columbo", JLabel.CENTER); // Colombo
    private final JLabel labBut5 = new JLabel("MEDIUM LEVEL", JLabel.CENTER);
    private final JPanel pBut2 = new JPanel();

    private final JPanel panelBut3 = new JPanel();
    private final JLabel labBut3 = new JLabel("Sherlock Holmes", JLabel.CENTER); // Holmes
    private final JLabel labBut6 = new JLabel("HARD LEVEL", JLabel.CENTER);
    private final JPanel pBut3 = new JPanel();

    //////////////////
    private final JPanel panelJoueur = new JPanel();
    private final JPanel panelBottom = new JPanel();
    private final JPanel myMainPanel = new JPanel();
    private final JPanel panelStart = new JPanel();
    private final JPanel panelChange = new JPanel();

    //////////////////
    private final JLabel label, labTitle;
    //////////////////

    private JTextField fieldName;

    ///////////////////
    private String playerClass;
    private String playerName;
    private Sounds s;

    /*
   The constructor of the class game is composed of button, panel for each herol and label.
   
     */
    public InterfaceDebut() {

        s.playSoundInfinite("music/panthère_rose.wav"); //long.wav
        this.setTitle("CLUEDO");// Titre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //-----------------------------------------------------------------------
        labTitle = new JLabel("CLUEDO", JLabel.CENTER);
        labTitle.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 45));
        labTitle.setForeground(Color.red);

        //-----------------------------------------------------------------------
        //1er label de la frame 
        label = new JLabel("Choose your Character and player name, then click on start to begin your game!", JLabel.CENTER);
        label.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 25));
        label.setForeground(Color.white);
        JLabel label2 = new JLabel(" ");
        label2.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 25));

        JPanel panLabel = new JPanel(new BorderLayout());
        panLabel.add(labTitle, BorderLayout.NORTH);
        panLabel.add(label, BorderLayout.CENTER);
        panLabel.add(label2, BorderLayout.SOUTH);
        panLabel.setOpaque(false);

        ///////////////////
        //Panel player 1
        labBut1.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 20));
        labBut1.setForeground(Color.white);
        labBut4.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 30));
        labBut4.setForeground(Color.red);
        butChar1 = new JButton(new ImageIcon(getClass().getResource("/pictures2/gadget.jpg")));
        butChar1.setOpaque(false);
        butChar1.setContentAreaFilled(false);
        butChar1.setBorderPainted(false);
        panelBut1.setLayout(new BorderLayout());
        pBut1.add(butChar1);
        pBut1.setOpaque(false);
        panelBut1.add(pBut1, BorderLayout.SOUTH);
        panelBut1.add(labBut1, BorderLayout.CENTER);
        panelBut1.add(labBut4, BorderLayout.NORTH);

        panelBut1.setOpaque(false);
        ///////////////////

        //Panel player 2
        labBut2.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 20));
        labBut2.setForeground(Color.white);
        labBut5.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 30));
        labBut5.setForeground(Color.red);
        butChar2 = new JButton(new ImageIcon(getClass().getResource("/pictures2/colombo.jpg")));
        butChar2.setOpaque(false);
        butChar2.setContentAreaFilled(false);
        butChar2.setBorderPainted(false);
        panelBut2.setLayout(new BorderLayout());
        pBut2.add(butChar2);
        pBut2.setOpaque(false);
        panelBut2.add(pBut2, BorderLayout.SOUTH);
        panelBut2.add(labBut2, BorderLayout.CENTER);
        panelBut2.add(labBut5, BorderLayout.NORTH);
        panelBut2.setOpaque(false);
        ///////////////////

        //Panel player 3
        labBut3.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 20));
        labBut3.setForeground(Color.white);
        labBut6.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 30));
        labBut6.setForeground(Color.red);
        butChar3 = new JButton(new ImageIcon(getClass().getResource("/pictures2/holmes.jpg")));
        butChar3.setOpaque(false);
        butChar3.setContentAreaFilled(false);
        butChar3.setBorderPainted(false);
        panelBut3.setLayout(new BorderLayout());
        pBut3.add(butChar3);
        pBut3.setOpaque(false);
        panelBut3.add(pBut3, BorderLayout.SOUTH);
        panelBut3.add(labBut3, BorderLayout.CENTER);
        panelBut3.add(labBut6, BorderLayout.NORTH);

        panelBut3.setOpaque(false);

        ///////////////////
        JLabel labelName = new JLabel("Enter your name :  ");
        labelName.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 20));
        labelName.setForeground(Color.white);
        fieldName = new JTextField(15);
        JPanel panelName = new JPanel();
        panelName.add(labelName);
        panelName.add(fieldName);
        panelName.setOpaque(false);

        //////////////////
        /// BOTTOM : Boutons start and change
        butStart = new JButton();
        butStart.setPreferredSize(new Dimension(225, 73));
        butStart.setIcon(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));
        butStart.setText("Start Game");
        butStart.setForeground(Color.white);
        butStart.setDisabledIcon(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));
        butStart.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 25));
        butStart.setVerticalTextPosition(SwingConstants.CENTER);
        butStart.setHorizontalTextPosition(SwingConstants.CENTER);

        butChange = new JButton();
        butChange.setPreferredSize(new Dimension(225, 73));
        butChange.setIcon(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));
        butChange.setText("Change player");
        butChange.setForeground(Color.white);
        butChange.setDisabledIcon(new ImageIcon(getClass().getResource("/pictures2/boutton_game2.png")));
        butChange.setFont(new java.awt.Font(Font.SERIF, Font.BOLD, 25));
        butChange.setVerticalTextPosition(SwingConstants.CENTER);
        butChange.setHorizontalTextPosition(SwingConstants.CENTER);

        /////////////////// 
        //Panel Joueur contain all buttons and label of players
        panelJoueur.setLayout(new GridLayout(1, 3));
        panelJoueur.add(panelBut1);
        panelJoueur.add(panelBut2);
        panelJoueur.add(panelBut3);
        panelJoueur.setOpaque(false);

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());
        panelCenter.add(panelJoueur, BorderLayout.CENTER);
        panelCenter.add(panelName, BorderLayout.SOUTH);
        panelCenter.setOpaque(false);

        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(panelStart);
        panelBottom.add(panelChange);
        panelBottom.setOpaque(false);

        panelStart.add(butStart);
        panelStart.setOpaque(false);
        panelChange.add(butChange);
        panelChange.setOpaque(false);

        myMainPanel.setLayout(new BorderLayout());
        myMainPanel.add(panLabel, BorderLayout.NORTH);
        myMainPanel.add(panelCenter, BorderLayout.CENTER);
        myMainPanel.add(panelBottom, BorderLayout.SOUTH);
        myMainPanel.setOpaque(false);

        //Action definition for every buttons
        butChar1.addActionListener(this);
        butChar2.addActionListener(this);
        butChar3.addActionListener(this);
        butStart.addActionListener(this);
        butChange.addActionListener(this);

        butStart.setEnabled(false);
        butChange.setEnabled(false);
        Container c = new JLabel(makeImage());
        c.setLayout(new FlowLayout());
        c.add(myMainPanel);

        c.setPreferredSize(new Dimension(800, 800));
        c.setMaximumSize(new Dimension(800, 800));
        c.setMinimumSize(new Dimension(800, 800));
        this.add(c);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(1000, 550));
        this.setMaximumSize(new Dimension(1000, 550));
        this.setMinimumSize(new Dimension(1000, 550));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /*
   The method makeImage allows to return the background of the home panel of the game. 
     */
    private ImageIcon makeImage() {
        return new ImageIcon(getClass().getResource("/pictures2/testhorreur2.jpg"));
    }

    /*
   The method actionPerformed allows to make action in fonction of the button 
   clicked by the player.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // When the user click on Marion's picture, the button Start and Change 
        //become accessible but all the other hero button become unaccessible 

        if (e.getSource() == butChar1) //Marion
        {
            playerClass = "Gadget";
            butStart.setEnabled(true);
            butChange.setEnabled(true);
            butChar2.setEnabled(false);
            butChar3.setEnabled(false);
        } else if (e.getSource() == butChar2) // Marin
        {
            playerClass = "Colombo";
            butStart.setEnabled(true);
            butChange.setEnabled(true);
            butChar1.setEnabled(false);
            butChar3.setEnabled(false);
        } else if (e.getSource() == butChar3) // Paul
        {
            playerClass = "Holmes";
            butStart.setEnabled(true);
            butChange.setEnabled(true);
            butChar1.setEnabled(false);
            butChar2.setEnabled(false);
        } else if (e.getSource() == butStart) {
            playerName = fieldName.getText();
            if (!fieldName.getText().isEmpty()) {
                InitializeGame g = new InitializeGame(playerClass, playerName.toUpperCase());
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Please insert a name.", "Name", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (e.getSource() == butChange) {
            butStart.setEnabled(false);
            butChange.setEnabled(false);
            butChar1.setEnabled(true);
            butChar2.setEnabled(true);
            butChar3.setEnabled(true);
        }
    }
}
