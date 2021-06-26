package jcomponents;

import javax.swing.*;
import java.awt.*;

public class JButton1 extends JButton
{
    public JButton1(String text, int width, int height)
    {
        super(text);
        setPreferredSize(new Dimension(width, height));
    }
}

