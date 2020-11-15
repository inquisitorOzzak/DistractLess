package gui;

import javax.swing.*;

public class gui_pop_up_NewProfile {
    private JPanel panel1;
    private JTextField addNewProfileNameTextField;
    private JButton createNewProfileButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("gui_pop_up_NewProfile");
        frame.setContentPane(new gui_pop_up_NewProfile().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
