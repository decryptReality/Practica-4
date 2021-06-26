package jcomponents;

import javax.swing.*;
import java.awt.*;

public class JPanel1 extends JPanel
{
    public JPanel1(int width, int height)
    {
        setPreferredSize(new Dimension(width, height));
    }
    public JPanel1(String title, int width, int height)
    {
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createTitledBorder(title));
    }
}
