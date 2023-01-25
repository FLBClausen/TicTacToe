import Strategies.WinningStrategy;

import javax.swing.*;

public class WinningStrategyPrint implements WinningStrategy {


    @Override
    public void winner(boolean xIsWinner, boolean circleIsWinner, JLabel background, ImageIcon X, ImageIcon circle) {
        if(xIsWinner){
            System.out.println("Winner is: X");
        }else{
            System.out.println("Winner is: Circle");
        }
    }

    @Override
    public void remove(JLabel background) {}
}
