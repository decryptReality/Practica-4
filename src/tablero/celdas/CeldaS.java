package tablero.celdas;

import tablero.Celda;

// celda S-ubir
public class CeldaS extends Celda
{
    // celda destino
    int filB; 
    int colB;

    public CeldaS(int fil, int col, int filB, int colB) 
    {
        super(fil, col);
        this.filB = filB;
        this.colB = colB;
    }    

    public int getFilB() {
        return filB;
    }

    public int getColB() {
        return colB;
    }
}
