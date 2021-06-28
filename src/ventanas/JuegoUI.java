package ventanas;

import jcomponents.JButton1;
import jcomponents.JDialog1;
import jcomponents.JFileChooser1;
import jcomponents.JFrame1;
import jcomponents.JTextArea1;
import java.awt.event.*;
import java.util.Vector;

import esencial.Jugador;

public class JuegoUI 
{
    static Vector<Jugador> vJugadores;
    static JFileChooser1 fc = new JFileChooser1();

    public static void main(String[] args) {
        menu1();
    }
    static void menu1()
    {
        JButton1 bJugar = new JButton1("JUGAR", 140, 25);
        JButton1 bJugador = new JButton1("JUGADORES", 140, 25);

        JFrame1 dMenu = new JFrame1("SERPIENTES Y ESCALERAS");

        dMenu.add(bJugar);
        dMenu.add(bJugador);
        bJugar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    menuJugadores();
                }
            }
        );
        bJugador.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    menuJugadores();
                }
            }
        );

        dMenu.sizeSettings(true, 340, 80);
        dMenu.locationSettings();
    } 

    static void menuJugadores()
    {
        JTextArea1 taIns = new JTextArea1(false, 280, 50);
        taIns.lineWrapSettings(true);
        String mensaje = "CARGUE O GUARDE A LOS JUGADORES CON ARCHIVOS DAT O LISTE A LOS JUGADORES EN EL JUEGO";
        taIns.append(mensaje);

        JButton1 bCargar = new JButton1("CARGAR", 140, 26);
        JButton1 bGuardar = new JButton1("GUARDAR", 140, 26);
        JButton1 bListar = new JButton1("LISTAR", 140, 26);
        bCargar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    archivoDAT();
                }
            }
        );
        bGuardar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    archivoTXT();
                }
            }
        );
        bListar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                }
            }
        );

        JDialog1 dMenu = new JDialog1("SERPIENTES Y ESCALERAS", (JDialog1) null, false);
        dMenu.add(taIns);
        dMenu.add(bCargar);
        dMenu.add(bGuardar);
        dMenu.add(bListar);

        dMenu.sizeSettings(true, 330, 170);
        dMenu.locationSettings();
    }

    static void archivoDAT()
    {
        fc.resetChoosableFileFilters();
        fc.getDirectory(null);
    }

    static void archivoTXT()
    {
        fc.resetChoosableFileFilters();
        fc.setFilter(".txt", new String[] {"txt"}, false);
        fc.getFile(null);
    }
}
