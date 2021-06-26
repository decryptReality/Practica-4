package tablero;

import java.awt.*;
import esencial.Jugador;

public class Turno 
{
    Jugador jugador;
    Celda celda;
    // c-olor
    Color cFicha;

    public Turno(Jugador jugador, Celda celda, Color cFicha) 
    {
        this.jugador = jugador;
        this.celda = celda;
        this.cFicha = cFicha;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Celda getCelda() {
        return celda;
    }

    public Color getcFicha() {
        return cFicha;
    }    
}
