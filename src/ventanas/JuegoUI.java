package ventanas;

import jcomponents.*;
import tablero.*;
import tablero.celdas.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import esencial.Jugador;
import esencial.Turno;
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
        JButton1 bJugadores = new JButton1("JUGADORES", 140, 25);

        JFrame1 dMenu = new JFrame1("SERPIENTES Y ESCALERAS");

        dMenu.add(bJugar);
        dMenu.add(bJugadores);
        bJugar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    elegirJugadores();
                }
            }
        );
        bJugadores.addActionListener(
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
        JTextArea1 taIns = new JTextArea1(false, 280, 70);
        taIns.lineWrapSettings(true);
        String mensaje = "CARGUE O GUARDE A LOS JUGADORES CON ARCHIVOS DAT, AGREGUE UN JUGADOR, LIMPIE LA LISTA DE JUGADORES, LISTE A LOS JUGADORES";
        taIns.append(mensaje);

        JButton1 bCargar = new JButton1("CARGAR", 140, 26);
        JButton1 bGuardar = new JButton1("GUARDAR", 140, 26);
        JButton1 bAgregar = new JButton1("AGREGAR", 140, 26);
        JButton1 bLimpiar = new JButton1("LIMPIAR", 140, 26);
        JButton1 bListar = new JButton1("LISTAR", 140, 26);

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
        bAgregar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    agregarJugador();
                }
            }
        );
        bLimpiar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    vJugadores.clear();
                }
            }
        );

        bListar.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    listarJugadores();
                }
            }
        );

        JDialog1 dMenu = new JDialog1("JUGADORES", (JDialog1) null, false);
        dMenu.add(taIns);
        dMenu.add(bCargar);
        dMenu.add(bGuardar);
        dMenu.add(bAgregar);
        dMenu.add(bLimpiar);
        dMenu.add(bListar);

        dMenu.sizeSettings(true, 330, 220);
        dMenu.locationSettings();
    }

    static void listarJugadores()
    {
        JLabel1 label = new JLabel1("ID-JUGADAS.GANADAS.PERDIDAS-NOMBRE.APELLIDO", SwingConstants.CENTER, 340, 26);
        JList lista = new JList<>(vJugadores);
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane spLista = new JScrollPane(lista);
        spLista.setPreferredSize(new Dimension(340, 200));
        
        JDialog1 dialog = new JDialog1("LISTAR JUGADORES", (JDialog1) null, false);
        dialog.add(label);
        dialog.add(spLista);
        dialog.sizeSettings(true, 400, 310);
        dialog.locationSettings();
    }

    static void elegirJugadores()
    {
        JLabel1 label = new JLabel1("ID-JUGADAS.GANADAS.PERDIDAS-NOMBRE.APELLIDO", SwingConstants.CENTER, 340, 26);
        JList<Jugador> lista = new JList<>(vJugadores);
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane spLista = new JScrollPane(lista);
        spLista.setPreferredSize(new Dimension(340, 200));

        JButton1 bElegir = new JButton1("ELEGIR", 140, 26);

        bElegir.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    bElegir.setEnabled(false);
                    // limpiar turnos para agregar otro conjunto de turnos
                    alTurnos.clear();

                    // extraer jugadores seleccionados
                    List<Jugador> sels = lista.getSelectedValuesList();
                    
                    // jugadores seleccionados deben ser minimo 2 y maximo 6
                    if (2 <= sels.size() & sels.size() <= 6) 
                    {
                        // jugadores para partida
                        ArrayList<Jugador> part = new ArrayList<>();
                        part.addAll(sels);
                        part.trimToSize();
                        // agregar turnos para partida
                        for (Jugador jugador : part) 
                        {
                            alTurnos.add(new Turno(jugador, new Celda(0, 0), getColor()));
                            // verificar jugadores agregados
                            System.out.println(jugador.toString());
                        }
                        // ingrear configuracion de tablero
                        inputTXT();
                        iniciarPartida();
                    }
                }
            }
        );
        
        JDialog1 dialog = new JDialog1("ELEGIR JUGADORES", (JDialog1) null, false);
        dialog.add(label);
        dialog.add(spLista);
        dialog.add(bElegir);
        dialog.sizeSettings(true, 400, 310);
        dialog.locationSettings();
    }

    static int iColor = 0;
    static Color getColor()
    {
        iColor = iColor + 1;
        if(iColor == 1)
        {
            return new Color(0, 255, 255);
        }
        if(iColor == 2)
        {
            return new Color(0, 255, 0);
        }
        if(iColor == 3)
        {
            return new Color(255, 255, 0);
        }
        if(iColor == 4)
        {
            return new Color(255, 0, 0);
        }
        if(iColor == 5)
        {
            return new Color(0, 0, 255);
        }
        if(iColor == 6)
        {
            iColor = 0;
            return new Color(147, 147, 147);
        }
        return null;
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
                            try 
                            {
                                for (int i = 0; i < nums.length; i = i + 1) 
                                {
                                    // recortar espacios en extremos de cada parametro
                                    params[i] = params[i].trim();
                                    // convertir parametros de String a int
                                    nums[i] = Integer.parseInt(params[i]);
                                    // verificar contenido *** TEMPORAL ***
                                    System.out.println("    " + nums[i]);
                                }
                                tomarAcciones(pieza, nums);
                            } 
                            catch (Exception e) 
                            {
                                System.out.println("[!] Linea erronea");
                                // si alguin parametro no es de tipo int: evaluar otra linea
                                // continue;
                            }
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

    // turnos para partidas, en elegirJugadores() se limpia y llena de nueno
    static ArrayList<Turno> alTurnos = new ArrayList<>();
    static void iniciarPartida()
    {
        TableroGUI partida = new TableroGUI(tablero, alTurnos);
        partida.crearUI();
        partida.turnar();
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

    static void agregarJugador()
    {    
        JLabel1 lID = new JLabel1("ID", SwingConstants.LEFT, 70, 26);
        JTextField1 tfID = new JTextField1(180, 26);
        JLabel1 lNombre = new JLabel1("NOMBRE", SwingConstants.LEFT, 70, 26);
        JTextField1 tfNombre = new JTextField1(180, 26);
        JLabel1 lApellido = new JLabel1("APELLIDO", SwingConstants.LEFT, 70, 26);
        JTextField1 tfApellido = new JTextField1(180, 26);
        JButton1 bGuardar = new JButton1("GUARDAR", 140, 26);
        
        bGuardar.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                try 
                {
                    int id = Integer.parseInt(tfID.getText().trim());
                    String nombre = tfNombre.getText();
                    String apellido = tfApellido.getText();
                    vJugadores.add(new Jugador(id, nombre, apellido, 0, 0, 0));
                    //elegirJugadores();
                } 
                catch (Exception e) 
                {
                    System.out.println("[!] ID incorrecto");
                }
            }
        });

        JDialog1 dialog = new JDialog1("AGREGAR JUGADOR", (JDialog1) null, false);
        dialog.add(lID);
        dialog.add(tfID);
        dialog.add(lNombre);
        dialog.add(tfNombre);
        dialog.add(lApellido);
        dialog.add(tfApellido);
        dialog.add(bGuardar);

        dialog.sizeSettings(true, 310, 170);
        dialog.locationSettings();
    }
        
    static Pieza getPieza(String linea)
    {
        for(int i = 0; i < aPiezas.length; i = i + 1)
        {
            if(linea.startsWith(aPiezas[i].getPrefijo()) & linea.endsWith(")"))
            {
                return aPiezas[i];
            }
        }
        return null;
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

    static Pieza[] aPiezas = 
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
