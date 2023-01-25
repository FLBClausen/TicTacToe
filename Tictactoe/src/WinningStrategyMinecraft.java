import Strategies.WinningStrategy;

import javax.swing.*;

public class WinningStrategyMinecraft implements WinningStrategy {
    private JButton x;
    private JButton circle;
    private boolean xWon = false;
    private boolean circleWon = false;

    @Override
    public void winner(boolean xIsWinner, boolean circleIsWinner, JLabel background, ImageIcon X, ImageIcon Circle) {
        if(xIsWinner) {
            x = new JButton(X);
            x.setLocation(650, 260);
            x.setSize(108, 148);
            background.add(x);
            xWon = true;
        }else{
            circle = new JButton(Circle);
            circle.setLocation(650, 260);
            circle.setSize(108, 148);
            background.add(circle);
            circleWon = true;
        }
    }

    @Override
    public void remove(JLabel background) {
        if(xWon){
            background.remove(x);
        }else {
            background.remove(circle);
        }
    }

}
