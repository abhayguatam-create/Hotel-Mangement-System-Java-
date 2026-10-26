package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo  extends JFrame {
    CustomerInfo(){

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,890,590);
        add(panel);

        JTable table =new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{

            dataBaseConnection c=new dataBaseConnection();
            String q="select * from NewCustomer";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel id=new JLabel("ID");
        id.setBounds(31,11,46,14);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(id);

        JLabel number=new JLabel("NUMBER");
        number.setBounds(150,11,70,14);
        number.setForeground(Color.WHITE);
        number.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add( number);

        JLabel name=new JLabel("NAME");
        name.setBounds(270,11,46,14);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        JLabel gender=new JLabel("GENDER");
        gender.setBounds(360,11,70,14);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add( gender);

        JLabel country=new JLabel("COUNTRY");
        country.setBounds(480,11,80,14);
        country.setForeground(Color.WHITE);
        country.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add( country);

        JLabel allocRoomNo=new JLabel("ROOM NO");
        allocRoomNo.setBounds(600,11,100,14);
        allocRoomNo.setForeground(Color.WHITE);
        allocRoomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(allocRoomNo);

        JLabel date=new JLabel("DATE");
        date.setBounds(710,11,70,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);

        JLabel deposit=new JLabel("DEPOSIT");
        deposit.setBounds(800,11,70,14);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(deposit);

        JButton back=new JButton("BACK");
        back.setBounds(400,510,100,25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);



        setLayout(null);
        setUndecorated(true);
        setSize(900,600);
        setLocation(500,100);
        setVisible(true);
    }

    public static  void main(String[] args){

        new CustomerInfo();
    }
}
