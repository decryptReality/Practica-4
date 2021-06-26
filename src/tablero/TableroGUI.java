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
                botones[i][j] = new JButton1(i + "," + j, 30, 30);
                botones[i][j].setBackground(new Color(238,238,238));
                botones[i][j].setMargin(new Insets(1, 1, 1, 1));
                // botones[i][j].setBorderPainted(false);
                pGrid.add(botones[i][j]);
            }    
        }
        JFrame1 fGrid = new JFrame1("SERPIENTES Y ESCALERAS");
        fGrid.add(pGrid);
        fGrid.sizeSettings(true, 500, 500);
        fGrid.locationSettings();
    }
}
