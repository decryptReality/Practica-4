package jcomponents;

import javax.swing.filechooser.FileFilter;
import java.io.File;

class FileFilter_1 extends FileFilter
{
    String[] extensions;
    String description;
    boolean hasDot;

    FileFilter_1(String description, String[] extensions, boolean hasDot)
    {
        this.extensions = extensions;
        this.description = description;
        this.hasDot = hasDot;
    }

    String extension(int index)
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
            int index = 0;
            while (index < extensions.length)
            {
                if (f.getName().endsWith(extension(index)))
                {
                    return true;
                }
                index = index + 1;
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
