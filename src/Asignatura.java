/**
 * Clase que representa una asignatura
 */
public class Asignatura {
    private String nombre;
    private int credito;
    /**
     * Constructor de la clase asignatura
     * @param nombre nombre de la asignatura
     * @param credito creditos que vale un asigntura
     */
    Asignatura(String nombre, int credito){
        this.nombre = nombre;
        this.credito = credito;
    }
    public void setCredito(int credito) {
        this.credito = credito;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCredito() {
        return credito;
    }
    public String getNombre() {
        return nombre;
    }
}
