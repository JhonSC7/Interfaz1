import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidadorPension {


    public class ValidadorPension extends JFrame {
        private JTextField campoEdad;
        private JComboBox<String> comboGenero;
        private JButton botonValidar;
        private JLabel etiquetaResultado;

        public ValidadorPension() {
            setTitle("Validador de Pensión");
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Centrar ventana

            // Crear componentes
            JLabel etiquetaEdad = new JLabel("Edad:");
            campoEdad = new JTextField(5);

            JLabel etiquetaGenero = new JLabel("Género:");
            comboGenero = new JComboBox<>(new String[]{"Hombre", "Mujer"});

            botonValidar = new JButton("Validar pensión");
            etiquetaResultado = new JLabel("");

            // Acción al hacer clic en el botón
            botonValidar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    validarPension();
                }
            });

            // Crear panel y agregar componentes
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            panel.add(etiquetaEdad);
            panel.add(campoEdad);

            panel.add(etiquetaGenero);
            panel.add(comboGenero);

            panel.add(new JLabel()); // espacio vacío
            panel.add(botonValidar);

            panel.add(new JLabel("Resultado:"));
            panel.add(etiquetaResultado);

            add(panel);
            setVisible(true);
        }

        private void validarPension() {
            try {
                int edad = Integer.parseInt(campoEdad.getText());
                String genero = (String) comboGenero.getSelectedItem();

                boolean puedePensionarse = false;

                if (genero.equals("Hombre") && edad >= 62) {
                    puedePensionarse = true;
                } else if (genero.equals("Mujer") && edad >= 57) {
                    puedePensionarse = true;
                }

                if (puedePensionarse) {
                    etiquetaResultado.setText("¡Ya puede pensionarse!");
                } else {
                    etiquetaResultado.setText("Aún no cumple la edad.");
                }

            } catch (NumberFormatException ex) {
                etiquetaResultado.setText("Edad inválida. Ingrese un número.");
            }
        }

        public static void main(String[] args) {
            new ValidadorPension();
        }
    }

}
