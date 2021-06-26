package jcomponents;

import javax.swing.*;
import java.awt.*;

class JComboBox1<E> extends JComboBox<E>
{
    JComboBox1(E[] items, int width, int height)
    {
        super(items);
        setPreferredSize(new Dimension(width, height));
    }
}
