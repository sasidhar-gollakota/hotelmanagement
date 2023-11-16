package hotelproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class addroom extends JFrame implements ActionListener{

    JLabel heading,roomnumber,available,cleaningstatus,price,bedstatus;
    JTextField txtroomnumber,txtprice;
    JButton Addroom,cancel;
    JComboBox jcavailableoptions,jccleaningstatus,jcbedstatusoptions;

    addroom() {
        setBounds(300,100,1050,600);
        setTitle("addroom page");
        getContentPane().setBackground(Color.white);


        heading=new JLabel("ADD ROOM");
        heading.setBounds(450,30,120,30);
        heading.setFont(new Font("ARIEL",Font.BOLD,17));
        add(heading);


         roomnumber=new JLabel("Room number");
        roomnumber.setBounds(100,80,100,30);
        add(roomnumber);

         txtroomnumber=new JTextField();
        txtroomnumber.setBounds(250,85,150,30);
        add(txtroomnumber);

         available=new JLabel("Available");
        available.setBounds(100,140,100,30);
        add(available);

        String availableoptions[]={"available","occupied"};
         jcavailableoptions=new JComboBox(availableoptions);
        jcavailableoptions.setBounds(250,145,100,30);
        jcavailableoptions.setBackground(Color.white);
        jcavailableoptions.setForeground(Color.black);
        add(jcavailableoptions);

        cleaningstatus=new JLabel("Cleaning status");
        cleaningstatus.setBounds(100,185,100,30);
        add(cleaningstatus);

        String cleaninstatusoptions[]={"cleaned","not cleaned"};
         jccleaningstatus=new JComboBox(cleaninstatusoptions);
        jccleaningstatus.setBounds(250,190,100,30);
        jccleaningstatus.setBackground(Color.white);
        jccleaningstatus.setForeground(Color.black);
        add(jccleaningstatus);

        price=new JLabel("Price");
        price.setBounds(100,260,100,30);
        add(price);

         txtprice=new JTextField();
        txtprice.setBounds(250,260,100,30);
        add(txtprice);

        bedstatus=new JLabel("Bed status");
        bedstatus.setBounds(100,310,100,30);
        add(bedstatus);

        String bedstatusoptions[]={"single bed","double bed"};
         jcbedstatusoptions=new JComboBox(bedstatusoptions);
        jcbedstatusoptions.setBounds(250,310,100,30);
        jcbedstatusoptions.setBackground(Color.white);
        jcbedstatusoptions.setForeground(Color.black);
        add(jcbedstatusoptions);

         Addroom=new JButton("Add room");
        Addroom.setBounds(100,400,100,30);
        Addroom.setBackground(Color.BLACK);
        Addroom.setForeground(Color.white);
        Addroom.addActionListener(this);
        add(Addroom);

         cancel=new JButton("cancel");
        cancel.setBounds(260,400,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hotelroom.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 70, 700, 400);
        add(image);

        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
            if(ae.getSource()==Addroom) {
                String room = txtroomnumber.getText();
                String availability = (String) jcavailableoptions.getSelectedItem();
                String cleanstatus = (String) jccleaningstatus.getSelectedItem();
                String roomprice = txtprice.getText();
                String statusofbed = (String) jcbedstatusoptions.getSelectedItem();

                try {
                    conn Conn = new conn();
                    String query = "insert into addroom values('" + room + "','" + availability + "','" + cleanstatus + "','" + roomprice+ "','" + statusofbed +"')";

                    Conn.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "ROOM ADDED SUCCESSFULLY");
                    setVisible(true);
                }
                catch (Exception a) {
                    a.printStackTrace();
                }
            }
            if (ae.getSource()==cancel)
            {
                setVisible(false);
                new dashboard();
            }
    }

    public static void main(String[] args) {
        addroom obj=new addroom();
    }
}
