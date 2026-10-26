package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    JTextField nameText,ageText,carCText,carNText,locationText;
    JComboBox genCombo,AvaCombo;
    JButton add,back;
    AddDriver(){
        super("This is a Add Driver Page.");
        JPanel p1=new JPanel();
        p1.setBounds(5,5,890,490);
        p1.setBackground(new Color(3,45,48));
        p1.setLayout(null);
        add(p1);

        JLabel label=new JLabel("ADD DRIVERS");
        label.setBounds(194,10,200,22);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma",Font.BOLD,22));
        p1.add(label);

//        Labels.
        JLabel l1=new JLabel("NAME");
        l1.setBounds(64,70,102,22);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l1);

         nameText=new JTextField();
        nameText.setBounds(174,70,156,20);
        nameText.setForeground(Color.WHITE);
        nameText.setBackground(new Color(16,108,115));
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(nameText);

        JLabel l2=new JLabel("AGE");
        l2.setBounds(64,110,102,22);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add( l2);

        ageText=new JTextField();
        ageText.setBounds(174,110,156,20);
        ageText.setForeground(Color.WHITE);
        ageText.setBackground(new Color(16,108,115));
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(ageText);

        JLabel l3=new JLabel("GENDER");
        l3.setBounds(64,150,102,22);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l3);

        genCombo=new JComboBox(new String[]{"MALE","FEMALE"});
        genCombo.setBounds(176,150,156,20);
        genCombo.setForeground(Color.WHITE);
        genCombo.setBackground(new Color(16,108,115));
        genCombo.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(genCombo);

        JLabel l4=new JLabel("CAR COMPANY");
        l4.setBounds(64,190,110,22);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add( l4);

        carCText=new JTextField();
        carCText.setBounds(174,190,156,20);
        carCText.setForeground(Color.WHITE);
        carCText.setBackground(new Color(16,108,115));
        carCText.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(carCText);

        JLabel l5=new JLabel("CAR NAME");
        l5.setBounds(64,230,102,22);
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l5);

        carNText=new JTextField();
        carNText.setBounds(174,230,156,20);
        carNText.setForeground(Color.WHITE);
        carNText.setBackground(new Color(16,108,115));
        carNText.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add( carNText);

        JLabel l6=new JLabel("AVAILABLE");
        l6.setBounds(64,270,102,22);
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l6);

        AvaCombo=new JComboBox(new String[]{"YES","NO"});
        AvaCombo.setBounds(174,270,156,20);
        AvaCombo.setForeground(Color.WHITE);
        AvaCombo.setBackground(new Color(16,108,115));
        AvaCombo.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(AvaCombo);

        JLabel l7=new JLabel("LOCATION");
        l7.setBounds(64,310,102,22);
        l7.setForeground(Color.WHITE);
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(l7);

       locationText=new JTextField();
        locationText.setBounds(174,310,156,20);
        locationText.setForeground(Color.WHITE);
        locationText.setBackground(new Color(16,108,115));
        locationText.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(locationText);

        add=new JButton("ADD");
        add.setBounds(64,380,111,33);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        p1.add(add);

       back=new JButton("BACK");
        back.setBounds(200,380,111,33);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        p1.add(back);

//        Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,60,300,300);
        p1.add(image);


        setLayout(null);
        setSize(900,500);
        setLocation(20,200);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==back){
        setVisible(false);

    }else{
        try{
            String name=nameText.getText();
            String age=ageText.getText();
            String gender=(String) genCombo.getSelectedItem();
            String carCompany=carCText.getText();
            String carName=carNText.getText();
            String avaiable=(String) AvaCombo.getSelectedItem();
            String location=locationText.getText();
            if(e.getSource()==add){
                if(name.trim().isEmpty() || age.trim().isEmpty() ||
                        carCompany.trim().isEmpty() ||carName.trim().isEmpty() ||location.trim().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Fill the Details.");
                }else{
                    dataBaseConnection c=new dataBaseConnection();
                    String q="insert into addDriver values('"+name+"','"+age+"','"+gender+"','"+carCompany+"','"+carName+"','"+avaiable+"','"+location+"')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Driver Added Sucessfully");
                    setVisible(false);
                    new Admin();
                }

            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    }

    public static void main(String[] args){
    new AddDriver();
    }
}
