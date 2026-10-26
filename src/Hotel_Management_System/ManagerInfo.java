package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo  extends JFrame {
    ManagerInfo(){
        JPanel panel=new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,990,590);
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

//        JScrollPane scrollPane = new JScrollPane(table); // 1. Table ko scroll box ke andar pack kiya
//        scrollPane.setBounds(10, 40, 970, 440);          // 2. Scroll box ki size set ki
//        panel.add(scrollPane);                           // 3. Box ko screen par add kiya


        try{
            dataBaseConnection c=new dataBaseConnection();
            String q="select * from addEmployee where Job='Manager'";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JLabel l1=new JLabel("Name");
        l1.setForeground(Color.WHITE);
        l1.setBounds(41,11,70,19);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l1);

        JLabel l2=new JLabel("Age");
        l2.setForeground(Color.WHITE);
        l2.setBounds(159,11,70,19);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l2);

        JLabel l3=new JLabel("Gender");
        l3.setForeground(Color.WHITE);
        l3.setBounds(273,11,70,19);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l3);

        JLabel l4=new JLabel("Job");
        l4.setForeground(Color.WHITE);
        l4.setBounds(416,11,70,19);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l4);

        JLabel l5=new JLabel("Salary");
        l5.setForeground(Color.WHITE);
        l5.setBounds(536,11,70,19);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add( l5);

        JLabel l6=new JLabel("Phone");
        l6.setForeground(Color.WHITE);
        l6.setBounds(656,11,70,19);
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l6);

        JLabel l7=new JLabel("Adhar");
        l7.setForeground(Color.WHITE);
        l7.setBounds(786,11,70,19);
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l7);

        JLabel l8=new JLabel("Email");
        l8.setForeground(Color.WHITE);
        l8.setBounds(896,11,80,19);
        l8.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(l8);

        JButton back=new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(350,500,120,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);

        setLayout(null);
        setSize(1000,600);
        setLocation(430,100);
        setUndecorated(true);
        setVisible(true);


    }
    public static  void main(String[] args){
        new ManagerInfo();
    }
}
