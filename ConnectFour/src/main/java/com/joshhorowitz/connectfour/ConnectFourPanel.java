package com.joshhorowitz.connectfour;

/*
 Name: Joshua Horowitz
 File: Connect Four Panel
Purpose: Provides methods to paint the Connect Four Board and the chips throughout the user(s) playing in the JPanel
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ConnectFourPanel extends JPanel {

    private final int[][] connectFourChipsPanel;

    public ConnectFourPanel(int[][] connectFourChips) {
        connectFourChipsPanel = connectFourChips;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintChips(g);
    }
    
    /**
     * This method creates the Connect Four Board and draws chips as they are placed
     * @param g - graphics variable used to paint
     */
    public void paintChips(Graphics g) {
        
        //Draws the outer box
        g.drawRect(50, 50, 504, 450);
        // Draws the columns
        g.drawRect(50, 50, 72, 450);
        g.drawRect(50, 50, 144, 450);
        g.drawRect(50, 50, 216, 450);
        g.drawRect(50, 50, 288, 450);
        g.drawRect(50, 50, 360, 450);
        g.drawRect(50, 50, 432, 450);
        // Draws the rows
        g.drawRect(50, 50, 504, 75);
        g.drawRect(50, 50, 504, 150);
        g.drawRect(50, 50, 504, 225);
        g.drawRect(50, 50, 504, 300);
        g.drawRect(50, 50, 504, 375);
        
        //Draws the chips if any are placed
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 6; c++) {
                if (connectFourChipsPanel[r][c] == 1) { // 1 for red
                    g.setColor(Color.RED);
                    g.fillOval(50 + (72 * r), 50 + (75 * c), 72, 75);
                }
                if (connectFourChipsPanel[r][c] == 2) { // 2 for black
                    g.setColor(Color.BLACK);
                    g.fillOval(50 + (72 * r), 50 + (75 * c), 72, 75);
                }

            }
        }
    }
}
