package tablero.celdas;

import tablero.Celda;

// celda R-etroceder
public class CeldaR extends Celda
{
    // celdas que retrocede
    int cel;

    public CeldaR(int fil, int col, int cel) 
    {
        super(fil, col);
        this.cel = cel;
    }

}
