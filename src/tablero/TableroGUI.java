package tablero;

import javax.swing.JButton;

import jcomponents.JButton1;

public class TableroGUI 
{    
    void tableroUI(int fils, int cols)
    {
        JButton1[][] botones = new JButton1[fils][cols];

        for(int i = 0; i < fils; i = i + 1)
        {
            for(int j = 0; j < cols; j = j + 1)
            {
                botones[i][j] = new JButton1("", 40, 40);
            }    
        }
    }
}
