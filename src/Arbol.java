import java.util.ArrayList;

/**
 * Clase que representa el arbol 
 */
public class Arbol {
    private ArrayList<Asignatura> asignaturasDiponibles = new ArrayList<Asignatura>();

    Arbol(){
        asignaturasDiponibles.add(new Asignatura("A1", 2));
        asignaturasDiponibles.add(new Asignatura("A2", 3));
        asignaturasDiponibles.add(new Asignatura("A3", 4));
        asignaturasDiponibles.add(new Asignatura("A4", 2));
        asignaturasDiponibles.add(new Asignatura("A5", 1));
    }
    /**
     * Busca las asignaturas a inscribir segun la busqueda en profundidad
     * @param estadoActual estado en el que se encuentra
     * @return el estado que tiene 3 ramos y 8 o menos creditos asignados
     */
    public Estado buscarSolucion(Estado estadoActual) {
        // Verificar si se alcanzó la condición de parada
        if(estadoActual.getCreditosTotales() == 8 || estadoActual.getAsignaturasInscritas().size() == 3) {
            return estadoActual; // Si se cumple, devolver este estado como solución
        }
    
        // Explorar las posibles asignaturas a inscribir
        for(Asignatura asignatura : asignaturasDiponibles) {
            // Verificar si la asignatura no está ya inscrita y si se puede inscribir sin superar los 8 créditos
            if(!estadoActual.getAsignaturasInscritas().contains(asignatura) && 
                estadoActual.getCreditosTotales() + asignatura.getCredito() <= 8) {
    
                // Crear una nueva lista de inscripciones que incluye la nueva asignatura
                ArrayList<Asignatura> nuevasInscripciones = new ArrayList<>(estadoActual.getAsignaturasInscritas());
                nuevasInscripciones.add(asignatura);
    
                // Crear un nuevo estado con las nuevas inscripciones y créditos actualizados
                Estado nuevoEstado = new Estado(nuevasInscripciones, estadoActual.getCreditosTotales() + asignatura.getCredito());
    
                // Llamar recursivamente a buscarSolucion con el nuevo estado
                Estado solucion = buscarSolucion(nuevoEstado);
    
                // Si se encuentra una solución, devolverla
                if(solucion != null) {
                    return solucion;
                }
            }
        }
    
        // Si no se encuentra solución en este estado, devolver null
        return null;
    }
    
    
}
