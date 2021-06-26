package jcomponents;

import javax.swing.*;
import java.awt.*;

public class JComboBox1<E> extends JComboBox<E>
{
    public JComboBox1(E[] items, int width, int height)
    {
        super(items);
        setPreferredSize(new Dimension(width, height));
    }
}
