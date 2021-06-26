package jcomponents;

import java.awt.*;
import java.io.File;
import javax.swing.JFileChooser;

class JFileChooser1 extends JFileChooser
{
    File getDirectory(Component parent)
    {
        setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        setMultiSelectionEnabled(false);
        setDialogTitle("Select directory");
        int stateOnPopDown = showDialog(parent, "Select");
        if (stateOnPopDown == JFileChooser.APPROVE_OPTION)
        {
            return getSelectedFile();
        }
        return null;
    }

    File[] getDirectories(Component parent)
    {
        setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        setMultiSelectionEnabled(true);
        setDialogTitle("Select directories");
        int stateOnPopDown = showDialog(parent, "Select");
        if (stateOnPopDown == JFileChooser.APPROVE_OPTION)
        {
            return getSelectedFiles();
        }
        return null;
    }

    File getFile(Component parent)
    {
        setFileSelectionMode(JFileChooser.FILES_ONLY);
        setMultiSelectionEnabled(false);
        setDialogTitle("Select file");
        int stateOnPopDown = showDialog(parent, "Select");
        if (stateOnPopDown == JFileChooser.APPROVE_OPTION)
        {
            return getSelectedFile();
        }
        return null;
    }

    File[] getFiles(Component parent)
    {
        setFileSelectionMode(JFileChooser.FILES_ONLY);
        setMultiSelectionEnabled(true);
        setDialogTitle("Select files");
        int stateOnPopDown = showDialog(parent, "Select");
        if (stateOnPopDown == JFileChooser.APPROVE_OPTION)
        {
            return getSelectedFiles();
        }
        return null;
    }

    void setFilter(String description, String[] extensions, boolean hasDot)
    {
        setFileFilter(new FileFilter_1(description, extensions, hasDot));
    }
}
