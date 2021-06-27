package tablero.celdas;

import tablero.Celda;

// celda A-vanzar
public class CeldaA extends Celda
{
    // celdas que avanza
    int cels;
    // celda des-tino
    Celda des;

    public CeldaA(int fil, int col, int cels) 
    {
        super(fil, col);
        this.cels = cels;
        des = new Celda(fil, col + cels);
    }
        
    public Celda getDes() {
        return des;
    }

    public int getCels() {
        return cels;
    }
}
