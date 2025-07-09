import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class VerificarNumeroPerfecto extends JFrame {
        private JTextField numeroPerfecto;
        private JButton comprobarSiEsPerfectoButton;
        private JLabel rta;

        public VerificarNumeroPerfecto(){
            setTitle("Verificar Numero Perfecto");
            setSize(400,200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(null);

            JLabel numeroperfecto = new JLabel("Ingrese el numero: ");
            numeroperfecto.setBounds(20, 20, 250, 25);
            add(numeroperfecto);

            numeroPerfecto = new JTextField();
            numeroPerfecto.setBounds(230, 20, 90, 25);
            add(numeroPerfecto);

            comprobarSiEsPerfectoButton = new JButton("Verificar");
            comprobarSiEsPerfectoButton.setBounds(100, 60, 120, 25);
            add(comprobarSiEsPerfectoButton);

            rta = new JLabel("");
            rta.setBounds(20, 100, 300, 25);
            add(rta);

            comprobarSiEsPerfectoButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int numero = Integer.parseInt(numeroPerfecto.getText());
                    int sumaDivisores = 0;
                    for (int i = 1 ; i < numero ; i++){
                        if (numero % i == 0) {
                            sumaDivisores += i;
                        }
                    }
                    if (sumaDivisores == numero){
                        rta.setText(numero + " SI es un numero perfecto.");
                    }
                        else {
                    rta.setText(numero + " NO es un numero perfecto");
                    }
                }
            });
        setVisible(true);
        }
        public static void main(String[] args) {
            new VerificarNumeroPerfecto();
        }
    }
