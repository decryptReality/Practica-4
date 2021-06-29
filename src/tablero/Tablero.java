package tablero;

import java.util.ArrayList;

public class Tablero 
{
    // dimensiones del tablero
    int fils;
    int cols;
    // celdas especiales
    ArrayList<Celda> celdas;

    public Tablero() 
    {
        fils = 5;
        cols = 4;
        celdas = new ArrayList<>();
    }

    public void setDimensiones(int fils, int cols)
    {
        this.fils = fils;
        this.cols = cols;
    }

    public void addCelda(Celda cel)
    {
        celdas.add(cel);
        celdas.trimToSize();
    }

    public void clearCeldas()
    {
        // para utilizar otro conjunto de celdas especiales
        celdas.clear();
    }

    public int getFils() {
        return fils;
    }

    public int getCols() {
        return cols;
    }

    public ArrayList<Celda> getCeldas() {
        return celdas;
    }    
}
