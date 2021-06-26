package jcomponents;

import javax.swing.*;
import java.awt.*;

public class JTextArea1 extends JTextArea
{
    JTextArea1(boolean editable, int width, int height)
    {
        setPreferredSize(new Dimension(width,height));
        setEditable(editable);
        setBackground(new Color(238,238,238));
    }
}
