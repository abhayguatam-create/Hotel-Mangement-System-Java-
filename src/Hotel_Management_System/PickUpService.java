package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUpService extends JFrame {
    Choice choice;
    PickUpService(){
        setLayout(null);
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,790,590);
        panel.setBackground(new Color(3,45,48));
       add(panel);

       JLabel POS=new JLabel("Pick Up Service");
        POS.setBounds(90,11,160,25);
        POS.setFont(new Font("Tahoma",Font.BOLD,20));
        POS.setForeground(Color.WHITE);
        panel.add(POS);

        JLabel pos=new JLabel("Pick Up Service");
        pos.setBounds(32,97,160,25);
        pos.setFont(new Font("Tahoma",Font.BOLD,14));
        pos.setForeground(Color.WHITE);
        panel.add(pos);

        choice=new Choice();
        choice.setBounds(200,94,150,25);
        panel.add(choice);

        try{
            dataBaseConnection c=new dataBaseConnection();
            ResultSet resultSet=c.statement.executeQuery("select * from addDriver");
            while(resultSet.next()){
             choice.add(resultSet.getString("Car_Comapany"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        JTable table=new JTable();
        table.setBounds(0,233,800,250);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add( table);

        try{
            dataBaseConnection c=new dataBaseConnection();
            String q="select * from addDriver";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception E) {
            throw new RuntimeException(E);
        }

        JLabel l1=new JLabel("Name");
        l1.setForeground(Color.WHITE);
        l1.setBounds(24,208,46,14);
        panel.add(l1);

        JLabel age=new JLabel("Age");
        age.setForeground(Color.WHITE);
        age.setBounds(165,208,46,14);
        panel.add( age);

        JLabel l2=new JLabel("Gender");
        l2.setForeground(Color.WHITE);
        l2.setBounds(265,208,100,14);
        panel.add(l2);

        JLabel l3=new JLabel("Company");
        l3.setForeground(Color.WHITE);
        l3.setBounds(365,208,100,14);
        panel.add(l3);

        JLabel l4=new JLabel("Car Name");
        l4.setForeground(Color.WHITE);
        l4.setBounds(486,208,100,14);
        panel.add(l4);

        JLabel l5=new JLabel("Avaliable");
        l5.setForeground(Color.WHITE);
        l5.setBounds(600,208,100,14);
        panel.add( l5);

        JLabel l6=new JLabel("Location");
        l6.setForeground(Color.WHITE);
        l6.setBounds(700,208,100,14);
        panel.add(l6);


        JButton Display=new JButton("Display");
        Display.setForeground(Color.WHITE);
        Display.setBackground(Color.BLACK);
        Display.setBounds(200,500,120,30);
        Display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dataBaseConnection c=new dataBaseConnection();
                    String q="select * from addDriver where Car_Comapany='"+choice.getSelectedItem()+"'";
                    ResultSet resultSet=c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel.add(Display);

        JButton Back=new JButton("Back");
        Back.setForeground(Color.WHITE);
        Back.setBackground(Color.BLACK);
        Back.setBounds(420,500,120,30);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(Back);



        setSize(800,600);
        setLocation(500,100);
        setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args){

        new PickUpService();
    }
}
