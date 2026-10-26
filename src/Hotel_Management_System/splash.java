package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class splash  extends JFrame  {
splash(){
    super("This is Entrance page.");
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
    JLabel image=new JLabel(i1);
    image.setBounds(0,0,858,680);
    add(image);

    setLayout(null);
    setSize(858,680);
    setLocation(300,80);
//    setUndecorated(true);
    setVisible(true);

    try{
        Thread.sleep(5000);
        new login();
        setVisible(false);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

}



    public static void main(String[] args){
    new splash();
}
}
