package hotelproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class dashboard extends JFrame implements ActionListener{
    dashboard()
    {
        setBounds(300,100,1050,600);
        setTitle("login page");
        setLayout(null);
        setVisible(true);

        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/dashboardhotel.jpg"));
        Image i6=i5.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i7=new ImageIcon(i6);
        JLabel dashboardimg=new JLabel(i7);
        //dashboardimg.setLocation(200,50);
        dashboardimg.setBounds(0,0,1050,700);
        add(dashboardimg);
        JLabel details=new JLabel("HOTEL PENINSULA  WELCOMES YOU");
        details.setBounds(150,100,1000,50);
        details.setFont(new Font("Ariel",Font.BOLD,40));
        details.setForeground(Color.white);
        dashboardimg.add(details);

        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1050,40);
        dashboardimg.add(mb);
        mb.setVisible(true);

        JMenu hotelManagementoption=new JMenu("hotel management");
       // menudetails.setBounds(0,100,20,10);
        hotelManagementoption.setForeground(Color.BLACK);
        mb.add(hotelManagementoption);

        JMenuItem reception=new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotelManagementoption.add(reception);

        JMenu adminoption=new JMenu("Admin");
        adminoption.setForeground(Color.black);
        mb.add(adminoption);

        JMenuItem addemployee=new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        adminoption.add(addemployee);

        JMenuItem addroom=new JMenuItem("ADD ROOM");
        addroom.addActionListener(this);
        adminoption.add(addroom);

        JMenuItem adddrivers=new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        adminoption.add(adddrivers);


    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new addemployee();
            setVisible(false);
        }
        if (ae.getActionCommand().equals("ADD ROOM"))
        {
            new addroom();
            setVisible(false);
        }
        if (ae.getActionCommand().equals("ADD DRIVERS"))
        {
            new adddrivers();
            setVisible(false);
        }
        if (ae.getActionCommand().equals("RECEPTION"))
        {
            new reception();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        dashboard obj=new dashboard();

    }
}
