package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception  extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
    Reception(){
        super("THis page is for staff");
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(3,45,48));
        panel1.setBounds(280,5,1238,820);
        add(panel1);

        JPanel panel2=new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(5,5,270,820);
        panel2.setBackground(new Color(3,45,48));
        add(panel2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/cccc.gif"));
        Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon imageIcon=new ImageIcon(i2);
        JLabel image=new JLabel(imageIcon);
        image.setBounds(300,20,800,800);
        panel1.add(image);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image i22=i11.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i22);
        JLabel image1=new JLabel(imageIcon1);
        image1.setBounds(5,530,250,250);
        panel2.add(image1);

// Buttons.
        b1=new JButton("New Customer Form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,30,200,30);
        b1.addActionListener(this);
        panel2.add( b1);

        b2=new JButton("Room");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(30,70,200,30);
        panel2.add(  b2);

       b3=new JButton("Department");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setBounds(30,110,200,30);
        panel2.add(  b3);

        b4=new JButton("All EMployee Info");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        b4.setBounds(30,150,200,30);
        panel2.add( b4);

       b5=new JButton("Customer Info");
        b5.setBackground(Color.BLACK);
       b5.setForeground(Color.WHITE);
        b5.addActionListener(this);
        b5.setBounds(30,190,200,30);
        panel2.add(b5);

        b6=new JButton("Manager Info");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.addActionListener(this);
        b6.setBounds(30,230,200,30);
        panel2.add(  b6);

       b7=new JButton("Check Out");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        b7.setBounds(30,270,200,30);
        panel2.add( b7);

       b8=new JButton("Update Check-in Details");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.addActionListener(this);
        b8.setBounds(30,310,200,30);
        panel2.add( b8);

        b9=new JButton("Update Room Status");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.addActionListener(this);
        b9.setBounds(30,350,200,30);
        panel2.add(b9);

        b10=new JButton("Pick up Services");
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.addActionListener(this);
        b10.setBounds(30,390,200,30);
        panel2.add( b10);

        b11=new JButton("Search Room");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.addActionListener(this);
        b11.setBounds(30,430,200,30);
        panel2.add( b11);

        b12=new JButton("Log Out");
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.addActionListener(this);
        b12.setBounds(30,470,100,30);
        panel2.add( b12);

        b13=new JButton("Back");
        b13.setBackground(Color.BLACK);
        b13.setForeground(Color.WHITE);
        b13.addActionListener(this);
        b13.setBounds(150,470,100,30);
        panel2.add( b13);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        b1.addActionListener(this);
        setSize(1950,1090);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==b1){
//                New Customer form.
                new NewCustomer();
            }
            if(e.getSource()==b2){
//                  Room.
                new room();
            }
            if(e.getSource()==b3){
//               Department.
                    new Department();
            }
            if(e.getSource()==b4){
//                All EMployee Info.
                    new Employee();
            }
            if(e.getSource()==b5){
//                Customer Info.
                new CustomerInfo();
            }
            if(e.getSource()==b6){
//                Manager Info.
                new ManagerInfo();
            }
            if(e.getSource()==b7){
//                Check out.
                new CheckOut();

            } if(e.getSource()==b8){
//                Update Check-In Details.
                new UpdateCheck();

            }
            if(e.getSource()==b9){
//                 Update Room Status.
                new UpdateRoom();

            }
            if(e.getSource()==b10){
//         pick up services.
            new PickUpService();
            }
            if(e.getSource()==b11){
//           Search Room.
                new SearchRoom();


            } if(e.getSource()==b12){
//              Log out button.
                   System.exit(404);

            } if(e.getSource()==b13){
//                  Back.
                setVisible(false);
                new DashBoard();
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Reception();
    }
}
