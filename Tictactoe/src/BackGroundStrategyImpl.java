import Strategies.BackGroundStrategy;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BackGroundStrategyImpl implements BackGroundStrategy {
    @Override
    public JLabel chooseBackground() {
        Image img = new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/Backgrounds/Background.png"))).getImage();
        Image temp = img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(temp);
        JLabel backGround = new JLabel(backgroundImage);
        //backGround.setBounds(0,0,500,600);
        return backGround;
    }

    @Override
    public JButton make1stButton() {
        JButton topLeftButton = new JButton();
        topLeftButton.setSize(150,187);
        topLeftButton.setActionCommand("1");
        return topLeftButton;
    }

    @Override
    public JButton make2ndButton() {
        JButton topMiddleButton = new JButton();
        topMiddleButton.setSize(315,187);
        topMiddleButton.setActionCommand("2");
        return topMiddleButton;
    }

    @Override
    public JButton make3rdButton() {
        JButton topRightButton = new JButton();
        topRightButton.setSize(475,187);
        topRightButton.setActionCommand("3");
        return topRightButton;
    }

    @Override
    public JButton make4thButton() {
        JButton middleLeftButton = new JButton();
        middleLeftButton.setSize(150,372);
        middleLeftButton.setActionCommand("4");
        return middleLeftButton;
    }

    @Override
    public JButton make5thButton() {
        JButton middleMiddleButton = new JButton();
        middleMiddleButton.setSize(315,372);
        middleMiddleButton.setActionCommand("5");
        return middleMiddleButton;
    }

    @Override
    public JButton make6thButton() {
        JButton middleRightButton = new JButton();
        middleRightButton.setSize(475,372);
        middleRightButton.setActionCommand("6");
        return middleRightButton;
    }

    @Override
    public JButton make7thButton() {
        JButton bottomLeftButton = new JButton();
        bottomLeftButton.setSize(150,535);
        bottomLeftButton.setActionCommand("7");
        return bottomLeftButton;
    }

    @Override
    public JButton make8thButton() {
        JButton bottomMiddleButton = new JButton();
        bottomMiddleButton.setSize(315,535);
        bottomMiddleButton.setActionCommand("8");
        return bottomMiddleButton;
    }

    @Override
    public JButton make9thButton() {
        JButton bottomRightButton = new JButton();
        bottomRightButton.setSize(475,535);
        bottomRightButton.setActionCommand("9");
        return bottomRightButton;
    }

    @Override
    public void setLocationOn1st(JButton button) {
        button.setSize(150,187);
    }

    @Override
    public void setLocationOn2nd(JButton button) {
        button.setLocation(150,0);
        button.setSize(150,187);
    }

    @Override
    public void setLocationOn3rd(JButton button) {
        button.setLocation(315,0);
        button.setSize(150,187);
    }

    @Override
    public void setLocationOn4th(JButton button) {
        button.setLocation(0,180);
        button.setSize(150,187);
    }

    @Override
    public void setLocationOn5th(JButton button) {
        button.setLocation(150,180);
        button.setSize(150,187);
    }

    @Override
    public void setLocationOn6th(JButton button) {
        button.setLocation(315,180);
        button.setSize(150,187);
    }

    @Override
    public void setLocationOn7th(JButton button) {
        button.setLocation(0,345);
        button.setSize(150,187);
    }

    @Override
    public void setLocationOn8th(JButton button) {
        button.setLocation(150,345);
        button.setSize(150,187);
    }

    @Override
    public void setLocationOn9th(JButton button) {
        button.setLocation(315,345);
        button.setSize(150,187);
    }

    @Override
    public ImageIcon chooseX() {
        return new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/XandCircle-First/X.png")));
    }

    @Override
    public ImageIcon chooseCircle() {
        return new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/XandCircle-First/Circle.png")));
    }

}
