package tablero.celdas;

public class Celda 
{
    // variables de posicion inicial en tablero
    private int fil;
    private int col;

    public Celda(int fil, int col) 
    {
        this.fil = fil;
        this.col = col;
    }

    public int getFil() {
        return fil;
    }

    public int getCol() {
        return col;
    }

}
