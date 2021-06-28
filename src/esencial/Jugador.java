package esencial;

import java.io.Serializable;

public class Jugador implements Serializable
{
    static final long serailVersionUID = 1L;
    int id;
    String nombre;
    String apellido;
    // partidas
    int jugadas;
    int ganadas;
    int perdidas;

    public Jugador(int id, String nombre, String apellido, int jugadas, int ganadas, int perdidas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.jugadas = jugadas;
        this.ganadas = ganadas;
        this.perdidas = perdidas;
    }
    
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public int getJugadas() {
        return jugadas;
    }
    public int getGanadas() {
        return ganadas;
    }
    public int getPerdidas() {
        return perdidas;
    }
    public void jugada() {
        jugadas = jugadas + 1;
    }
    public void ganada() {
        ganadas = ganadas + 1;
    }
    public void perdida() {
        perdidas = perdidas + 1;
    }

    @Override
    public String toString() 
    {
        return id + "-" + jugadas + "." + "." + ganadas + "." + perdidas + "-" + nombre + "." + apellido;
    }
}
