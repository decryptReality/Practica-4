package jcomponents;

import javax.swing.*;
import java.awt.*;

public class JLabel1 extends JLabel
{
    // position SwingConstants.(LEFT/CENTER/RIGHT)
    public JLabel1(String text, int position, int width, int height)
    {
        super(text, position);
        setPreferredSize(new Dimension(width, height));
    }
}
