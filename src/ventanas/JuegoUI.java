package ventanas;

import jcomponents.*;
import tablero.*;
import tablero.celdas.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import esencial.Jugador;
import instrumentos.Pieza;

public class JuegoUI 
{
    static Vector<Jugador> vJugadores = new Vector<>();
    static JFileChooser1 fc = new JFileChooser1();
    static Tablero tablero = new Tablero();

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
        fc.resetChoosableFileFilters();
        fc.setFilter(".txt", new String[] {"txt"});

        File txt = fc.getFile(null);
        if(txt != null)
        {
            try 
            {
                Scanner scanner = new Scanner(txt);
                while (scanner.hasNextLine()) 
                {
                    // acortar linea
                    String linea1 = scanner.nextLine().trim();
                    // verificar el su contenido **** TEMPORAL ****
                    System.out.println(linea1);

                    // verificamos si la linea empieza con algun prefijo y termina con ")"
                    Pieza pieza = getPieza(linea1);
                    if(pieza != null)
                    {
                        // extraer parametros de linea1
                        String linea2 = linea1.substring(pieza.getPrefijo().length(), linea1.length() - 1);
                        // seperar los parametros
                        String[] params = linea2.split(",");
                        // asegurar que cantidad de parametros en correcta
                        if(params.length == pieza.getParametros())
                        {
                            // array de tipo int para guardar parametros
                            int[] nums = new int[params.length];
                            for(int i = 0; i < aLineas.length; i = i + 1)
                            {
                                // recortar espacios en extremos de cada parametro
                                params[i] = params[i].trim();
                                try 
                                {
                                    // convertir parametros de String a int
                                    nums[i] = Integer.parseInt(params[i]);
                                    // verificar contenido *** TEMPORAL ***
                                    System.out.println("    " + nums[i]);
                                } 
                                catch (Exception e) 
                                {
                                    System.out.println("[!] Linea erronea");
                                    // si alguin parametro no es de tipo int: evaluar otra linea
                                    continue;
                                }
                            }
                            tomarAcciones(pieza, nums);
                        }
                    }
                }
            } 
            catch (Exception e) 
            {
                System.out.println("[!] Error leyendo archivo .txt");
            }
        }
    }

    static Pieza getPieza(String linea)
    {
        for(int i = 0; i < aLineas.length; i = i + 1)
        {
            if(linea.startsWith(aLineas[i].getPrefijo()) & linea.endsWith(")"))
            {
                return aLineas[i];
            }
        }
        return null;
    }

    static void elegirJugadores()
    {
        
    }

    static void iniciarPartida()
    {
        ArrayList<Turno> turnos = new ArrayList<>();

        TableroGUI partida = new TableroGUI(tablero, turnos);
    }

    static void tomarAcciones(Pieza pieza, int[] nums)
    {
        switch(pieza.getPrefijo())
        {
            case "tablero(":
                tablero.setDimensiones(nums[0], nums[1]);
                break;
            case "pierdeturno(":
                tablero.addCelda(new CeldaP(nums[0], nums[1]));
                break;
            case "tiradados(":
                tablero.addCelda(new CeldaD(nums[0], nums[1]));
                break;
            case "avanza(":
                tablero.addCelda(new CeldaA(nums[0], nums[1], nums[2]));
                break;
            case "retrocede(":
                tablero.addCelda(new CeldaR(nums[0], nums[1], nums[2]));
                break;
            case "subida(":
                tablero.addCelda(new CeldaS(nums[0], nums[1], nums[2], nums[3]));
                break;
            case "bajada(":
                tablero.addCelda(new CeldaB(nums[0], nums[1], nums[2], nums[3]));
                break;
        }
    }

    static Pieza[] aLineas = 
    {
        new Pieza("tablero(", 2), 
        new Pieza("pierdeturno(", 2), 
        new Pieza("tiradados(", 2), 
        new Pieza("avanza(", 3), 
        new Pieza("retrocede(", 3), 
        new Pieza("subida(", 4), 
        new Pieza("bajada(", 4), 
    };
}
