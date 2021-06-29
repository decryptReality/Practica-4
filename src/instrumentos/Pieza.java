package instrumentos;

public class Pieza
{
    // letras con las que inicia la linea
    private String prefijo;
    // cantidad de parametros
    private int parametros;
    
    public Pieza(String prefijo, int parametros) {
        this.prefijo = prefijo;
        this.parametros = parametros;
    }

    public String getPrefijo() {
        return prefijo;
    }
    public int getParametros() {
        return parametros;
    }    
}
