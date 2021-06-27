package tablero;

import java.awt.*;
import esencial.Jugador;

public class Turno 
{
    Jugador jugador;
    Celda celda;
    // color de ficha
    Color color;
    boolean perdioTurno;
    boolean ganoTurno;

    public Turno(Jugador jugador, Celda celda, Color cFicha) 
    {
        this.jugador = jugador;
        this.celda = celda;
        this.color = cFicha;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Celda getCelda() {
        return celda;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean getPerdioTurno() {
        return perdioTurno;
    }

    public void setPerdioTurno(boolean perdioTurno) {
        this.perdioTurno = perdioTurno;
    }

    public boolean getGanoTurno() {
        return ganoTurno;
    }

    public void setGanoTurno(boolean ganoTurno) {
        this.ganoTurno = ganoTurno;
    }

}
