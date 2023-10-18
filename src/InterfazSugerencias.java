
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class InterfazSugerencias extends JFrame {
    private JLabel labelSugerencias;

    public InterfazSugerencias(ArrayList<Asignatura> sugerencias) {
        // Configuración del frame
        setTitle("Sugerencias de Inscripción");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creación de componentes
        labelSugerencias = new JLabel();
        labelSugerencias.setFont(new Font("Arial", Font.PLAIN, 14));

        // Configuración de layouts
        setLayout(new FlowLayout());

        // Agregar componente al frame
        add(labelSugerencias);

        // Mostrar las sugerencias
        mostrarSugerencias(sugerencias);
    }

    private void mostrarSugerencias(ArrayList<Asignatura> sugerencias) {
        if (sugerencias.isEmpty()) {
            labelSugerencias.setText("No hay sugerencias disponibles.");
        } else {
            StringBuilder textoSugerencias = new StringBuilder("<html><body>");
            textoSugerencias.append("Sugerencias de inscripción:<br><ul>");

            for (Asignatura asignatura : sugerencias) {
                textoSugerencias.append("<li>").append(asignatura.getNombre()).append(" (").append(asignatura.getCredito()).append(" créditos)</li>");
            }

            textoSugerencias.append("</ul></body></html>");
            labelSugerencias.setText(textoSugerencias.toString());
        }
    }
}

