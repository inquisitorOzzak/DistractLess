package gui;

import classes.Controller;
import classes.Profile;
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
    private JButton newProfileButton;
    private JButton deleteProfileButton;

    private JTextField textField1;
    private JTextArea textArea1;
    private JComboBox comboBox1;

    private Profile profile;
    private Controller controller;

    public DisLess_gui_v7() {

        // ============================================ //
        // ================= Buttons ================== //
        // ============================================ //

        profile = new Profile();
        controller = new Controller();

        // Open Network Button
        openNetworkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.clear();
            }
        });

        // Distractless Network Button
        distractLessNetworkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setProfile(profile);
            }
        });


        // Add Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                profile.addDomain(input);
                textArea1.setText(textArea1.getText() + input + "\n" );
                textField1.setText("");
                System.out.println(profile.getDomains());
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
                String name = JOptionPane.showInputDialog(new JFrame(), "Enter Profile Name");
                System.out.println(name);
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

        // ============================================ //
        // ============= Action Listener=============== //
        // ============================================ //


        // TODO -
        comboBox1.addActionListener(new ActionListener() {
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
