import Strategies.BackGroundStrategy;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BackGroundStrategyMinecraft implements BackGroundStrategy {
    @Override
    public JLabel chooseBackground() {
        Image img = new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/Backgrounds/Minecraft.png"))).getImage();
        Image temp = img.getScaledInstance(800,600,Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(temp);
        JLabel backGround = new JLabel(backgroundImage);
        //backGround.setBounds(0,0,500,600);
        return backGround;
    }

    @Override
    public JButton make1stButton() {
        JButton topLeftButton = new JButton();
        topLeftButton.setLocation(20,105);
        topLeftButton.setSize(108,148);
        topLeftButton.setActionCommand("1");
        return topLeftButton;
    }

    @Override
    public JButton make2ndButton() {
        JButton topMiddleButton = new JButton();
        topMiddleButton.setLocation(140,105);
        topMiddleButton.setSize(108,148);
        topMiddleButton.setActionCommand("2");
        return topMiddleButton;
    }

    @Override
    public JButton make3rdButton() {
        JButton topRightButton = new JButton();
        topRightButton.setLocation(260,105);
        topRightButton.setSize(108,148);
        topRightButton.setActionCommand("3");
        return topRightButton;
    }

    @Override
    public JButton make4thButton() {
        JButton middleLeftButton = new JButton();
        middleLeftButton.setLocation(20,270);
        middleLeftButton.setSize(108,148);
        middleLeftButton.setActionCommand("4");
        return middleLeftButton;
    }

    @Override
    public JButton make5thButton() {
        JButton middleMiddleButton = new JButton();
        middleMiddleButton.setLocation(140,270);
        middleMiddleButton.setSize(108,148);
        middleMiddleButton.setActionCommand("5");
        return middleMiddleButton;
    }

    @Override
    public JButton make6thButton() {
        JButton middleRightButton = new JButton();
        middleRightButton.setLocation(260,270);
        middleRightButton.setSize(108,148);
        middleRightButton.setActionCommand("6");
        return middleRightButton;
    }

    @Override
    public JButton make7thButton() {
        JButton bottomLeftButton = new JButton();
        bottomLeftButton.setLocation(20,433);
        bottomLeftButton.setSize(108,148);
        bottomLeftButton.setActionCommand("7");
        return bottomLeftButton;
    }

    @Override
    public JButton make8thButton() {
        JButton bottomMiddleButton = new JButton();
        bottomMiddleButton.setLocation(140,433);
        bottomMiddleButton.setSize(108,148);
        bottomMiddleButton.setActionCommand("8");
        return bottomMiddleButton;
    }

    @Override
    public JButton make9thButton() {
        JButton bottomRightButton = new JButton();
        bottomRightButton.setLocation(260,433);
        bottomRightButton.setSize(108,148);
        bottomRightButton.setActionCommand("9");
        return bottomRightButton;
    }

    @Override
    public void setLocationOn1st(JButton button) {
        button.setLocation(20,105);
        button.setSize(108,148);
    }

    @Override
    public void setLocationOn2nd(JButton button) {
        button.setLocation(140,105);
        button.setSize(108,148);
    }

    @Override
    public void setLocationOn3rd(JButton button) {
        button.setLocation(260,105);
        button.setSize(108,148);
    }

    @Override
    public void setLocationOn4th(JButton button) {
        button.setLocation(20,270);
        button.setSize(108,148);
    }

    @Override
    public void setLocationOn5th(JButton button) {
        button.setLocation(140,270);
        button.setSize(108,148);
    }

    @Override
    public void setLocationOn6th(JButton button) {
        button.setLocation(260,270);
        button.setSize(108,148);
    }

    @Override
    public void setLocationOn7th(JButton button) {
        button.setLocation(20,433);
        button.setSize(108,148);
    }

    @Override
    public void setLocationOn8th(JButton button) {
        button.setLocation(140,433);
        button.setSize(108,148);
    }

    @Override
    public void setLocationOn9th(JButton button) {
        button.setLocation(260,433);
        button.setSize(108,148);
    }

    @Override
    public ImageIcon chooseX() {
        return new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/XandCircle-Minecraft/GraffitiX.png")));
    }

    @Override
    public ImageIcon chooseCircle() {
        return new ImageIcon(Objects.requireNonNull(getClass().getResource("Images/XandCircle-Minecraft/GraffitiCircle.png")));
    }

}
