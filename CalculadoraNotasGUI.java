import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraNotasGUI extends JFrame {

    private JTextField textFieldNota1, textFieldPorcentaje1,
                       textFieldNota2, textFieldPorcentaje2,
                       textFieldNotaFinal, textFieldPorcentajeFinal,
                       textFieldPromedio;
    private JButton calcularButton;

    public CalculadoraNotasGUI() {
        setTitle("Calculadora de Notas con Porcentaje");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2)); // Utilizamos 0 para que las filas se ajusten automáticamente

        JLabel labelNota1 = new JLabel("Nota 1:");
        textFieldNota1 = new JTextField();

        JLabel labelPorcentaje1 = new JLabel("Porcentaje 1:");
        textFieldPorcentaje1 = new JTextField();

        JLabel labelNota2 = new JLabel("Nota 2:");
        textFieldNota2 = new JTextField();

        JLabel labelPorcentaje2 = new JLabel("Porcentaje 2:");
        textFieldPorcentaje2 = new JTextField();

        JLabel labelNotaFinal = new JLabel("Nota Final:");
        textFieldNotaFinal = new JTextField();

        JLabel labelPorcentajeFinal = new JLabel("Porcentaje Final:");
        textFieldPorcentajeFinal = new JTextField();

        JLabel labelPromedio = new JLabel("Promedio Ponderado:");
        textFieldPromedio = new JTextField();
        textFieldPromedio.setEditable(false);

        calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPromedioPonderado();
            }
        });

        // Agregar componentes al frame en orden
        add(labelNota1);
        add(textFieldNota1);

        add(labelPorcentaje1);
        add(textFieldPorcentaje1);

        add(labelNota2);
        add(textFieldNota2);

        add(labelPorcentaje2);
        add(textFieldPorcentaje2);

        add(labelNotaFinal);
        add(textFieldNotaFinal);

        add(labelPorcentajeFinal);
        add(textFieldPorcentajeFinal);

        add(labelPromedio);
        add(textFieldPromedio);

        add(calcularButton);

        setVisible(true);
    }

    private void calcularPromedioPonderado() {
        double nota1 = Double.parseDouble(textFieldNota1.getText());
        double porcentaje1 = Double.parseDouble(textFieldPorcentaje1.getText());

        double nota2 = Double.parseDouble(textFieldNota2.getText());
        double porcentaje2 = Double.parseDouble(textFieldPorcentaje2.getText());

        double notaFinal = Double.parseDouble(textFieldNotaFinal.getText());
        double porcentajeFinal = Double.parseDouble(textFieldPorcentajeFinal.getText());

        double promedio = (nota1 * porcentaje1 + nota2 * porcentaje2 + notaFinal * porcentajeFinal) /
                          (porcentaje1 + porcentaje2 + porcentajeFinal);

        textFieldPromedio.setText(String.format("%.2f", promedio));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraNotasGUI());
    }
}
