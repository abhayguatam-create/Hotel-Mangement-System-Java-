package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoard  extends JFrame implements ActionListener {
    JButton b1,b2;
DashBoard(){
    super("THis is our DashBoard page.");

    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
    Image i2=i1.getImage().getScaledInstance(1950,1090, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,1950,1090);
    add(image);

    b1=new JButton("ADMIN");
    b1.setFont(new Font("Tahoma",Font.BOLD,15));
    b1.setBackground(new Color(255,98,0));
    b1.setBounds(880,510,140,30);
    b1.addActionListener(this);
    b1.setForeground(Color.WHITE);
    image.add(b1);

    b2=new JButton("STAFF");
    b2.setFont(new Font("Tahoma",Font.BOLD,15));
    b2.setBackground(new Color(255,98,0));
    b2.setBounds(425,510,140,30);
    b2.addActionListener(this);
    b2.setForeground(Color.WHITE);
    image.add(b2);

    ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
    Image i22=i11.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
    ImageIcon i33=new ImageIcon(i22);
    JLabel image1=new JLabel(i33);
    image1.setBounds(400,300,200,195);
    image.add(image1);

    ImageIcon i111=new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
    Image i222=i111.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
    ImageIcon i333=new ImageIcon(i222);
    JLabel image11=new JLabel(i333);
    image11.setBounds(860,300,200,195);
    image.add(image11);

    setLayout(null);
    setSize(1950,1090);
    setLocation(0,0);
//    setUndecorated(true);
    setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==b1){
//                 Admin panel.
               this.setVisible(false);
                new AdminLogin();
                
            }else{
//                Staff panel.
                setVisible(false);
                new Reception();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public  static void main(String[] args){
    new DashBoard();
}
}
