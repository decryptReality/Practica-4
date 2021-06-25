package tablero.celdas;

// celda A-vanzar
public class CeldaA extends Celda
{
    // celdas que avanza
    int cel;

    public CeldaA(int fil, int col, int cel) 
    {
        super(fil, col);
        this.cel = cel;
    }
    
}
