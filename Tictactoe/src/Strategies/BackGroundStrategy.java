package Strategies;

import javax.swing.*;
import java.awt.*;

public interface BackGroundStrategy {
    JLabel chooseBackground();

    JButton make1stButton();

    JButton make2ndButton();

    JButton make3rdButton();

    JButton make4thButton();

    JButton make5thButton();

    JButton make6thButton();

    JButton make7thButton();

    JButton make8thButton();

    JButton make9thButton();

    void setLocationOn1st(JButton button);

    void setLocationOn2nd(JButton button);

    void setLocationOn3rd(JButton button);

    void setLocationOn4th(JButton button);

    void setLocationOn5th(JButton button);

    void setLocationOn6th(JButton button);

    void setLocationOn7th(JButton button);

    void setLocationOn8th(JButton button);

    void setLocationOn9th(JButton button);

    ImageIcon chooseX();

    ImageIcon chooseCircle();

}
