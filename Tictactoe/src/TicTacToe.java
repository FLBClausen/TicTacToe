import Strategies.BackGroundStrategy;
import Strategies.GameFactory;
import Strategies.WinningStrategy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToe implements ActionListener {
    private boolean winnerFound = false;
    private boolean xTurn = true;
    private int xCounter = 0;
    private int circleCounter = 0;
    private int[][] grid = new int[3][3];

    private final JFrame frame;
    private final JPanel panel;
    private JPanel buttonPanel;
    private JLabel backGround;

    private JButton topLeftButton;
    private JButton topMiddleButton;
    private JButton topRightButton;
    private JButton middleLeftButton;
    private JButton middleMiddleButton;
    private JButton middleRightButton;
    private JButton bottomLeftButton;
    private JButton bottomMiddleButton;
    private JButton bottomRightButton;

    private final JButton resetButton;

    private GameFactory gameFactory;
    private BackGroundStrategy backGroundStrategy;
    private WinningStrategy winningStrategy;

    public static void main(String[] args) {
        // Change this for different games :)
        new TicTacToe(new GameFactoryMinecraft());
    }


    public TicTacToe(GameFactory gameFactory) {
        this.gameFactory = gameFactory;
        this.backGroundStrategy = gameFactory.backGroundStrategy();
        this.winningStrategy = gameFactory.winningStrategy();

        frame = new JFrame();
        panel = new JPanel();
        buttonPanel = new JPanel();


        // Background image
        backGround = backGroundStrategy.chooseBackground();

        // Buttons
        topLeftButton = backGroundStrategy.make1stButton();
        makeInvisible(topLeftButton);
        topLeftButton.addActionListener(this);

        topMiddleButton = backGroundStrategy.make2ndButton();
        makeInvisible(topMiddleButton);
        topMiddleButton.addActionListener(this);

        topRightButton = backGroundStrategy.make3rdButton();
        makeInvisible(topRightButton);
        topRightButton.addActionListener(this);

        middleLeftButton = backGroundStrategy.make4thButton();
        makeInvisible(middleLeftButton);
        middleLeftButton.addActionListener(this);

        middleMiddleButton = backGroundStrategy.make5thButton();
        makeInvisible(middleMiddleButton);
        middleMiddleButton.addActionListener(this);

        middleRightButton = backGroundStrategy.make6thButton();
        makeInvisible(middleRightButton);
        middleRightButton.addActionListener(this);

        bottomLeftButton = backGroundStrategy.make7thButton();
        makeInvisible(bottomLeftButton);
        bottomLeftButton.addActionListener(this);

        bottomMiddleButton = backGroundStrategy.make8thButton();
        makeInvisible(bottomMiddleButton);
        bottomMiddleButton.addActionListener(this);

        bottomRightButton = backGroundStrategy.make9thButton();
        makeInvisible(bottomRightButton);
        bottomRightButton.addActionListener(this);


        backGround.add(topLeftButton);
        backGround.add(topMiddleButton);
        backGround.add(topRightButton);
        backGround.add(middleLeftButton);
        backGround.add(middleMiddleButton);
        backGround.add(middleRightButton);
        backGround.add(bottomLeftButton);
        backGround.add(bottomMiddleButton);
        backGround.add(bottomRightButton);

        // Reset button
        resetButton = new JButton("Reset");
        resetButton.setActionCommand("reset");
        resetButton.addActionListener(this);

        // Button panel
        buttonPanel = new JPanel(new GridLayout(1,0,20,200));
        buttonPanel.setBorder( new EmptyBorder(575, 0, 0, 0) );
        buttonPanel.add(resetButton);

        // Panel
        panel.add(backGround);
        panel.add(buttonPanel);

        // Frame
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TicTacToe");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon X = backGroundStrategy.chooseX();
        ImageIcon circle = backGroundStrategy.chooseCircle();

        // Reset button functionality
        if (e.getActionCommand().equals("reset")){
            removeButton(topLeftButton, X, circle);
            removeButton(topMiddleButton, X, circle);
            removeButton(topRightButton, X, circle);
            removeButton(middleLeftButton, X, circle);
            removeButton(middleMiddleButton, X, circle);
            removeButton(middleRightButton, X, circle);
            removeButton(bottomLeftButton, X, circle);
            removeButton(bottomMiddleButton, X, circle);
            removeButton(bottomRightButton, X, circle);
            winningStrategy.remove(backGround);
            resetArray();
            winnerFound = false;
            xTurn = true;
            xCounter = 0;
            circleCounter = 0;
            frame.repaint();
        }

        // 3x3 buttons functionality
        if (e.getActionCommand().equals("1")){
            boolean nothingAtTopLeft = !XIsThere(topLeftButton, X) && !CircleIsThere(topLeftButton, circle);
            if (xTurn && nothingAtTopLeft && xCounter < 3 && !winnerFound){
                topLeftButton = new JButton(X);
                backGroundStrategy.setLocationOn1st(topLeftButton);
                makeInvisible(topLeftButton);
                backGround.add(topLeftButton);
                xTurn = false;
                xCounter++;
                grid[0][0] = 1;
            }else if(!xTurn && nothingAtTopLeft && circleCounter < 3 && !winnerFound){
                topLeftButton = new JButton(circle);
                backGroundStrategy.setLocationOn1st(topLeftButton);
                makeInvisible(topLeftButton);
                backGround.add(topLeftButton);
                xTurn = true;
                circleCounter++;
                grid[0][0] = 2;
            }else if(xTurn && XIsThere(topLeftButton, X) && xCounter == 3 && !winnerFound){
                removeButton(topLeftButton, X, circle);
                xCounter--;
                grid[0][0] = 0;
            }else if(!xTurn && CircleIsThere(topLeftButton,circle) && circleCounter == 3 && !winnerFound){
                removeButton(topLeftButton, X, circle);
                circleCounter--;
                grid[0][0] = 0;
            }

        }
        else if(e.getActionCommand().equals("2")){
            boolean nothingAtTopMiddle = !XIsThere(topMiddleButton, X) && !CircleIsThere(topMiddleButton, circle);
            if(xTurn && nothingAtTopMiddle && xCounter < 3 && !winnerFound){
                topMiddleButton = new JButton(X);
                backGroundStrategy.setLocationOn2nd(topMiddleButton);
                makeInvisible(topMiddleButton);
                backGround.add(topMiddleButton);
                xTurn = false;
                xCounter++;
                grid[0][1] = 1;
            }else if(!xTurn && nothingAtTopMiddle && circleCounter < 3 && !winnerFound){
                topMiddleButton = new JButton(circle);
                backGroundStrategy.setLocationOn2nd(topMiddleButton);
                makeInvisible(topMiddleButton);
                backGround.add(topMiddleButton);
                xTurn = true;
                circleCounter++;
                grid[0][1] = 2;
            }else if(xTurn && XIsThere(topMiddleButton, X) && xCounter == 3 && !winnerFound){
                removeButton(topMiddleButton, X, circle);
                xCounter--;
                grid[0][1] = 0;
            }else if(!xTurn && CircleIsThere(topMiddleButton, circle) && circleCounter == 3 && !winnerFound){
                removeButton(topMiddleButton, X, circle);
                circleCounter--;
                grid[0][1] = 0;
            }


        }
        else if(e.getActionCommand().equals("3")){
            boolean nothingAtTopRight = !XIsThere(topRightButton, X) && !CircleIsThere(topRightButton, circle);
            if(xTurn && nothingAtTopRight && xCounter < 3 && !winnerFound){
                topRightButton = new JButton(X);
                backGroundStrategy.setLocationOn3rd(topRightButton);
                makeInvisible(topRightButton);
                backGround.add(topRightButton);
                xTurn = false;
                xCounter++;
                grid[0][2] = 1;
            }else if(!xTurn && nothingAtTopRight && circleCounter < 3 && !winnerFound){
                topRightButton = new JButton(circle);
                backGroundStrategy.setLocationOn3rd(topRightButton);
                makeInvisible(topRightButton);
                backGround.add(topRightButton);
                xTurn = true;
                circleCounter++;
                grid[0][2] = 2;
            }else if(xTurn && XIsThere(topRightButton, X) && xCounter == 3 && !winnerFound){
                removeButton(topRightButton, X, circle);
                xCounter--;
                grid[0][2] = 0;
            }else if(!xTurn && CircleIsThere(topRightButton,circle) && circleCounter == 3 && !winnerFound){
                removeButton(topRightButton, X, circle);
                circleCounter--;
                grid[0][2] = 0;
            }
        }
        else if(e.getActionCommand().equals("4")){
            boolean nothingAtmiddleLeft = !XIsThere(middleLeftButton, X) && !CircleIsThere(middleLeftButton, circle);
            if(xTurn && nothingAtmiddleLeft && xCounter < 3 && !winnerFound){
                middleLeftButton = new JButton(X);
                backGroundStrategy.setLocationOn4th(middleLeftButton);
                makeInvisible(middleLeftButton);
                backGround.add(middleLeftButton);
                xTurn = false;
                xCounter++;
                grid[1][0] = 1;
            }else if(!xTurn && nothingAtmiddleLeft && circleCounter < 3 && !winnerFound){
                middleLeftButton = new JButton(circle);
                backGroundStrategy.setLocationOn4th(middleLeftButton);
                makeInvisible(middleLeftButton);
                backGround.add(middleLeftButton);
                xTurn = true;
                circleCounter++;
                grid[1][0] = 2;
            }else if(xTurn && XIsThere(middleLeftButton, X) && xCounter == 3 && !winnerFound){
                removeButton(middleLeftButton, X, circle);
                xCounter--;
                grid[1][0] = 0;
            }else if(!xTurn && CircleIsThere(middleLeftButton,circle) && circleCounter == 3 && !winnerFound){
                removeButton(middleLeftButton, X, circle);
                circleCounter--;
                grid[1][0] = 0;
            }

        }
        else if(e.getActionCommand().equals("5")){
            boolean nothingAtMiddleMiddle = !XIsThere(middleMiddleButton, X) && !CircleIsThere(middleMiddleButton, circle);
            if(xTurn && nothingAtMiddleMiddle && xCounter < 3 && !winnerFound){
                middleMiddleButton = new JButton(X);
                backGroundStrategy.setLocationOn5th(middleMiddleButton);
                makeInvisible(middleMiddleButton);
                backGround.add(middleMiddleButton);
                xTurn = false;
                xCounter++;
                grid[1][1] = 1;
            }else if(!xTurn && nothingAtMiddleMiddle && circleCounter < 3 && !winnerFound){
                middleMiddleButton = new JButton(circle);
                backGroundStrategy.setLocationOn5th(middleMiddleButton);
                makeInvisible(middleMiddleButton);
                backGround.add(middleMiddleButton);
                xTurn = true;
                circleCounter++;
                grid[1][1] = 2;
            }else if(xTurn && XIsThere(middleMiddleButton, X) && xCounter == 3 && !winnerFound){
                removeButton(middleMiddleButton, X, circle);
                xCounter--;
                grid[1][1] = 0;
            }else if(!xTurn && CircleIsThere(middleMiddleButton,circle) && circleCounter == 3 && !winnerFound){
                removeButton(middleMiddleButton, X, circle);
                circleCounter--;
                grid[1][1] = 0;
            }

        }
        else if(e.getActionCommand().equals("6")){
            boolean nothingAtMiddleRight = !XIsThere(middleRightButton, X) && !CircleIsThere(middleRightButton, circle);
            if(xTurn && nothingAtMiddleRight && xCounter < 3 && !winnerFound){
                middleRightButton = new JButton(X);
                backGroundStrategy.setLocationOn6th(middleRightButton);
                makeInvisible(middleRightButton);
                backGround.add(middleRightButton);
                xTurn = false;
                xCounter++;
                grid[1][2] = 1;
            }else if(!xTurn && nothingAtMiddleRight && circleCounter < 3 && !winnerFound){
                middleRightButton = new JButton(circle);
                backGroundStrategy.setLocationOn6th(middleRightButton);
                makeInvisible(middleRightButton);
                backGround.add(middleRightButton);
                xTurn = true;
                circleCounter++;
                grid[1][2] = 2;
            }else if(xTurn && XIsThere(middleRightButton, X) && xCounter == 3 && !winnerFound){
                removeButton(middleRightButton, X, circle);
                xCounter--;
                grid[1][2] = 0;
            }else if(!xTurn && CircleIsThere(middleRightButton,circle) && circleCounter == 3 && !winnerFound){
                removeButton(middleRightButton, X, circle);
                circleCounter--;
                grid[1][2] = 0;
            }

        }
        else if(e.getActionCommand().equals("7")){
            boolean nothingAtBottomLeft = !XIsThere(bottomLeftButton, X) && !CircleIsThere(bottomLeftButton, circle);
            if(xTurn && nothingAtBottomLeft && xCounter < 3 && !winnerFound){
                bottomLeftButton = new JButton(X);
                backGroundStrategy.setLocationOn7th(bottomLeftButton);
                makeInvisible(bottomLeftButton);
                backGround.add(bottomLeftButton);
                xTurn = false;
                xCounter++;
                grid[2][0] = 1;
            }else if(!xTurn && nothingAtBottomLeft && circleCounter < 3 && !winnerFound){
                bottomLeftButton = new JButton(circle);
                backGroundStrategy.setLocationOn7th(bottomLeftButton);
                makeInvisible(bottomLeftButton);
                backGround.add(bottomLeftButton);
                xTurn = true;
                circleCounter++;
                grid[2][0] = 2;
            }else if(xTurn && XIsThere(bottomLeftButton, X) && xCounter == 3 && !winnerFound){
                removeButton(bottomLeftButton, X, circle);
                xCounter--;
                grid[2][0] = 0;
            }else if(!xTurn && CircleIsThere(bottomLeftButton,circle) && circleCounter == 3 && !winnerFound){
                removeButton(bottomLeftButton, X, circle);
                circleCounter--;
                grid[2][0] = 0;
            }
        }
        else if(e.getActionCommand().equals("8")){
            boolean nothingAtBottomMiddle = !XIsThere(bottomMiddleButton, X) && !CircleIsThere(bottomMiddleButton, circle);
            if(xTurn && nothingAtBottomMiddle && xCounter < 3 && !winnerFound){
                bottomMiddleButton = new JButton(X);
                backGroundStrategy.setLocationOn8th(bottomMiddleButton);
                makeInvisible(bottomMiddleButton);
                backGround.add(bottomMiddleButton);
                xTurn = false;
                xCounter++;
                grid[2][1] = 1;
            }else if(!xTurn && nothingAtBottomMiddle && circleCounter < 3 && !winnerFound){
                bottomMiddleButton = new JButton(circle);
                backGroundStrategy.setLocationOn8th(bottomMiddleButton);
                makeInvisible(bottomMiddleButton);
                backGround.add(bottomMiddleButton);
                xTurn = true;
                circleCounter++;
                grid[2][1] = 2;
            }else if(xTurn && XIsThere(bottomMiddleButton, X) && xCounter == 3 && !winnerFound){
                removeButton(bottomMiddleButton, X, circle);
                xCounter--;
                grid[2][1] = 0;
            }else if(!xTurn && CircleIsThere(bottomMiddleButton,circle) && circleCounter == 3 && !winnerFound){
                removeButton(bottomMiddleButton, X, circle);
                circleCounter--;
                grid[2][1] = 0;
            }
        }
        else if(e.getActionCommand().equals("9")){
            boolean nothingAtBottomRight = !XIsThere(bottomRightButton, X) && !CircleIsThere(bottomRightButton, circle);
            if(xTurn && nothingAtBottomRight && xCounter < 3 && !winnerFound){
                bottomRightButton = new JButton(X);
                backGroundStrategy.setLocationOn9th(bottomRightButton);
                makeInvisible(bottomRightButton);
                backGround.add(bottomRightButton);
                xTurn = false;
                xCounter++;
                grid[2][2] = 1;
            }else if(!xTurn && nothingAtBottomRight && circleCounter < 3 && !winnerFound){
                bottomRightButton = new JButton(circle);
                backGroundStrategy.setLocationOn9th(bottomRightButton);
                makeInvisible(bottomRightButton);
                backGround.add(bottomRightButton);
                xTurn = true;
                circleCounter++;
                grid[2][2] = 2;
            }else if(xTurn && XIsThere(bottomRightButton, X) && xCounter == 3 && !winnerFound){
                removeButton(bottomRightButton, X, circle);
                xCounter--;
                grid[2][2] = 0;
            }else if(!xTurn && CircleIsThere(bottomRightButton,circle) && circleCounter == 3 && !winnerFound){
                removeButton(bottomRightButton, X, circle);
                circleCounter--;
                grid[2][2] = 0;
            }
        }
        if(!winnerFound) {
            if (checkIfXWinner() || checkIfCircleWinner()) {
                winnerFound = true;
                winningStrategy.winner(checkIfXWinner(), checkIfCircleWinner(),backGround, X, circle);

            }
        }
        frame.repaint();
    }

    private boolean checkIfCircleWinner() {
        if(grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && grid[0][2] == 2){
            return true;
        }else if(grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0] && grid[2][0] == 2){
            return true;
        }else if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[2][2] == 2){
            return true;
        }else if(grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1] && grid[2][1] == 2){
            return true;
        }else if(grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2] && grid[2][2] == 2){
            return true;
        }else if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[2][0] == 2){
            return true;
        }else if(grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && grid[1][2] == 2){
            return true;
        }else if(grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && grid[2][2] == 2){
            return true;
        }
        return false;
    }

    private void resetArray() {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                grid[i][j] = 0;
            }
        }
    }

    private boolean checkIfXWinner() {
        if(grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && grid[0][2] == 1){
            return true;
        }else if(grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0] && grid[2][0] == 1){
            return true;
        }else if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[2][2] == 1){
            return true;
        }else if(grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1] && grid[2][1] == 1){
            return true;
        }else if(grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2] && grid[2][2] == 1){
            return true;
        }else if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[2][0] == 1){
            return true;
        }else if(grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && grid[1][2] == 1){
            return true;
        }else if(grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && grid[2][2] == 1){
            return true;
        }
        return false;
    }

    private void makeInvisible(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }

    private void removeButton(JButton button, ImageIcon X, ImageIcon circle) {
        // One way of knowing if X or circle is there
        if (XIsThere(button,X) || CircleIsThere(button,circle)){
            button.setLocation(900,0);
            backGround.remove(button);
            button = null;
        }
    }

    private boolean XIsThere(JButton button, ImageIcon X){
        if(!(button.getIcon() == null)) {
            return button.getLocation().x < 700 && button.getIcon().toString().equals(X.toString());
        }
        return false;
    }
    private boolean CircleIsThere(JButton button, ImageIcon circle){
        if(!(button.getIcon() == null)) {
            return button.getLocation().x < 700 && button.getIcon().toString().equals(circle.toString());
        }
        return false;
    }
}
