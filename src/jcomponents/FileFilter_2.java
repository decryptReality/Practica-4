package jcomponents;

import java.io.File;
import java.io.FileFilter;

public class FileFilter_2 implements FileFilter
{
    String[] extensions; 

    public FileFilter_2(String[] extensions) 
    {
        this.extensions = extensions;
    }

    @Override
    public boolean accept(File pathname) 
    {
        for(int i = 0; i < extensions.length; i = i + 1)
        {
            if(pathname.getName().endsWith(extensions[i]))
            {
                return true;
            }
        }
        return false;
    }

}
