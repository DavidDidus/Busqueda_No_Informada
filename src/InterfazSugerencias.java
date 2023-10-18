import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa la ventana de sugerenciass
 */
public class InterfazSugerencias extends JFrame {
    private JLabel labelSugerencias;
    private JButton botonBuscar;
    private Color color;
    private Estado solucion;

    public InterfazSugerencias() {
        // Configuración del frame
        setTitle("Sugerencias de Inscripción"); // Establece el título de la ventana
        setSize(300, 200); // Establece el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define la acción al cerrar la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    
        // Creación de componentes
        labelSugerencias = new JLabel(); // Crea una etiqueta para mostrar las sugerencias
        labelSugerencias.setFont(new Font("Arial", Font.PLAIN, 14)); // Establece la fuente de la etiqueta
        botonBuscar = new JButton("Buscar Sugerencias"); // Crea un botón para iniciar la búsqueda de sugerencias
        botonBuscar.setBackground(color = new Color(153,170,181)); // Establece el color de fondo del botón
    
        // Configuración de layouts
        setLayout(new FlowLayout()); // Utiliza un diseño de flujo para organizar los componentes
    
        // Agregar componentes al frame
        add(botonBuscar); // Agrega el botón a la ventana
        add(labelSugerencias); // Agrega la etiqueta a la ventana
    
        // Configurar acciones de botones
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarSugerencias(); // Asigna la acción de buscar al botón
            }
        });
    }
    
    /**
     * Metodo que busca las asignaturas sugeridas a inscribir
     */
    private void buscarSugerencias() {
        Arbol arbol = new Arbol();
        Estado estadoInicial = new Estado(new ArrayList<>(), 0);
        solucion = arbol.buscarSolucion(estadoInicial);

        mostrarSugerencias(solucion.getAsignaturasInscritas());
    }

    /**
     * Muestra las sugerencias de asignaturas a inscribir
     * @param sugerencias lista con las asignaturas a inscribir
     */
   private void mostrarSugerencias(ArrayList<Asignatura> sugerencias) {
    if(sugerencias.isEmpty()) {
        labelSugerencias.setText("No hay sugerencias disponibles."); // Si no hay sugerencias, mostrar un mensaje indicando que no hay sugerencias
    }else{
        StringBuilder textoSugerencias = new StringBuilder("<html><body>"); // Inicia la construcción del texto en formato HTML
        textoSugerencias.append("Sugerencias de inscripción:<br><ul>"); // Encabezado para la lista de sugerencias

        for(Asignatura asignatura : sugerencias) {
            textoSugerencias.append("<li>").append(asignatura.getNombre()).append(" (").append(asignatura.getCredito()).append(" créditos)</li>"); // Agrega cada sugerencia como un elemento de lista
        }
        textoSugerencias.append("</ul>"); // Cierra la lista de sugerencias
        textoSugerencias.append("<center>").append(solucion.getCreditosTotales()).append(" creditos inscritos"); // Agrega el total de créditos inscritos
        textoSugerencias.append("</center></body></html>"); // Cierra el formato HTML

        labelSugerencias.setText(textoSugerencias.toString()); // Establece el texto en la etiqueta
    }
}

}
