package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame  implements ActionListener {
    Choice choice;
    JButton checkout,back,check;
    JLabel labelRoom,labelCheckInTime;
    CheckOut(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel l1=new JLabel("Check-Out");
        l1.setBounds(100,20,150,30);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(l1);

        JLabel l2=new JLabel("Customer Id");
        l2.setBounds(30,80,100,30);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l2);

        choice=new Choice();
        choice.setBounds(200,80,150,30);
        choice.setForeground(Color.WHITE);
        choice.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(choice);

        try {
            dataBaseConnection c=new dataBaseConnection();
            ResultSet resultSet=c.statement.executeQuery("select * from NewCustomer");
            while (resultSet.next()){
                choice.add(resultSet.getString("Number"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JLabel l3=new JLabel("Room Number");
        l3.setBounds(30,130,150,30);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l3);

         labelRoom=new JLabel();
        labelRoom.setBounds(200,130,150,30);
        labelRoom.setForeground(Color.WHITE);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelRoom);

        JLabel l4=new JLabel("Check-In Time");
        l4.setBounds(30,180,150,30);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l4);

        labelCheckInTime=new JLabel();
        labelCheckInTime.setBounds(200,180,250,30);
        labelCheckInTime.setForeground(Color.WHITE);
        labelCheckInTime.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelCheckInTime);

        JLabel l5=new JLabel("Check-Out-Time :");
        l5.setBounds(30,230,150,30);
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l5);

        Date date=new Date();
        JLabel l6=new JLabel(""+date);
        l6.setBounds(200,230,250,30);
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l6);

        back=new JButton("Back");
        back.setBounds(230,300,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        panel.add(back);

        checkout=new JButton("Check Out");
        checkout.setBounds(100,300,100,30);
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.addActionListener(this);
        panel.add(checkout);

        check=new JButton("Check");
        check.setBounds(350,300,100,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.addActionListener(this);
        panel.add(check);


        setLayout(null);
        setSize(800,400);
        setLocation(500,210);
        setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            dataBaseConnection c=new dataBaseConnection();
            if(e.getSource()==back){
                setVisible(false);
            } else if (e.getSource()==check) {
                ResultSet resultSet=c.statement.executeQuery("select  * from NewCustomer where Number='"+choice.getSelectedItem()+"'");
                if(resultSet.next()){
                    labelRoom.setText(resultSet.getString("Allocated_Room_Number"));
                    labelCheckInTime.setText(resultSet.getString("Checked_In"));

                }

            }else{
                c.statement.executeUpdate("delete from NewCustomer where Number='"+choice.getSelectedItem()+"'");
                c.statement.executeUpdate("update  addRoom set Avalability='Available' where Room_No='"+labelRoom+"'");
                JOptionPane.showMessageDialog(null,"Data Updated Sucessfully");
                setVisible(false);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static  void main(String[] args){
        new CheckOut();
    }
}
