package tablero;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import jcomponents.*;
import tablero.celdas.*;
import instrumentos.*;

public class TableroGUI 
{
    Celda[][] aCeldas;
    JButton1[][] aBotones;
    ArrayList<Turno> alTurnos;
    int fils;
    int cols;

    public static void main(String[] args) 
    {
    }

    void manejarTurno(Turno tur)
    {
        if(!tur.getPerdioTurno())
        {
            // cambiamos color de celda actual
            cambiarColor(tur.getCelda(), tur.getColor());
            // mostramos el resultado de los dados
            int cels1 = Extras.dado(1, 6);
            int cels2 = Extras.dado(1, 6);
            mensajeDados(cels1, cels2);
            // des-tino de ficha despues de tirar dados
            Celda des1 = destino1(cels1 + cels2, tur.getCelda());
            // despintamos la celda anterior y pintamos des1
            cambiarColor(tur.getCelda());
            cambiarColor(des1, tur.getColor());
            // des-tino-2 de ficha SI des1 mueve la ficha
            // aqui ajustamos nuevo valor en tur.setCelda(des2)
            Celda des2 = destino2(des1, tur);
            // despintamos des1 y pintamos des2
            cambiarColor(des1);
            cambiarColor(des2, tur.getColor());
            if(tur.getGanoTurno())
            {
                tur.setGanoTurno(false);
                manejarTurno(tur);
            }
        }
        else
        {
            tur.setPerdioTurno(false);
        }
        // dependiendo si !pierdeTurno hacer
        // se muestra tirar dados
        // devolver celda destino
        // mostrar destino 2, si hay
        // si condicion es repetir turno, volver a tirar dados
    }

    void mensajeDados(int cels1, int cels2)
    {
        JButton1 bDado1 = new JButton1("DADO-1", 100, 25);
        JButton1 bDado2 = new JButton1("DADO-2", 100, 25);
        JTextArea1 taResultado = new JTextArea1(false, 200, 40);
        taResultado.lineWrapSettings(true);

        bDado1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                bDado1.setEnabled(false);
                taResultado.append("Dado-1: " + cels1 + "\n");
            }
        }
        );
        bDado2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                bDado2.setEnabled(false);
                taResultado.append("Dado-2: " + cels2 + "\n");
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

    // cels: celdas a mover, ori: celda origen, desde donde se mueve la ficha
    Celda destino1(int cels, Celda ori)
    {
        // celda destino
        int filB = 0;
        int colB = 0;

        int num1 = ori.getFil() % 2 == 0 ? cols - 1 - ori.getCol() : ori.getCol();
        
        if(cels <= num1)
        {
            filB = ori.getFil();
            colB = ori.getFil() % 2 == 0 ? ori.getCol() + cels : ori.getCol() - cels;
        }
        if(cels > num1)
        {
            int num2 = cels - num1;
            int num3 = num2 / cols;
            int num4 = num2 % cols;
            filB = num4 == 0 ? ori.getFil() + num3 : ori.getFil() + num3 + 1;
            colB = filB % 2 == 0 ? num4 - 1 : cols - num4;
        }
        return new Celda(filB, colB);
    }

    Celda destino2(Celda celA, Turno tur)
    {
        mostrarMensaje("[?] LLEGO A " + celA.toString());
        String mensaje = "";
        Celda celB = aCeldas[celA.getFil()][celA.getCol()];
        if(celB instanceof CeldaA)
        {
            celB = ((CeldaA) celB).getDes();
            mensaje = "[?] AVANZARA A " + celB.toString();
        }
        if(celB instanceof CeldaB)
        {
            celB = ((CeldaB) celB).getDes();
            mensaje = "[?] BAJARA A " + celB.toString();
        }
        if(celB instanceof CeldaR)
        {
            celB = ((CeldaR) celB).getDes();
            mensaje = "[?] RETROCEDERA A " + celB.toString();
        }
        if(celB instanceof CeldaS)
        {
            celB = ((CeldaS) celB).getDes();
            mensaje = "[?] SUBIRA A " + celB.toString();
        }
        if(celB instanceof CeldaD)
        {
            celB = celA;
            tur.setGanoTurno(true);
            mensaje = "[!] GANO UN TURNO MAS";
        }
        if(celB instanceof CeldaP)
        {
            celB = celA;
            tur.setPerdioTurno(true);
            mensaje = "[!] PERDIO SU PROXIMO TURNO";
        }
        tur.setCelda(celB);
        mostrarMensaje(mensaje);
        return celB;
    }

    void mostrarMensaje(String text)
    {
        JTextArea1 taResultado = new JTextArea1(false, 200, 40);
        taResultado.lineWrapSettings(true);
        taResultado.append(text);

        JDialog1 dDado = new JDialog1("CELDA DESTINO", (JDialog1) null, false);
        dDado.add(taResultado);

        dDado.sizeSettings(true, 240, 120);
        dDado.locationSettings();
    }

    void cambiarColor(Celda cel, Color bg)
    {
        aBotones[cel.getFil()][cel.getCol()].setBackground(bg);
    }
    void cambiarColor(Celda cel)
    {
        aBotones[cel.getFil()][cel.getCol()].setBackground(new Color(238, 238, 238));
    }



    // hacer metodo presionar boton que se active y desactive segun el contexto
    // y que devuelva una celda
    

    // estos parametros estan en el objeto tablero, cambiar a UN parametro tablero
    TableroGUI(int fils, int cols, ArrayList<Celda> alCeldas)
    {
        this.fils = fils;
        this.cols = cols;
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

    void crearUI(int fils, int cols)
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
