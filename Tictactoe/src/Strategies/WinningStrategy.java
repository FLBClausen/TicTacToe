package Strategies;

import javax.swing.*;

public interface WinningStrategy {
    void winner(boolean xIsWinner, boolean circleIsWinner, JLabel background, ImageIcon X, ImageIcon circle);

    void remove(JLabel background);
}
