package tablero.celdas;

import tablero.Celda;

// celda R-etroceder
public class CeldaR extends Celda
{
    // celdas que retrocede
    int cels;
    // celda des-tino
    Celda des;

    public CeldaR(int fil, int col, int cels) 
    {
        super(fil, col);
        this.cels = cels;
        des = new Celda(fil, col - cels);
    }

    public Celda getDes() {
        return des;
    }

    public int getCels() {
        return cels;
    }
}
