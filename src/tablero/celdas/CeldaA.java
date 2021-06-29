package tablero.celdas;

import tablero.Celda;

// celda A-vanzar
public class CeldaA extends Celda implements CeldaDes
{
    // celdas que avanza
    private int cels;
    // celda des-tino
    private Celda des;

    public CeldaA(int fil, int col, int cels) 
    {
        super(fil, col);
        this.cels = cels;
        int num1 = fil % 2 == 0 ? col + cels : col - cels;
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
