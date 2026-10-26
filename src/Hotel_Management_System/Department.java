package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JTable table=new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            dataBaseConnection c=new dataBaseConnection();
            String depart="select * from department";
            ResultSet resultSet=c.statement.executeQuery(depart);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JLabel l1=new JLabel("Department");
        l1.setBounds(145,11,105,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        l1.setForeground(Color.WHITE);
        panel.add(l1);

        JLabel l2=new JLabel("Budget");
        l2.setBounds(431,11,105,20);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setForeground(Color.WHITE);
        panel.add(l2);

        JButton back=new JButton("BACK");
        back.setBounds(400,410,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);

        setLayout(null);
        setUndecorated(false);
        setVisible(true);
        setLocation(550,150);
        setSize(700,500);

    }
    public  static void main(String[] args){
        new Department();
    }
}
