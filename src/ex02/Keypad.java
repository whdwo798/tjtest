package ex02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Keypad extends JFrame implements ActionListener {
    private JTextField txt;
    private JPanel panel;

    private String currentText ;

    public Keypad(){
        txt = new JTextField(20);
        add(txt, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));
        add(panel,BorderLayout.CENTER);
        String[] button_names = { "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "C", "0", "=", "/"};
        JButton btn[] = new JButton[button_names.length];
        for (int i = 0; i<button_names.length; i++){
            btn[i] = new JButton(button_names[i]);
            btn[i].addActionListener(this);
            btn[i].setPreferredSize(new Dimension(100,100));
            panel.add(btn[i]);
            }
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand) {
            case "+":
                currentText = txt.getText().trim();
                if (!currentText.isEmpty()) {
                    txt.setText(currentText + "+");
                }
                break;
            case "-":
                currentText = txt.getText().trim();
                if (!currentText.isEmpty()) {
                    txt.setText(currentText + "-");
                }
                break;
            case "/" :
                currentText = txt.getText().trim();
                if (!currentText.isEmpty()) {
                    txt.setText(currentText + "/");
                }
                break;
            case "*" :
                currentText = txt.getText().trim();
                if (!currentText.isEmpty()) {
                    txt.setText(currentText + "*");
                }
                break;
            case "=":
                String expression = txt.getText().trim();
                String[] terms = expression.split("(?<=[-+*/])|(?=[-+*/])");
                double result = Double.parseDouble(terms[0]);
                String operator = "";

                for (int i = 1; i < terms.length; i += 2) {
                    operator = terms[i];
                    double operand = Double.parseDouble(terms[i + 1]);

                    switch (operator) {
                        case "+":
                            result += operand;
                            break;
                        case "-":
                            result -= operand;
                            break;
                        case "*":
                            result *= operand;
                            break;
                        case "/":
                            if (operand != 0) {
                                result /= operand;
                            }
                            break;
                    }
                }

                txt.setText(Double.toString(result));
                break;
            case "C":
                txt.setText("");
                break;
            default:
                txt.setText(txt.getText() + actionCommand);
                break;
        }
    }

    public static void main(String[] args) {
        new Keypad();
    }
}


