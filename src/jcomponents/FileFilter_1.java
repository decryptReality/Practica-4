package jcomponents;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class FileFilter_1 extends FileFilter
{
    String[] extensions;
    String description;

    public FileFilter_1(String description, String[] extensions)
    {
        this.extensions = extensions;
        this.description = description;
    }

    @Override
    public boolean accept(File f)
    {
        if (f.isDirectory())
        {
            return true;
        }
        for (int i = 0; i < extensions.length; i = i + 1) 
        {
            if (f.getName().endsWith(extensions[i])) 
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription()
    {
        return description;
    }
}
