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
    public void backgroundSettings(int r, int g, int b)
    {
        setOpaque(true);
        setBackground(new Color(r, g, b));
    }
    public void backgroundSettings(Color bg)
    {
        setOpaque(true);
        setBackground(bg);
    }

}
