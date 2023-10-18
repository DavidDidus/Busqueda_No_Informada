import java.util.ArrayList;

public class Estado {
    private ArrayList<Asignatura> asignaturasInscritas;
    private int creditosTotales;

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
