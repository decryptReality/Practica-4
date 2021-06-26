package esencial;
public class Jugador 
{
    public Jugador(int id, String nombre, String apellido, int pJugadas, int pGanadas, int pPerdidas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pJugadas = pJugadas;
        this.pGanadas = pGanadas;
        this.pPerdidas = pPerdidas;
    }
    int id;
    String nombre;
    String apellido;
    // p-artidas
    int pJugadas;
    int pGanadas;
    int pPerdidas;
}
