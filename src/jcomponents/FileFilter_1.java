package jcomponents;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class FileFilter_1 extends FileFilter
{
    String[] extensions;
    String description;
    boolean hasDot;

    public FileFilter_1(String description, String[] extensions, boolean hasDot)
    {
        this.extensions = extensions;
        this.description = description;
        this.hasDot = hasDot;
    }

    public String extension(int index)
    {
        if (hasDot)
        {
            return extensions[index];
        }
        else
        {
            return "." + extensions[index];
        }
    }

    @Override
    public boolean accept(File f)
    {
        if (f.isDirectory())
        {
            return true;
        }
        else
        {
            for(int i = 0; i < extensions.length; i = i + 1)
            {
                if (f.getName().endsWith(extension(i)))
                {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public String getDescription()
    {
        return description;
    }
}
