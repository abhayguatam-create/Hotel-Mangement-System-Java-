package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {
    JTextField TextRoomNo,TextName,TextCheckedIn,TextAmountPaid,TextAmountPending;
    UpdateRoom(){

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,60,300,300);
        panel.add(image);

//        Labels.
        JLabel l1=new JLabel("Update Room Status");
        l1.setBounds(124,11,222,25);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l1.setForeground(Color.WHITE);
        panel.add(l1);

        JLabel l2=new JLabel("ID");
        l2.setBounds(25,88,46,15);
        l2.setFont(new Font("Tahoma",Font.PLAIN,14));
        l2.setForeground(Color.WHITE);
        panel.add( l2);

        Choice choice=new Choice();
        choice.setBounds(248,85,140,20);
        panel.add(choice);

        try{
            dataBaseConnection c=new dataBaseConnection();
            ResultSet resultSet=c.statement.executeQuery("select * from NewCustomer");
            while(resultSet.next()){
                choice.add(resultSet.getString("Number"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        JLabel l3=new JLabel("Room Number");
        l3.setBounds(25,129,107,15);
        l3.setFont(new Font("Tahoma",Font.PLAIN,14));
        l3.setForeground(Color.WHITE);
        panel.add(  l3);

        TextRoomNo=new JTextField();
        TextRoomNo.setBounds(248,129,140,20);
        panel.add(  TextRoomNo);

        JLabel l4=new JLabel("Availablity");
        l4.setBounds(25,174,97,15);
        l4.setFont(new Font("Tahoma",Font.PLAIN,14));
        l4.setForeground(Color.WHITE);
        panel.add(l4);

        TextName=new JTextField();
        TextName.setBounds(248,174,140,20);
        panel.add(  TextName);

        JLabel l5=new JLabel("Clean Status");
        l5.setBounds(25,216,97,15);
        l5.setFont(new Font("Tahoma",Font.PLAIN,14));
        l5.setForeground(Color.WHITE);
        panel.add(l5);

        TextCheckedIn=new JTextField();
        TextCheckedIn.setBounds(248,216,140,20);
        panel.add(TextCheckedIn);


        JButton Update=new JButton("Update");
        Update.setBounds(140,378,90,25);
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dataBaseConnection c=new dataBaseConnection();
                    String q=choice.getSelectedItem();
                    String room=TextRoomNo.getText();
                    String name=TextName.getText();
                    String check=TextCheckedIn.getText();
                    c.statement.executeUpdate("update  addRoom set Cleaness_Status='"+check+"',Avalability='"+name+"' where Room_No='"+room+"'");
                    JOptionPane.showMessageDialog(null,"Data Updated Sucessfully");
                    setVisible(false);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel.add(Update);

        JButton Back=new JButton("Back");
        Back.setBounds(250,378,90,25);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(Back);


        JButton check=new JButton("Check");
        check.setBounds(360,378,90,25);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String q="select * from NewCustomer where Number='"+id+"'";
                try{
                    dataBaseConnection c=new dataBaseConnection();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    while(resultSet.next()){
                        TextRoomNo.setText(resultSet.getString("Allocated_Room_Number"));
                    }
                    ResultSet resultSet1=c.statement.executeQuery("select * from addRoom where Room_No='"+TextRoomNo.getText()+"'");
                    while (resultSet1.next()){
                        TextName.setText(resultSet1.getString("Avalability"));
                        TextCheckedIn.setText(resultSet1.getString("Cleaness_Status"));
                    }
                }
                catch(Exception E){
                    E.printStackTrace();
                }

            }
        });
        panel.add(check);


        setSize(950,500);
        setLocation(400,200);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static  void main(String[]args){
        new UpdateRoom();
    }
}
