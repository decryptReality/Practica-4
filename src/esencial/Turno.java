package esencial;

import java.awt.*;

import tablero.Celda;

public class Turno 
{
    private Jugador jugador;
    private Celda celda;
    // color de ficha
    private Color color;
    private boolean perdioTurno = false;
    private boolean ganoTurno = false;
    private boolean ganoPartida = false;

    public Turno(Jugador jugador, Celda celda, Color cFicha) 
    {
        this.jugador = jugador;
        this.celda = celda;
        this.color = cFicha;
    }

    public Jugador getJugador() {
        return jugador;
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

    public boolean getGanoPartida() {
        return ganoPartida;
    }

    public void setGanoPartida(boolean ganoPartida) {
        this.ganoPartida = ganoPartida;
    }

}
