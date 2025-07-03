import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


    public class VerificadorEdadFecha extends JFrame {
        private JTextField campoFecha;
        private JButton botonVerificar;
        private JLabel resultado;

        public VerificadorEdadFecha() {
            setTitle("Verificador de Edad");
            setSize(350, 180);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(null);

            JLabel etiqueta = new JLabel("Fecha de nacimiento (dd/MM/yyyy):");
            etiqueta.setBounds(20, 20, 250, 25);
            add(etiqueta);

            campoFecha = new JTextField();
            campoFecha.setBounds(230, 20, 90, 25);
            add(campoFecha);

            botonVerificar = new JButton("Verificar");
            botonVerificar.setBounds(100, 60, 120, 25);
            add(botonVerificar);

            resultado = new JLabel("");
            resultado.setBounds(20, 100, 300, 25);
            add(resultado);

            botonVerificar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String fechaTexto = campoFecha.getText();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    try {
                        LocalDate fechaNacimiento = LocalDate.parse(fechaTexto, formato);
                        LocalDate fechaActual = LocalDate.now();
                        int edad = Period.between(fechaNacimiento, fechaActual).getYears();

                        if (edad >= 18) {
                            resultado.setText("Tienes " + edad + " años. Eres mayor de edad.");
                        } else {
                            resultado.setText("Tienes " + edad + " años. Eres menor de edad.");
                        }
                    } catch (DateTimeParseException ex) {
                        resultado.setText("Formato inválido. Usa dd/MM/yyyy");
                    }
                }
            });

            setVisible(true);
        }

        public static void main(String[] args) {
            new VerificadorEdadFecha();
        }

    }

