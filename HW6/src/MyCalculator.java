import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// This class defines a basic calculator GUI using Java event listners, swing and awt.
public class MyCalculator extends JFrame {
    private JTextField inputField;
    private double result;
    private String operator;
    private boolean startOfNumber;

    public MyCalculator() {
        createUI();
    }

    // Generated the interface if the GUI including the buttons and fields.
    private void createUI() {
        setTitle("HW 6 Calculator GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputField = new JTextField("0");
        inputField.setEditable(false);
        inputField.setHorizontalAlignment(JTextField.RIGHT);
        add(inputField, BorderLayout.NORTH);

        operator = "=";
        result = 0;
        startOfNumber = true;

        // Define a jpanel which is similar to a lightweight container.
        JPanel panel = new JPanel();

        // Establish buttons in grid pattern.
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // Button labels for grid in the form of a dyanmically allocated array of strings.
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        // Map buttons to grid and apply event listeners for buttons.
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        pack();
    }

    // Defines a button event listener for the GUI that tracks what button is clicked and implements the associated action.
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Set the event listener.
            String command = e.getActionCommand();

            if ('0' <= command.charAt(0) && command.charAt(0) <= '9' || command.equals(".")) {
                if (startOfNumber) {
                    inputField.setText(command);
                } else {
                    inputField.setText(inputField.getText() + command);
                }
                startOfNumber = false;
            } else {
                // Defines a special case for "-" to allow negative numbers
                if (startOfNumber) {
                    if (command.equals("-")) {
                        inputField.setText(command);
                        startOfNumber = false;
                    } else {
                        operator = command;
                    }
                } else {
                    // Perform calculation based on the previous operator
                    double x = Double.parseDouble(inputField.getText());
                    calculate(x);
                    operator = command;
                    startOfNumber = true;
                }
            }
        }

        // Function to perform the calculation based on the operator.
        private void calculate(double n) {
            switch (operator) {
                case "+":
                    result += n;
                    break;
                case "-":
                    result -= n;
                    break;
                case "*":
                    result *= n;
                    break;
                case "/":
                    result /= n;
                    break;
                case "=":
                    result = n;
                    break;
            }
            inputField.setText("" + result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            // Call a new instance of calculator.
            MyCalculator calculator = new MyCalculator();
            calculator.setVisible(true);
        });
    }
}
