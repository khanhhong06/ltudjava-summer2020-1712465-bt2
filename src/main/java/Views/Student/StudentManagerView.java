package Views.Student;

import Model.Entities.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagerView extends JFrame {
    private JPanel panel1;
    private JButton checkMarkButton;
    private JButton complainButton;
    private JButton changePasswordButton;
    private JButton logoutButton;
    private JLabel label;
    private Account account;

    public StudentManagerView(Account account) {
        this.account = account;

        this.setTitle("Sinh viên");
        panel1.setBorder(BorderFactory.createLineBorder(Color.blue));
        //panel1.setLayout(new BorderLayout(1, 1));
        panel1.setPreferredSize(new Dimension(400, 300));
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        label.setText(label.getText() + " " + account.getUsername());
    }

    public void logoutListener(ActionListener actionListener){
        logoutButton.addActionListener(actionListener);
    }

    public void changePasswordListener(ActionListener actionListener){
        changePasswordButton.addActionListener(actionListener);
    }

    public void checkMarkListener(ActionListener actionListener){
        checkMarkButton.addActionListener(actionListener);
    }

    public void complainListener(ActionListener actionListener){
        complainButton.addActionListener(actionListener);
    }

    public String getMSSV(){
        return account.getUsername();
    }
}
