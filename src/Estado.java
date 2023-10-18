import java.util.ArrayList;
/**
 * Clase que representa el estado de las asignaturas escritas
 */
public class Estado {
    private ArrayList<Asignatura> asignaturasInscritas;
    private int creditosTotales;

    /**
     * Constructor clase estado
     * @param asignaturasInscritas lista con las asignaturas inscritas
     * @param creditosTotales numero de creditos totales inscritos
     */
    public Estado(ArrayList<Asignatura> asignaturasInscritas, int creditosTotales){
        this.asignaturasInscritas=asignaturasInscritas;
        this.creditosTotales=creditosTotales;
    }
    public int getCreditosTotales() {
        return creditosTotales;
    }
    public void setCreditosTotales(int creditosTotales) {
        this.creditosTotales = creditosTotales;
    }
    public ArrayList<Asignatura> getAsignaturasInscritas() {
        return asignaturasInscritas;
    }
}
