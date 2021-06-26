package jcomponents;

import javax.swing.*;
import java.awt.*;

public class JFrame1 extends JFrame
{
    public JFrame1(String title)
    {
        super(title);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void sizeSettings(boolean resize, int width, int height)
    {
        setSize(width, height);
        setResizable(resize);
    }

    public void locationSettings()
    {
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void locationSettings(int x, int y)
    {
        setLocation(x, y);
        setVisible(true);
    }

}
