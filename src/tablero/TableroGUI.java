package tablero;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import jcomponents.*;
import tablero.celdas.*;
import instrumentos.*;

public class TableroGUI 
{
    Celda[][] aCeldas;
    JButton1[][] aBotones;
    ArrayList<Turno> alTurnos;

    public static void main(String[] args) 
    {
        tirarDados();
    }

    void verificar(int fil, int col)
    {
        Celda cel = aCeldas[fil][col];
        if(cel instanceof CeldaA)
        {
            // avanzar a celda X
        }
        if(cel instanceof CeldaB)
        {
            // bajar a celda X
        }
        if(cel instanceof CeldaD)
        {
            // tirar dados
        }
        if(cel instanceof CeldaP)
        {
            // perder turno siguiente
        }
        if(cel instanceof CeldaR)
        {
            // retroceder a celda X
        }
        if(cel instanceof CeldaS)
        {
            // subir a celda X
        }
    }

    static void tirarDados()
    {
        JButton1 bDado1 = new JButton1("DADO-1", 100, 25);
        JButton1 bDado2 = new JButton1("DADO-2", 100, 25);
        JTextArea1 taResultado = new JTextArea1(false, 200, 40);
        taResultado.setBackground(new Color(50,150,150));
        taResultado.lineWrapSettings(true);

        bDado1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                bDado1.setEnabled(false);
                int cels = Extras.dado(6);
                taResultado.append("Dado-1: " + cels + "\n");

            }
        }
        );
        bDado2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                bDado2.setEnabled(false);
                int cels = Extras.dado(6);
                taResultado.append("Dado-2: " + cels + "\n");
            }
        }
        );
        JDialog1 dDado = new JDialog1("TIRAR DADOS", (JDialog1) null, false);
        dDado.add(bDado1);
        dDado.add(bDado2);
        dDado.add(taResultado);
        dDado.sizeSettings(true, 240, 120);
        dDado.locationSettings();
    }

    void mensajeTurno(Turno tur)
    {
        if(!tur.getPierdeTurno())
        {

        }
        else
        {
            tur.setPierdeTurno(false);
        }
        // dependiendo si !pierdeTurno hacer
        // se muestra tirar dados
        // devolver celda destino
        // mostrar concicion de celda, si tiene
        // si condicion es repetir turno, volver a tirar dados


    }

    void cambiarColor(int fil, int col, Color bg)
    {
        aBotones[fil][col].setBackground(bg);
    }

    // hacer metodo presionar boton que se active y desactive segun el contexto
    // y que devuelva una celda
    

    // estos parametros estan en el objeto tablero, cambiar a UN parametro tablero
    TableroGUI(int fils, int cols, ArrayList<Celda> alCeldas)
    {
        aCeldas = new Celda[fils][cols];
        aBotones = new JButton1[fils][cols];    

        // aqui llenamos el tablero de celdas
        for(int i = 0; i < fils; i = i + 1)
        {
            for(int j = 0; j < cols; j = j + 1)
            {
                aCeldas[i][j] = new Celda(i, j);
            }    
        }

        // aqui colocamos subtipos de la clase celda
        for(Celda celda : alCeldas)
        {
            int i = celda.getFil();
            int j = celda.getCol();
            aCeldas[i][j] = celda;
        }


    }

    void tableroUI(int fils, int cols)
    {
        JPanel pGrid = new JPanel();
        pGrid.setLayout(new GridLayout(fils, cols));
        //JPanel1 pGrid = new JPanel1(300, 300);

        for(int i = 0; i < fils; i = i + 1)
        {
            for(int j = 0; j < cols; j = j + 1)
            {
                aBotones[i][j] = new JButton1(i + "," + j, 30, 30);
                aBotones[i][j].setBackground(new Color(238,238,238));
                aBotones[i][j].setMargin(new Insets(1, 1, 1, 1));
                // botones[i][j].setBorderPainted(false);
                pGrid.add(aBotones[i][j]);
            }    
        }
        JFrame1 fGrid = new JFrame1("SERPIENTES Y ESCALERAS");
        fGrid.add(pGrid);
        fGrid.sizeSettings(true, 500, 500);
        fGrid.locationSettings();
    }
}
