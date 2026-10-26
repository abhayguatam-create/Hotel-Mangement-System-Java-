package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
    AddRooms(){
        super("Add Hotel Page.");
        setLayout(null);
        JPanel p1=new JPanel();
        p1.setBounds(5,5,875,490);;
        p1.setBackground(new Color(3,45,48));
        add(p1);

        JLabel l1=new JLabel("Add Rooms");
        l1.setBounds(194,10,160,22);
        l1.setFont(new Font("Tahoma",Font.BOLD,22));
        l1.setForeground(Color.WHITE);
        p1.add(l1);

        JLabel l2=new JLabel("Room Number");
        l2.setBounds(64,70,152,22);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setForeground(Color.WHITE);
        p1.add(l2);

        t1=new JTextField();
        t1.setBounds(200,70,156,20);
        t1.setFont(new Font("Tahoma",Font.BOLD,14));
        t1.setBackground(new Color(16,108,115));
        t1.setForeground(Color.WHITE);
        p1.add(t1);

        JLabel l3=new JLabel("Availability");
        l3.setBounds(64,110,152,22);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setForeground(Color.WHITE);
        p1.add(l3);

        c1=new JComboBox(new String[]{"Available","Occupied"});
        c1.setBounds(200,110,156,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setBackground(new Color(16,108,115));
        c1.setForeground(Color.WHITE);
        p1.add(c1);

        JLabel l4=new JLabel("Price");
        l4.setBounds(64,150,152,22);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setForeground(Color.WHITE);
        p1.add(l4);

        t2=new JTextField();
        t2.setBounds(200,150,156,20);
        t2.setFont(new Font("Tahoma",Font.BOLD,14));
        t2.setBackground(new Color(16,108,115));
        t2.setForeground(Color.WHITE);
        p1.add(t2);

        JLabel l5=new JLabel("Cleaning Status");
        l5.setBounds(64,180,152,22);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setForeground(Color.WHITE);
        p1.add(l5);

        c2=new JComboBox<>(new String[]{"Cleaned","Dirty"});
        c2.setBounds(200,180,156,20);
        c2.setFont(new Font("Tahoma",Font.BOLD,14));
        c2.setBackground(new Color(16,108,115));
        c2.setForeground(Color.WHITE);
        p1.add(c2);

        JLabel l6=new JLabel("Bed Type");
        l6.setBounds(64,220,152,22);
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        l6.setForeground(Color.WHITE);
        p1.add(l6);

        c3=new JComboBox(new String[]{"Sngle Bed","Double Bed","Triple Bed"});
        c3.setBounds(200,220,156,20);
        c3.setFont(new Font("Tahoma",Font.BOLD,14));
        c3.setBackground(new Color(16,108,115));
        c3.setForeground(Color.WHITE);
        p1.add (c3);

        b1=new JButton("Add");
        b1.setBounds(64,321,110,33);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        p1.add (b1);

        b2=new JButton("Back");
        b2.setBounds(198,321,111,33);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        p1.add ( b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,60,300,300);
        p1.add(image);

        setSize(885,500);
        setUndecorated(true);
        p1.setLayout(null);
        setLocation(20,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String roomNo = t1.getText();
        String ava = (String) c1.getSelectedItem();
        String price = t2.getText();
        String clean = (String) c2.getSelectedItem();
        String BedType = (String) c3.getSelectedItem();

        if(e.getSource()==b2){
            setVisible(false);

        }
         else {
            try {
                if (roomNo.trim().isEmpty() || price.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill the Details.");
                }
                else if (e.getSource() == b1) {
                    dataBaseConnection c = new dataBaseConnection();
                    String q = "insert into addRoom values('" + roomNo + "','" + ava + "','" + price + "','" + clean + "','" + BedType + "')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Room Added Sucessfully");
                    setVisible(false);

                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main() {

        new AddRooms();
    }
}