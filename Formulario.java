import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario {
    private JTextField textField1;
    private JButton validarButton;
    private JComboBox comboBox1;

    public Formulario() {
        validarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textField1;
                String genero = comboBox1.getSelectedItem().toString();


            }
        });
    }
}
