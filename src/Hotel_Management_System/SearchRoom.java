package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchRoom extends JFrame implements ActionListener {
    JCheckBox checkBox;
    Choice choice;
    JTable table;
    JButton add,back;
    SearchRoom(){
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel l1 = new JLabel("SEARCH FOR ROOM");
        l1.setBounds(250, 11, 200, 31);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);
        panel.add(l1);

        checkBox =new JCheckBox("Only Display Available");
        checkBox.setBounds(400, 69, 205, 23);
        checkBox.setBackground(new Color(3, 45, 48));
        checkBox.setForeground(Color.WHITE);
        panel.add( checkBox);

        choice=new Choice();
        choice.add("Sngle Bed");
        choice.add("Double Bed");
        choice.setBounds(153,70,120,20);
        panel.add(choice);

        JLabel l2=new JLabel("BED TYPE");
        l2.setBounds(66, 70, 100, 23);
        l2.setBackground(new Color(3, 45, 48));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setForeground(Color.WHITE);
        panel.add( l2);

        table =new JTable();
        table.setBounds(0, 187, 700, 150);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        panel.add( table);

        try{
            dataBaseConnection c=new dataBaseConnection();
            String q="select * from addRoom";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JLabel l3=new JLabel("Room Number");
        l3.setBounds(23, 162, 150, 20);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setForeground(Color.WHITE);
        panel.add(l3);

        JLabel l4=new JLabel("Availablity");
        l4.setBounds(175, 162, 150, 20);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setForeground(Color.WHITE);
        panel.add(l4);

        JLabel l5=new JLabel("Price");
        l5.setBounds(458, 162, 150, 20);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setForeground(Color.WHITE);
        panel.add( l5);

        JLabel l6=new JLabel("Bed Type");
        l6.setBounds(580, 162, 150, 20);
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setForeground(Color.WHITE);
        panel.add(l6);

        JLabel l7=new JLabel("Clean Status");
        l7.setBounds(306, 162, 150, 20);
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setForeground(Color.WHITE);
        panel.add(l7);

        add=new JButton("SEARCH");
        add.setBounds(200,400,120,30);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add.setForeground(Color.WHITE);
        panel.add(add);

        back=new JButton("BACK");
        back.setBounds(400,400,120,30);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        panel.add(back);

        setSize(700,500);
       setUndecorated(true);
        setLocation(500,200);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String q="select * from addRoom where Bed_Type='"+choice.getSelectedItem()+"'";
            String q1="select * from addRoom where Avalability='Available' and Bed_Type='"+choice.getSelectedItem()+"'";
            try {
                dataBaseConnection c=new dataBaseConnection();
                ResultSet resultSet=c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

                if(checkBox.isSelected()){
                    ResultSet resultSet1=c.statement.executeQuery(q1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new SearchRoom();
    }
}
