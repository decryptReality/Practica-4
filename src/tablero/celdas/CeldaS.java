package tablero.celdas;

import tablero.Celda;

// celda S-ubir
public class CeldaS extends Celda implements CeldaDes
{
    // celda destino
    private int filB; 
    private int colB;
    // celda des-tino
    private Celda des;

    public CeldaS(int fil, int col, int filB, int colB) 
    {
        super(fil, col);
        this.filB = filB;
        this.colB = colB;
        des = new Celda(filB, colB);
    }    
    
    @Override
    public Celda getDes() {
        return des;
    }

    public int getFilB() {
        return filB;
    }

    public int getColB() {
        return colB;
    }
}
