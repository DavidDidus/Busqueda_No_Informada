import java.util.ArrayList;

public class Arbol {
    private ArrayList<Asignatura> asignaturasDiponibles = new ArrayList<Asignatura>();

    Arbol(){
        asignaturasDiponibles.add(new Asignatura("A1", 2));
        asignaturasDiponibles.add(new Asignatura("A2", 3));
        asignaturasDiponibles.add(new Asignatura("A3", 4));
        asignaturasDiponibles.add(new Asignatura("A4", 2));
        asignaturasDiponibles.add(new Asignatura("A5", 1));
    }
    public Estado buscarSolucion(Estado estadoActual){
        if(estadoActual.getCreditosTotales()==8 || estadoActual.getAsignaturasInscritas().size() == 3){
            return estadoActual;
        }
        for(Asignatura asignatura : asignaturasDiponibles){
            if(!estadoActual.getAsignaturasInscritas().contains(asignatura) && estadoActual.getCreditosTotales()
                + asignatura.getCredito() <=8 ){

                ArrayList<Asignatura> nuevasInscripciones = new ArrayList<>(estadoActual.getAsignaturasInscritas());
                nuevasInscripciones.add(asignatura);
                
                Estado nuevoEstado = new Estado(nuevasInscripciones, estadoActual.getCreditosTotales() + asignatura.getCredito());
                Estado solucion = buscarSolucion(nuevoEstado);

                if(solucion != null){
                    return solucion;
                }
            }
        }
        return null;
    }
    
}
