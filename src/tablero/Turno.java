package tablero;

import java.awt.*;
import esencial.Jugador;

public class Turno 
{
    Jugador jugador;
    Celda celda;
    // color de ficha
    Color color;
    boolean pierdeTurno;

    public Turno(Jugador jugador, Celda celda, Color cFicha) 
    {
        this.jugador = jugador;
        this.celda = celda;
        this.color = cFicha;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }

    public boolean getPierdeTurno() {
        return pierdeTurno;
    }

    public void setPierdeTurno(boolean pierdeTurno) {
        this.pierdeTurno = pierdeTurno;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Celda getCelda() {
        return celda;
    }

    public Color getColor() {
        return color;
    }    
}
