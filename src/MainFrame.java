
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author satranga
 */
public class MainFrame extends javax.swing.JFrame {

    //Creates final dimensions of JFrame
    public static final int PANEL_WIDTH = 600;
    public static final int PANEL_HEIGHT = 300;
    public static final int PANEL_X = 0;
    public static final int PANEL_Y = 0;
    /**
     * Creates new form NewJFrame
     */

    public ArrayList<JPanel> screens;
    private WheelPanel wheelPanel;
    private PuzzlePanel puzzlePanel;
    private EndPanel endPanel;
    private Player[] players;
    private int currentPlayerIndex;
    private int[] wheelModel;
    private int choice;
    private int turn;

    @SuppressWarnings("empty-statement")
    public MainFrame() throws FileNotFoundException {
        initComponents();

        this.currentPlayerIndex = 0;

        //Frame Setup
        this.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        this.setLocation(PANEL_WIDTH, PANEL_HEIGHT);
        this.setResizable(false);
        Image i = Toolkit.getDefaultToolkit().getImage("wheel.jpg");
        this.setIconImage(i);

        //MultiplePanelCode
        createPlayers();
        createPanels();

        //Sets Up Wheel
        this.wheelModel = new int[]{0, 0, 400, 3500, 900, 900, 1000, 600, 600, 800, 800, 500, 500, 700, 700, 550, 650, 650};

        this.pack();
    }

    public WheelPanel getWheelPanel() {
        return this.wheelPanel;
    }

    public PuzzlePanel getPuzzlePanel() {
        return this.puzzlePanel;
    }

    public EndPanel getEndPanel() {
        return this.endPanel;
    }

    public Player getCurrentPlayer() {
        return this.players[currentPlayerIndex];
    }

    public int getSpin() {
        Random rand = new Random();
        choice = rand.nextInt(18);
        return this.wheelModel[choice];
    }

    // get all players method
    public void nextPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex == (this.players.length)) {
            currentPlayerIndex = 0;
        }
        this.puzzlePanel.resetMoneyLabel();
    }

    private void createPlayers() {
        players = new Player[3];
        this.players[0] = new Player("Grace Hopper");
        this.players[1] = new Player("Albert Einstein");
        this.players[2] = new Player("Isaac Newton");
    }

    public Player getPlayer(int index) {
        return this.players[index];
    }

    public Player[] getAllPlayers() {
        return players;
    }

    private void createPanels() throws FileNotFoundException {
        //ArrayList stores JPanels for easy navigation
        this.screens = new ArrayList<JPanel>();

        //HomePanel Initialization
        HomePanel p1 = new HomePanel();
        p1.setSize(this.getContentPane().getWidth(), this.getContentPane().getHeight());
        p1.setLocation(PANEL_X, PANEL_Y);
        screens.add(p1);
        this.add(p1);
        p1.setVisible(true);

        //WheelPanel Initialization
        this.wheelPanel = new WheelPanel(this);
        this.wheelPanel.setSize(this.getContentPane().getWidth(), this.getContentPane().getHeight());
        this.wheelPanel.setLocation(PANEL_X, PANEL_Y);
        screens.add(this.wheelPanel);
        this.add(this.wheelPanel);
        this.wheelPanel.setVisible(false);

        //PuzzlePanel Initialization
        createPuzzlePanel();

        //ImagePanelInitialization
        ImagePanel p4 = new ImagePanel();
        p4.setSize(this.getContentPane().getWidth(), this.getContentPane().getHeight());
        p4.setLocation(PANEL_X, PANEL_Y);
        screens.add(p4);
        this.add(p4);
        p4.setVisible(true);

        //EndPanelInitialization
        this.endPanel = new EndPanel(this);
        this.endPanel.setSize(this.getContentPane().getWidth(), this.getContentPane().getHeight());
        this.endPanel.setLocation(PANEL_X, PANEL_Y);
        screens.add(this.endPanel);
        this.add(this.endPanel);
        this.endPanel.setVisible(false);

        this.pack();
    }

    //Sets an individual JPanel, the parameter, as visible
    public void showPanel(int panelNum) {
        for (int i = 0; i < screens.size(); i++) {
            screens.get(i).setVisible(false);
        }
        screens.get(panelNum).setVisible(true);
    }

    private void createPuzzlePanel() throws FileNotFoundException {
        PuzzlePanel p = new PuzzlePanel(this);
        p.setSize(this.getContentPane().getWidth(), this.getContentPane().getHeight());
        p.setLocation(PANEL_X, PANEL_Y);

        if (this.puzzlePanel != null) {
            screens.remove(2);
            screens.add(2, p);
            this.remove(this.puzzlePanel);
            this.add(p);
        } else {
            screens.add(p);
            this.add(p);

        }

        this.puzzlePanel = p;
        this.puzzlePanel.setVisible(false);
    }

    public void showContinue() throws FileNotFoundException {
        int selectedOption = JOptionPane.showConfirmDialog(this, "Congrats that's correct! Would you like to continue playing?");
        if (selectedOption == JOptionPane.YES_OPTION) {
            createPuzzlePanel();
            this.getPuzzlePanel().resetMoneyLabel();
            this.showPanel(1);
        } else if (selectedOption == JOptionPane.CANCEL_OPTION) {

        } else { //JOptionPane.NO_OPTION
            this.getEndPanel().rankPlayers();
            this.showPanel(4);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
