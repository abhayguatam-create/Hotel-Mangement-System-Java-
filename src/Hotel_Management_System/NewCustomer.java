package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {
    JComboBox combo;
    JTextField textNumber, textName, textCountry, textDeposit;
    JRadioButton Bmale, Bfemale;
    Choice c;
    JButton add, back;
    JLabel da;

    NewCustomer() {
        super("New Customer Registration");
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 150, 200, 200);
        panel.add(image);

        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(118, 11, 260, 53);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);
        panel.add(l1);

        // ID Label
        JLabel l2 = new JLabel("ID");
        l2.setBounds(35, 76, 200, 14);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setForeground(Color.WHITE);
        panel.add(l2);

        combo = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Voter Id", "Driving License"});
        combo.setBounds(271, 76, 150, 25);
        combo.setFont(new Font("Tahoma", Font.BOLD, 14));
        combo.setBackground(new Color(3, 45, 48));
        combo.setForeground(Color.WHITE);
        panel.add(combo);

        // Number Label
        JLabel l3 = new JLabel("NUMBER");
        l3.setBounds(35, 111, 200, 14);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setForeground(Color.WHITE);
        panel.add(l3);

        textNumber = new JTextField();
        textNumber.setBounds(271, 111, 150, 25);
        textNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        textNumber.setForeground(Color.BLACK);
        panel.add(textNumber);

        // Name Label
        JLabel l4 = new JLabel("NAME");
        l4.setBounds(35, 151, 200, 14);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setForeground(Color.WHITE);
        panel.add(l4);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 25);
        textName.setFont(new Font("Tahoma", Font.BOLD, 14));
        textName.setForeground(Color.BLACK);
        panel.add(textName);

        // Gender Label
        JLabel l5 = new JLabel("GENDER");
        l5.setBounds(35, 191, 200, 14);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setForeground(Color.WHITE);
        panel.add(l5);

        Bmale = new JRadioButton("MALE");
        Bmale.setBounds(271, 191, 100, 20);
        Bmale.setFont(new Font("Tahoma", Font.BOLD, 14));
        Bmale.setBackground(new Color(3, 45, 48));
        Bmale.setForeground(Color.WHITE);
        panel.add(Bmale);

        Bfemale = new JRadioButton("Female");
        Bfemale.setBounds(370, 191, 150, 20);
        Bfemale.setFont(new Font("Tahoma", Font.BOLD, 14));
        Bfemale.setBackground(new Color(3, 45, 48));
        Bfemale.setForeground(Color.WHITE);
        panel.add(Bfemale);

        ButtonGroup btng = new ButtonGroup();
        btng.add(Bmale);
        btng.add(Bfemale);
        Bmale.setSelected(true);

        // Country Label
        JLabel l6 = new JLabel("COUNTRY");
        l6.setBounds(35, 231, 200, 14);
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setForeground(Color.WHITE);
        panel.add(l6);

        textCountry = new JTextField();
        textCountry.setBounds(271, 231, 150, 25);
        textCountry.setFont(new Font("Tahoma", Font.BOLD, 14));
        textCountry.setForeground(Color.BLACK);
        panel.add(textCountry);

        // Allocated Room Label
        JLabel l7 = new JLabel("ALLOCATED ROOM NUMBER");
        l7.setBounds(35, 274, 230, 14);
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setForeground(Color.WHITE);
        panel.add(l7);

        try {
            c = new Choice();
            dataBaseConnection c1 = new dataBaseConnection();
            ResultSet resultSet = c1.statement.executeQuery("select * from addRoom where Availability='Available'"); // Checked spelling mismatch 🛠️
            while (resultSet.next()) {
                c.add(resultSet.getString("Room_No"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c.setBounds(271, 274, 150, 25);
        c.setFont(new Font("Tahoma", Font.BOLD, 14));
        c.setForeground(Color.WHITE);
        c.setBackground(new Color(3, 45, 48));
        panel.add(c);

        // Check In Label
        JLabel l8 = new JLabel("CHECKED IN");
        l8.setBounds(35, 316, 200, 14);
        l8.setFont(new Font("Tahoma", Font.BOLD, 14));
        l8.setForeground(Color.WHITE);
        panel.add(l8);

        Date date = new Date();
        da = new JLabel(" " + date);
        da.setBounds(271, 316, 250, 14);
        da.setFont(new Font("Tahoma", Font.BOLD, 14));
        da.setForeground(Color.white);
        panel.add(da);

        // Deposit Section
        JLabel l9 = new JLabel("DEPOSIT");
        l9.setBounds(35, 360, 200, 14);
        l9.setFont(new Font("Tahoma", Font.BOLD, 14));
        l9.setForeground(Color.WHITE);
        panel.add(l9);

        textDeposit = new JTextField();
        textDeposit.setBounds(271, 360, 150, 25);
        textDeposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        textDeposit.setForeground(Color.BLACK);
        panel.add(textDeposit);

        // Buttons
        add = new JButton("ADD");
        add.setBounds(100, 430, 120, 30);
        add.setFont(new Font("Tahoma", Font.BOLD, 14));
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("BACK");
        back.setBounds(260, 430, 120, 30);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        setSize(850, 550);
        setLocation(500, 150);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String ID = (String) combo.getSelectedItem();
            String number = textNumber.getText();
            String name = textName.getText();
            String gender = Bmale.isSelected() ? "MALE" : "FEMALE";
            String country = textCountry.getText();
            String roomno = (String) c.getSelectedItem();
            String date = da.getText();
            String deposit = textDeposit.getText();

            if (e.getSource() == back) {
                setVisible(false);
            }
            else if (e.getSource() == add) {

                if (number.trim().isEmpty() || name.trim().isEmpty() || country.trim().isEmpty() || deposit.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the Details");
                } else {
                    dataBaseConnection c2 = new dataBaseConnection();
                    String q = "insert into NewCustomer values('" + ID + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + roomno + "','" + date + "','" + deposit + "')";
                    c2.statement.executeUpdate(q);
                    String updateRoomQuery = "update addRoom set Availability = 'Occupied' where Room_No = '" + roomno + "'";
                    c2.statement.executeUpdate(updateRoomQuery);

                    JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                    setVisible(false);
                    dispose();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
