import Strategies.BackGroundStrategy;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BackGroundStrategyCool implements BackGroundStrategy {
    @Override
    public JLabel chooseBackground() {
        Image img = new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/Backgrounds/BlackBackground.jpg"))).getImage();
        Image temp = img.getScaledInstance(800,600,Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(temp);
        JLabel backGround = new JLabel(backgroundImage);
        //backGround.setBounds(0,0,500,600);
        return backGround;
    }

    @Override
    public JButton make1stButton() {
        JButton topLeftButton = new JButton();
        topLeftButton.setLocation(0,0);
        topLeftButton.setSize(262,197);
        topLeftButton.setActionCommand("1");
        return topLeftButton;
    }

    @Override
    public JButton make2ndButton() {
        JButton topMiddleButton = new JButton();
        topMiddleButton.setLocation(269,0);
        topMiddleButton.setSize(262,197);
        topMiddleButton.setActionCommand("2");
        return topMiddleButton;
    }

    @Override
    public JButton make3rdButton() {
        JButton topRightButton = new JButton();
        topRightButton.setLocation(538,0);
        topRightButton.setSize(262,197);
        topRightButton.setActionCommand("3");
        return topRightButton;
    }

    @Override
    public JButton make4thButton() {
        JButton middleLeftButton = new JButton();
        middleLeftButton.setLocation(0,201);
        middleLeftButton.setSize(262,197);
        middleLeftButton.setActionCommand("4");
        return middleLeftButton;
    }

    @Override
    public JButton make5thButton() {
        JButton middleMiddleButton = new JButton();
        middleMiddleButton.setLocation(269,201);
        middleMiddleButton.setSize(262,197);
        middleMiddleButton.setActionCommand("5");
        return middleMiddleButton;
    }

    @Override
    public JButton make6thButton() {
        JButton middleRightButton = new JButton();
        middleRightButton.setLocation(538,201);
        middleRightButton.setSize(262,197);
        middleRightButton.setActionCommand("6");
        return middleRightButton;
    }

    @Override
    public JButton make7thButton() {
        JButton bottomLeftButton = new JButton();
        bottomLeftButton.setLocation(0,403);
        bottomLeftButton.setSize(262,197);
        bottomLeftButton.setActionCommand("7");
        return bottomLeftButton;
    }

    @Override
    public JButton make8thButton() {
        JButton bottomMiddleButton = new JButton();
        bottomMiddleButton.setLocation(269,403);
        bottomMiddleButton.setSize(262,197);
        bottomMiddleButton.setActionCommand("8");
        return bottomMiddleButton;
    }

    @Override
    public JButton make9thButton() {
        JButton bottomRightButton = new JButton();
        bottomRightButton.setLocation(538,403);
        bottomRightButton.setSize(262,197);
        bottomRightButton.setActionCommand("9");
        return bottomRightButton;
    }

    @Override
    public void setLocationOn1st(JButton button) {
        button.setSize(262,197);
    }

    @Override
    public void setLocationOn2nd(JButton button) {
        button.setLocation(269,0);
        button.setSize(262,197);
    }

    @Override
    public void setLocationOn3rd(JButton button) {
        button.setLocation(538,0);
        button.setSize(262,197);
    }

    @Override
    public void setLocationOn4th(JButton button) {
        button.setLocation(0,201);
        button.setSize(262,197);
    }

    @Override
    public void setLocationOn5th(JButton button) {
        button.setLocation(269,201);
        button.setSize(262,197);
    }

    @Override
    public void setLocationOn6th(JButton button) {
        button.setLocation(538,201);
        button.setSize(262,197);
    }

    @Override
    public void setLocationOn7th(JButton button) {
        button.setLocation(0,403);
        button.setSize(262,197);
    }

    @Override
    public void setLocationOn8th(JButton button) {
        button.setLocation(269,403);
        button.setSize(262,197);
    }

    @Override
    public void setLocationOn9th(JButton button) {
        button.setLocation(538,403);
        button.setSize(262,197);
    }

    @Override
    public ImageIcon chooseX() {
        return new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/XandCircle-Cool/FireX-2.jpg")));
    }

    @Override
    public ImageIcon chooseCircle() {
        return new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/XandCircle-Cool/CoolCircle-2.jpg")));
    }
}
