import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        Estado estadoInicial = new Estado(new ArrayList<>(), 0);
        Estado solucion = arbol.buscarSolucion(estadoInicial);

        if (solucion != null) {
            InterfazSugerencias intefaz = new InterfazSugerencias(solucion.getAsignaturasInscritas());
            intefaz.setVisible(true);
        } else {
            System.out.println("No se encontró una solución.");
        }
    }
}
