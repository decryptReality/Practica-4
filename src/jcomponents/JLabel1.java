package jcomponents;

import javax.swing.*;
import java.awt.*;

class JLabel1 extends JLabel
{
    // position SwingConstants.(LEFT/CENTER/RIGHT)
    JLabel1(String text, int position, int width, int height)
    {
        super(text, position);
        setPreferredSize(new Dimension(width, height));
    }
}
