package tablero;

import jcomponents.*;
import java.awt.*;
import javax.swing.*;

public class TableroGUI 
{
    public static void main(String[] args) {
        tableroUI(3, 5);
    }

    static void tableroUI(int fils, int cols)
    {
        JButton1[][] botones = new JButton1[fils][cols];
        JPanel pGrid = new JPanel();

        //JPanel1 pGrid = new JPanel1(300, 300);

        pGrid.setLayout(new GridLayout(fils,cols));

        for(int i = 0; i < fils; i = i + 1)
        {
            for(int j = 0; j < cols; j = j + 1)
            {
                botones[i][j] = new JButton1(i + "," + j, 70, 70);
                pGrid.add(botones[i][j]);
            }    
        }
        JDialog1 dGrid = new JDialog1("SERPIENTES Y ESCALERAS", (JDialog1)null, true);
        dGrid.add(pGrid);
        dGrid.sizeSettings(true, 500, 500);
        dGrid.locationSettings();
    }
}
