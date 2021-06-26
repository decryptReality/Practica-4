package tablero.celdas;

import tablero.Celda;

// celda B-ajar
public class CeldaB extends Celda
{
    // celda destino
    int filB; 
    int colB;

    public CeldaB(int fil, int col, int filB, int colB) 
    {
        super(fil, col);
        this.filB = filB;
        this.colB = colB;
    }    
    
}
