package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AdminLogin  extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1, b2;

    AdminLogin() {

        super("This is Admin Login page.");

        JLabel label = new JLabel("ADMIN LOGIN");
        label.setBounds(100, 20, 200, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 25));
        label.setForeground(Color.WHITE);
        add(label);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(40, 70, 100, 30);
        l1.setFont(new Font("Tahoma", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        add(l1);

        textField1 = new JTextField();
        textField1.setBounds(150, 70, 150, 30);
        textField1.setFont(new Font("Tahoma", Font.BOLD, 16));
        textField1.setForeground(Color.BLACK);
        textField1.setBackground(new Color(26, 104, 110));
        add(textField1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(40, 120, 100, 30);
        l2.setFont(new Font("Tahoma", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        add(l2);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150, 120, 150, 30);
        passwordField1.setFont(new Font("Tahoma", Font.BOLD, 16));
        passwordField1.setBackground(new Color(26, 104, 110));
        passwordField1.setForeground(Color.BLACK);
        add(passwordField1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image i2 = i1.getImage().getScaledInstance(255, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l = new JLabel(i3);
        l.setBounds(318, -30, 255, 300);
        add(l);

        b1 = new JButton("Login");
        b1.setBounds(40, 190, 120, 30);
//        b1.setFont(new Font("serif",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 190, 120, 30);
//        b2.setFont(new Font("serif",Font.BOLD,18));
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        add(b2);


        setLayout(null);
        getContentPane().setBackground(new Color(3, 45, 48));
        setSize(600, 300);
        setLocation(400, 270);
//    setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b2){
            setVisible(false);
            new DashBoard();
        }else{
            try{
                String username=textField1.getText();
                String password=passwordField1.getText();
                if(username.trim().isEmpty()||password.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null,"fill the details .");
                }
               else if(e.getSource()==b1) {
                    dataBaseConnection c = new dataBaseConnection();
                    ResultSet resultSet = c.statement.executeQuery("select * from login2 where username='" + username + "'and password='" + password + "' ");
                    if(resultSet.next()) {
                        setVisible(false);
                        new Admin();
                    }else{
                        JOptionPane.showMessageDialog(null,"Inavlid username and password.");
                    }
                }


                } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static  void main(String[] args){
        new AdminLogin();
    }
}

