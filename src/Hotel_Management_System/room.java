package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import java.sql.Connection;

public class room  extends JFrame  {
    JTable table;
    JButton back;
    room(){

        JPanel p1=new JPanel();
        p1.setBounds(5,5,890,590);
        p1.setBackground(new Color(3,45,48));
        p1.setLayout(null);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(600,200,200,200);
        p1.add(label);

        table=new JTable();
        table.setBounds(10,40,500,400);
        table.setForeground(Color.WHITE);
        table.setBackground(new Color(3,45,48));
        p1.add(table);


        try{
          dataBaseConnection c=new dataBaseConnection();
          String RoomNo="select * from  addRoom";
            ResultSet resultSet =c.statement.executeQuery(RoomNo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        p1.add(back);


        JLabel l1=new JLabel("Availability");
        l1.setBounds(119,15,80,19);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        l1.setForeground(Color.WHITE);
        p1.add(l1);

        JLabel l2=new JLabel("Clean Status");
        l2.setBounds(216,15,90,19);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setForeground(Color.WHITE);
        p1.add(l2);

        JLabel l3=new JLabel("Price");
        l3.setBounds(330,15,80,19);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setForeground(Color.WHITE);
        p1.add( l3);

        JLabel l4=new JLabel("Bed Type");
        l4.setBounds(417,15,80,19);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setForeground(Color.WHITE);
        p1.add( l4);

        JLabel l5=new JLabel("Room No.");
        l5.setBounds(12,15,80,19);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setForeground(Color.WHITE);
        p1.add(l5);

        setLayout(null);
        setSize(900,600);
        setLocation(500,100);
        setUndecorated(true);
        setVisible(true);


    }
    public static void main(String[] args){
        new room();
    }
}
