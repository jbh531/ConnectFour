package com.joshhorowitz.connectfour;

/*
Name: Joshua Horowitz
File: Connect Four Model
Purpose: To provide the methods to adjust the data-version of the connect Four board
Methods include: Placing a chip, checking for a win, setting the win text for the user, and resetting the board
 */

import javax.swing.JTextField;

public class ConnectFourModel {

    /**
     * When called, this method determines where to place a Red or Black chip.
     * Given c which is the column the player wants to drop a chip in, if it has
     * an empty space, it will place a chip data-wise, to be used in redrawing
     * the visual Connect Four chips later
     *
     * @param playerMoves - Determines if it is player Red or player Black's
     * turn
     * @param connectFourChips - The Connect Four board data-wise
     * @param r - Row number
     * @param c - Column number
     * @return connectFourChips to be used to redraw the Connect Four board
     */
    public int[][] placeChip(int playerMoves, int[][] connectFourChips, int r, int c) {
        // r = row, c = column
        for (c = 5; c > -1; c--) {
            if (connectFourChips[r][c] == 0) { // If the last space is empty, place the chip
                if (playerMoves % 2 != 0) { // If it is Red's turn 
                    connectFourChips[r][c] = 1; // place red chip
                } else { // Otherwise it is Black's turn
                    connectFourChips[r][c] = 2; // place black chip
                }
                break;
            }
        }

        return connectFourChips; // returns the array to be redrawn for the user later
    }

    /**
     * This method is called after a chip is placed to tell the user which
     * player has won or tied
     *
     * @param commentField
     * @param winVar - Used to tell the method what the result is, if any
     * @return commentField back to the game
     */
    public JTextField winloseText(JTextField commentField, int winVar) {
        if (winVar == 0) {
            commentField.setText("Tie");
        }
        if (winVar == 1) {
            commentField.setText("Red wins!");
        }
        if (winVar == 2) {
            commentField.setText("Black wins!");
        }
        return commentField;
    }

    /**
     * This method is called after a chip is placed to determine if a player has
     * won, tied, or the game continues
     *
     * @param playerMoves - Determines if it is player Red or player Black's
     * turn
     * @param connectFourChips - The Connect Four board data-wise
     * @return winVar - 0 for tie, 1 for red, 2 for black, 3 for game keeps
     * going
     */
    public int checkforWin(int playerMoves, int[][] connectFourChips) {
        if (playerMoves == 42) {
            return 0; // The board is full of chips, which neither Red nor Black got 4 in a row to win, so a tie
        }
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 6; c++) {
                if (r < 4 && c < 3) { // diagonal to upper right wins
                    if (connectFourChips[r][c] == 1 && connectFourChips[r + 1][c + 1] == 1 && connectFourChips[r + 2][c + 2] == 1 && connectFourChips[r + 3][c + 3] == 1) {
                        return 1;
                    }
                    if (connectFourChips[r][c] == 2 && connectFourChips[r + 1][c + 1] == 2 && connectFourChips[r + 2][c + 2] == 2 && connectFourChips[r + 3][c + 3] == 2) {
                        return 2;
                    }
                }
                if (r < 4 && c > 2) { // diagonal to lower right wins
                    if (connectFourChips[r][c] == 1 && connectFourChips[r + 1][c - 1] == 1 && connectFourChips[r + 2][c - 2] == 1 && connectFourChips[r + 3][c - 3] == 1) {
                        return 1;
                    }
                    if (connectFourChips[r][c] == 2 && connectFourChips[r + 1][c - 1] == 2 && connectFourChips[r + 2][c - 2] == 2 && connectFourChips[r + 3][c - 3] == 2) {
                        return 2;
                    }
                }
                if (r < 4) { // horizontal wins
                    if (connectFourChips[r][c] == 1 && connectFourChips[r + 1][c] == 1 && connectFourChips[r + 2][c] == 1 && connectFourChips[r + 3][c] == 1) {
                        return 1;
                    }
                    if (connectFourChips[r][c] == 2 && connectFourChips[r + 1][c] == 2 && connectFourChips[r + 2][c] == 2 && connectFourChips[r + 3][c] == 2) {
                        return 2;
                    }
                }
                if (c < 3) { // vertical wins
                    if (connectFourChips[r][c] == 1 && connectFourChips[r][c + 1] == 1 && connectFourChips[r][c + 2] == 1 && connectFourChips[r][c + 3] == 1) {
                        return 1;
                    }
                    if (connectFourChips[r][c] == 2 && connectFourChips[r][c + 1] == 2 && connectFourChips[r][c + 2] == 2 && connectFourChips[r][c + 3] == 2) {
                        return 2;
                    }
                }
            }
        }
        return 3; // Random number if no win, lose, or tie
    }

    /**
     * This method resets the array holding the connect four chips to zero, to
     * visually show an empty board in the model
     *
     * @param connectFourChips
     * @return connectFourChips array that has all zeros
     */
    public int[][] resetChips(int[][] connectFourChips) {
        for (int r = 0; r < 7; r++) {
            for (int c = 0; c < 6; c++) {
                connectFourChips[r][c] = 0;
            }
        }
        return connectFourChips;
    }
}
