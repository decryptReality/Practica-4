package tablero;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;

import jcomponents.JButton1;
import jcomponents.JFrame1;

public class TableroGUI 
{
    Celda[][] celdas;
    JButton1[][] botones;
    ArrayList<Turno> alTurnos;

    public static void main(String[] args) 
    {
    }

    // estos parametros estan en el objeto tablero, cambiar a UN parametro tablero
    TableroGUI(int fils, int cols, ArrayList<Celda> alCeldas)
    {
        celdas = new Celda[fils][cols];
        botones = new JButton1[fils][cols];    

        for(int i = 0; i < fils; i = i + 1)
        {
            for(int j = 0; j < cols; j = j + 1)
            {
                celdas[i][j] = new Celda(i, j);
            }    
        }

        for(Celda celda : alCeldas)
        {
            int i = celda.getFil();
            int j = celda.getCol();
            celdas[i][j] = celda;
        }

    }

    void tableroUI(int fils, int cols)
    {
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
