package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisLess_gui_v7 {
    private JPanel panel1;
    private JButton openNetworkButton;
    private JButton distractLessNetworkButton;
    private JButton addButton;
    private JButton clearListButton;
    private JButton exitButton;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton newProfileButton;
    private JButton deleteProfileButton;
    private JComboBox comboBox1;


    public DisLess_gui_v7() {

        // ============================================ //
        // ================= Buttons ================== //
        // ============================================ //

        // Open Network Button
        // todo - turn off the app and restore normal firewall
        openNetworkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Distractless Network Button
        // todo - turn on the app firewall
        distractLessNetworkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        // Add Button
        // todo - sent the strings to the backend
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(textArea1.getText() + textField1.getText() + "\n" );
                textField1.setText("");
            }
        });

        // clearListButton DONE!
        clearListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
            }
        });

        // Exit Button DONE!
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // New Profile Button
        // todo -
        newProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Delete Profile Button
        // todo -
        deleteProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        // ============================================ //
        // =============== Text Fields ================ //
        // ============================================ //


        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DisLess_gui_v7");
        frame.setContentPane(new DisLess_gui_v7().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
