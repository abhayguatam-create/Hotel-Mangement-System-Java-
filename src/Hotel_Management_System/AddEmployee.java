package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee  extends JFrame implements ActionListener {
    JTextField textname,textage,textsalary,textphone,textadhar,textemail;
    JComboBox Job;
    JRadioButton btnMale,btnFemale;
    JButton add,back;
    AddEmployee(){
        super("Employee Add Page.");
        setLayout(null);
        JPanel p1=new JPanel();
        p1.setBounds(5,5,890,490);
        p1.setLayout(null);
        p1.setBackground(new Color(3,45,48));
        add(p1);

        JLabel l1=new JLabel("NAME");
        l1.setBounds(60,30,150,27);
        l1.setFont(new Font("serif",Font.BOLD,18));
        l1.setForeground(Color.WHITE);
        p1.add(l1);

        textname=new JTextField();
        textname.setBounds(200,30,150,27);
        textname.setBackground(new Color(16,108,115));
        textname.setFont(new Font("Tahoma",Font.BOLD,14));
        textname.setForeground(Color.WHITE);
        p1.add(textname);

        JLabel l2=new JLabel("AGE");
        l2.setBounds(60,80,150,27);
        l2.setFont(new Font("serif",Font.BOLD,18));
        l2.setForeground(Color.WHITE);
        p1.add(l2);

        textage=new JTextField();
        textage.setBounds(200,80,150,27);
        textage.setBackground(new Color(16,108,115));
        textage.setFont(new Font("Tahoma",Font.BOLD,14));
        textage.setForeground(Color.WHITE);
        p1.add( textage);

        JLabel l3=new JLabel("GENDER");
        l3.setBounds(60,130,150,27);
        l3.setFont(new Font("serif",Font.BOLD,18));
        l3.setForeground(Color.WHITE);
        p1.add(l3);

        btnMale=new JRadioButton("MALE");
        btnMale.setBounds(200,130,70,27);
        btnMale.setFont(new Font("Tahoma",Font.BOLD,14));
        btnMale.setBackground(new Color(3,45,48));
        btnMale.setForeground(Color.WHITE);
        p1.add( btnMale);

        btnFemale=new JRadioButton("FEMALE");
        btnFemale.setBounds(280,130,120,27);
        btnFemale.setFont(new Font("Tahoma",Font.BOLD,14));
        btnFemale.setBackground(new Color(3,45,48));
        btnFemale.setForeground(Color.WHITE);
        p1.add(  btnFemale);

        JLabel l4=new JLabel("JOB");
        l4.setBounds(60,180,150,27);
        l4.setFont(new Font("serif",Font.BOLD,18));
        l4.setForeground(Color.WHITE);
        p1.add(l4);
//
        Job=new JComboBox(new String[]{"Front Desk","HouseKeeping","Kitchen Staff","Room Service","Manager","Accountant","Chef"});
        Job.setBounds(200,180,150,27);
        Job.setBackground(new Color(16,108,115));
        Job.setFont(new Font("Tahoma",Font.BOLD,14));
        Job.setForeground(Color.WHITE);
        p1.add( Job);
//
        JLabel l5=new JLabel("SALARY");
        l5.setBounds(60,230,150,27);
        l5.setFont(new Font("serif",Font.BOLD,18));
        l5.setForeground(Color.WHITE);
        p1.add(l5);

        textsalary=new JTextField();
        textsalary.setBounds(200,230,150,27);
        textsalary.setBackground(new Color(16,108,115));
        textsalary.setFont(new Font("Tahoma",Font.BOLD,14));
        textsalary.setForeground(Color.WHITE);
        p1.add( textsalary);

        JLabel l6=new JLabel("PHONE");
        l6.setBounds(60,280,150,27);
        l6.setFont(new Font("serif",Font.BOLD,18));
        l6.setForeground(Color.WHITE);
        p1.add( l6);

        textphone=new JTextField();
        textphone.setBounds(200,280,150,27);
        textphone.setBackground(new Color(16,108,115));
        textphone.setFont(new Font("Tahoma",Font.BOLD,14));
        textphone.setForeground(Color.WHITE);
        p1.add( textphone);

        JLabel l7=new JLabel("ADHAR NO.");
        l7.setBounds(60,330,150,27);
        l7.setFont(new Font("serif",Font.BOLD,18));
        l7.setForeground(Color.WHITE);
        p1.add(l7);

        textadhar=new JTextField();
        textadhar.setBounds(200,330,150,27);
        textadhar.setBackground(new Color(16,108,115));
        textadhar.setFont(new Font("Tahoma",Font.BOLD,14));
        textadhar.setForeground(Color.WHITE);
        p1.add( textadhar);

        JLabel l8=new JLabel("EMAIL");
        l8.setBounds(60,380,150,27);
        l8.setFont(new Font("serif",Font.BOLD,18));
        l8.setForeground(Color.WHITE);
        p1.add(l8);

        textemail=new JTextField();
        textemail.setBounds(200,380,150,27);
        textemail.setBackground(new Color(16,108,115));
        textemail.setFont(new Font("Tahoma",Font.BOLD,14));
        textemail.setForeground(Color.WHITE);
        p1.add(  textemail);

        JLabel AddEMPDET=new JLabel("ADD EMPLOYEE DETAILS");
        AddEMPDET.setBounds(450,24,445,35);
        AddEMPDET.setFont(new Font("serif",Font.BOLD,31));
        AddEMPDET.setForeground(Color.WHITE);
        p1.add(AddEMPDET);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 100, 300, 300);
        p1.add(image);

        add=new JButton("ADD");
        add.setBounds(60,430,100,30);
       add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        p1.add( add);

        back=new JButton("BACK");
        back.setBounds(200,430,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        p1.add(  back);

        setLocation(60,160);
        setSize(900,500);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        JTextField textname,textage,textsalary,textphone,textadhar,textemail;
//        JComboBox Job;
//        JRadioButton btnMale,btnFemale;
        String name=textname.getText();
        String age=textage.getText();
        String gender=null;
        if(btnMale.isSelected()) gender=btnMale.getText();
        else gender=btnFemale.getText();
        String job=(String) Job.getSelectedItem();
        String salary=textsalary.getText();
        String phone=textphone.getText();
        String adhar=textadhar.getText();
        String email=textemail.getText();

        if(e.getSource()==back){
            setVisible(false);

        }
        else{
            try{
               if(name.trim().isEmpty()|| age.trim().isEmpty()|| phone.trim().isEmpty()||
                        salary.trim().isEmpty()|| adhar.trim().isEmpty()|| email.trim().isEmpty()) {
                   JOptionPane.showMessageDialog(null, "Fill the Deatils");
               } else if(e.getSource()==add){
                    dataBaseConnection c=new dataBaseConnection();
                    String q= "insert into addEmployee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+adhar+"','"+email+"')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Employee Add Sucessfull");
                    setVisible(false);

                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    public static  void main(String[] args){

        new AddEmployee();
    }

}
