package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5;
    Admin(){
        super("This is Admin Dashboard.");

        b1=new JButton("ADD EMPLOYEE");
        b1.addActionListener(this);
        b1.setBounds(250,230,200,30);
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        add(b1);

        b2=new JButton("ADD ROOMS");
        b2.addActionListener(this);
        b2.setBounds(250,380,200,30);
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        add( b2);

        b3=new JButton("ADD DRIVERS");
        b3.addActionListener(this);
        b3.setBounds(250,530,200,30);
        b3.setFont(new Font("Tahoma",Font.BOLD,15));
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.WHITE);
        add(b3);

        b4=new JButton("Log Out");
        b4.addActionListener(this);
        b4.setBounds(10,750,95,30);
        b4.setFont(new Font("Tahoma",Font.BOLD,15));
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.BLACK);
        add(b4);

        b5=new JButton("Back");
        b5.addActionListener(this);
        b5.setBounds(110,750,95,30);
        b5.setFont(new Font("Tahoma",Font.BOLD,15));
        b5.setForeground(Color.WHITE);
        b5.setBackground(Color.BLACK);
        add( b5);

//         Images.
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image i2=i1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(70,180,120,120);
        add(image);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image i22=i11.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel image1=new JLabel(i33);
        image1.setBounds(70,340,120,120);
        add(image1);

        ImageIcon i111=new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image i222=i111.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon i333=new ImageIcon(i222);
        JLabel image11=new JLabel(i333);
        image11.setBounds(70,500,120,120);
        add(image11);

        ImageIcon i1111=new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image i2222=i1111.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3333=new ImageIcon(i2222);
        JLabel image111=new JLabel(i3333);
        image111.setBounds(900,100,600,600);
        add(image111);

        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setSize(1950,1090);
        setLocation(0,0);
//    setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==b1){
//                 Add Employee.
                    new AddEmployee();
            } else if (e.getSource()==b2) {
//                Add Rooms.
                new AddRooms();

            } else if (e.getSource()==b3) {
//                 Add Drivers
                    new AddDriver();
            } else if (e.getSource()==b4) {
//                Log out
              System.exit(404);
            }
            else {
//                Back
                this.setVisible(false);
                new DashBoard();

            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args){
        new Admin();
    }
}
