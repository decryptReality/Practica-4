package jcomponents;

import javax.swing.*;
import java.awt.*;

public class JDialog1 extends JDialog
{
    // the add, remove, and setLayout methods delegate calls of the ContentPane
    // getContentPane().add(component); = add(component);
    // the default contentPane has a BorderLayout manager set on it

    // owner - the Frame/Dialog from which the dialog is displayed
    // null if this dialog has no owner
    public JDialog1(String title, Frame owner, boolean modal)
    {
        super(owner, title, modal);
        setLayout(new FlowLayout());
    }
    public JDialog1(String title, Dialog owner, boolean modal)
    {
        super(owner, title, modal);
        setLayout(new FlowLayout());
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
