package com.joshhorowitz.connectfour;

/*
Name: Joshua Horowitz
File: Connect Four App
Purpose: To create a Connect Four game using Java Swing

 */

import javax.swing.JFrame;
public class ConnectFourApp {
    public static void main(String[] args) {
        ConnectFourFrame c = new ConnectFourFrame();
        c.setTitle("Connect Four");
        c.setSize(950,700);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setVisible(true);
    }
}
