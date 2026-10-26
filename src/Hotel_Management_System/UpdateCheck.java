package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {
    JTextField TextRoomNo,TextName,TextCheckedIn,TextAmountPaid,TextAmountPending;
    UpdateCheck(){

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,60,300,300);
        panel.add(image);

//        Labels.
        JLabel l1=new JLabel("Check-In Details");
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

        JLabel l4=new JLabel("Name");
        l4.setBounds(25,174,97,15);
        l4.setFont(new Font("Tahoma",Font.PLAIN,14));
        l4.setForeground(Color.WHITE);
        panel.add(l4);

        TextName=new JTextField();
        TextName.setBounds(248,174,140,20);
        panel.add(  TextName);

        JLabel l5=new JLabel("Checked-in");
        l5.setBounds(25,216,97,15);
        l5.setFont(new Font("Tahoma",Font.PLAIN,14));
        l5.setForeground(Color.WHITE);
        panel.add(l5);

        TextCheckedIn=new JTextField();
        TextCheckedIn.setBounds(248,216,140,20);
        panel.add(TextCheckedIn);

        JLabel l6=new JLabel("Amount Paid(Rs)");
        l6.setBounds(25,261,110,15);
        l6.setFont(new Font("Tahoma",Font.PLAIN,14));
        l6.setForeground(Color.WHITE);
        panel.add(l6);

        TextAmountPaid=new JTextField();
        TextAmountPaid.setBounds(248,261,140,20);
        panel.add(TextAmountPaid);

        JLabel l7=new JLabel("Pending Amount(Rs)");
        l7.setBounds(25,302,135,18);
        l7.setFont(new Font("Tahoma",Font.PLAIN,14));
        l7.setForeground(Color.WHITE);
        panel.add(l7);

        TextAmountPending=new JTextField();
        TextAmountPending.setBounds(248,302,140,20);
        panel.add(TextAmountPending);

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
                String amount=TextAmountPaid.getText();
                c.statement.executeUpdate("update  NewCustomer set Allocated_Room_Number='"+room+"',Name='"+name+"',Checked_In='"+check+"',Deposite='"+amount+"'where Number='"+q+"'");
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
                        TextName.setText(resultSet.getString("Name"));
                        TextCheckedIn.setText(resultSet.getString("Checked_In"));
                        TextAmountPaid.setText(resultSet.getString("Deposite"));
                    }
                    ResultSet resultSet1=c.statement.executeQuery("select * from addRoom where Room_No='"+TextRoomNo.getText()+"'");
                    if(resultSet1.next()){
                        String price=resultSet1.getString("Price");
                        int amountpaid=Integer.parseInt(price)-Integer.parseInt(TextAmountPaid.getText());
                        TextAmountPending.setText(""+amountpaid);
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
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args){

        new UpdateCheck();
    }
}
