package CurrencyConverterProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame {

    public static void main(String[] args) {
        // Create a JFrame for the login
        JFrame frame = new JFrame("Login");

        // Set the size of the frame
        frame.setSize(500, 350);

        // Set the background color to orange
        frame.getContentPane().setBackground(Color.ORANGE);

        // Set the layout to null for absolute positioning of components
        frame.setLayout(null);

        // Create the labels and text fields
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 100, 100, 30);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 100, 200, 30);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 100, 30);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 200, 30);

        // Create a login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(200, 200, 100, 30);

        // Add the components to the frame
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);

        // Create a listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the username and password input
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                // Check for valid credentials
                if (username.equals("Swetha") && String.valueOf(password).equals("Swetha")) {
                    // Show a success message
                    JOptionPane.showMessageDialog(frame, "Login Successful!");

                    // Close the login frame and open the CurrencyConverter frame
                    frame.dispose();
                    openCurrencyConverter();
                } else {
                    // Show an error message for invalid login
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set the default close operation and make the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Method to open the CurrencyConverter frame
    public static void openCurrencyConverter() {
        // Create and display the CurrencyConverter frame from the existing CurrencyConverter class
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverter().createUI();  // Create the CurrencyConverter UI
            }
        });
    }
}
