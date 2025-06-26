import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField display;
    private StringBuilder currentInput = new StringBuilder();
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public CalculatorApp() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C" // Add reset button as 'C'
        };
        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            panel.add(btn);
        }
        add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("C")) {
            currentInput.setLength(0);
            display.setText("");
            firstNumber = 0;
            operator = "";
            startNewNumber = true;
            return;
        }
        if (cmd.matches("[0-9.]")) {
            if (startNewNumber) {
                currentInput.setLength(0);
                startNewNumber = false;
            }
            currentInput.append(cmd);
            display.setText(currentInput.toString());
        } else if (cmd.matches("[+\\-*/]")) {
            if (currentInput.length() > 0) {
                firstNumber = Double.parseDouble(currentInput.toString());
            }
            operator = cmd;
            startNewNumber = true;
        } else if (cmd.equals("=")) {
            if (operator.isEmpty() || currentInput.length() == 0) return;
            double secondNumber = Double.parseDouble(currentInput.toString());
            double result = 0;
            switch (operator) {
                case "+": result = firstNumber + secondNumber; break;
                case "-": result = firstNumber - secondNumber; break;
                case "*": result = firstNumber * secondNumber; break;
                case "/": result = secondNumber != 0 ? firstNumber / secondNumber : 0; break;
            }
            display.setText(Double.toString(result));
            currentInput = new StringBuilder(Double.toString(result));
            operator = "";
            startNewNumber = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorApp app = new CalculatorApp();
            app.setVisible(true);
        });
    }
}
