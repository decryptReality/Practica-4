package ventanas;

import jcomponents.FileFilter_2;
import jcomponents.JButton1;
import jcomponents.JDialog1;
import jcomponents.JFileChooser1;
import jcomponents.JFrame1;
import jcomponents.JTextArea1;
import tablero.Tablero;

import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Vector;

import esencial.Jugador;

public class JuegoUI 
{
    static Vector<Jugador> vJugadores = new Vector<>();
    static JFileChooser1 fc = new JFileChooser1();
    static Tablero tab;

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
        // crear opcion de limpiar los jugadores del programa, en: listar > limpiar
        bCargar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    inputDAT();
                }
            }
        );
        bGuardar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    outputDAT();
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

    static void outputDAT()
    {
        fc.resetChoosableFileFilters();
        File dir = fc.getDirectory(null);
        if(dir != null)
        {
            for (Jugador jugador : vJugadores) 
            {
                try 
                {
                    new ObjectOutputStream(new FileOutputStream(new File(dir, jugador.toString() + ".dat"))).writeObject(jugador);
                } 
                catch (Exception e) 
                {
                    System.out.println("[!] Error al guardar archivo .dat");
                } 
            }
        }
    }

    static void inputDAT()
    {
        fc.resetChoosableFileFilters();
        // directorio donde estan los dats
        File dir = fc.getDirectory(null);
        if(dir != null)
        {
            // dats dentro de dir
            File[] dats = dir.listFiles(new FileFilter_2(new String[] {".dat"}));
            // para cada dat de dats extraer un objeto jugador
            for(File dat : dats)
            {
                try 
                {
                    vJugadores.add((Jugador) new ObjectInputStream(new FileInputStream(dat)).readObject());
                } 
                catch (Exception e) 
                {
                    System.out.println("[!] Archivo .dat corrupto");
                }
            }
        }
    }

    static void inputTXT()
    {
        String[] info = {"tablero(", "pierdeturno(", "tiradados(", "avanza(", "retrocede(", "subida(", "bajada("};

        fc.resetChoosableFileFilters();
        fc.setFilter(".txt", new String[] {"txt"});

        File txt = fc.getFile(null);
        if(txt != null)
        {
            Scanner scanner;
            try 
            {
                scanner = new Scanner(txt);
                while (scanner.hasNextLine()) 
                {
                    // acortar cada linea
                    String linea1 = scanner.nextLine().trim();
                    // verificar el su contenido **** TEMPORAL ****
                    System.out.println(linea1);
                    
                }
            } 
            catch (Exception e) 
            {
                System.out.println("[!] Error leyendo archivo .txt");
            }
        }
    }
}
