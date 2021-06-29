package tablero.celdas;

import tablero.Celda;

// celda R-etroceder
public class CeldaR extends Celda implements CeldaDes
{
    // celdas que retrocede
    int cels;
    // celda des-tino
    Celda des;

    public CeldaR(int fil, int col, int cels) 
    {
        super(fil, col);
        this.cels = cels;
        int num1 = fil % 2 == 0 ? col - cels : col + cels;
        des = new Celda(fil, num1);
    }

    @Override
    public Celda getDes() {
        return des;
    }

    public int getCels() {
        return cels;
    }
}
