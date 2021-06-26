package tablero;

import java.util.ArrayList;

public class Tablero 
{
    // dimensiones del tablero
    int fils;
    int cols;
    ArrayList<Celda> celdas;

    void addCelda(Celda cel)
    {
        celdas.add(cel);
        celdas.trimToSize();
    }
}
