package hotelproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class reception extends JFrame implements ActionListener {

    JButton newcustomerform,room,department,allEmployees,customerInfo,logout;


    reception()
    {
        setBounds(300,100,1050,600);
        setTitle("reception page");
        getContentPane().setBackground(Color.white);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/receptionimg.jpg"));
        Image i2=i1.getImage().getScaledInstance(1400,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1050, 600);
        add(image);

         newcustomerform=new JButton("new customer button");
        newcustomerform.setBounds(80,20,200,30);
        newcustomerform.setBackground(Color.BLACK);
        newcustomerform.setForeground(Color.white);
        newcustomerform.addActionListener(this);
        image.add(newcustomerform);

        room=new JButton("room");
        room.setBounds(80,80,200,30);
        room.setBackground(Color.BLACK);
        room.setForeground(Color.white);
        room.addActionListener(this);
        image.add(room);

        department=new JButton("Department");
        department.setBounds(80,140,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.white);
        department.addActionListener(this);
        image.add(department);


        allEmployees=new JButton("all employees");
        allEmployees.setBounds(80,200,200,30);
        allEmployees.setBackground(Color.BLACK);
        allEmployees.setForeground(Color.white);
        allEmployees.addActionListener(this);
        image.add(allEmployees);


         customerInfo=new JButton("customer info");
        customerInfo.setBounds(80,260,200,30);
        customerInfo.setBackground(Color.BLACK);
        customerInfo.setForeground(Color.white);
        customerInfo.addActionListener(this);
        image.add(customerInfo);


         logout=new JButton("logout");
        logout.setBounds(80,320,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        image.add(logout);

        setLayout(null);
    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==newcustomerform)
        {
            setVisible(false);
            new addcustomers();
        }
        if (a.getSource()==room)
        {
            setVisible(false);
            new roompage();
        }
        if (a.getSource()==department)
        {
            setVisible(false);
            new departmentpage();
        }
        if (a.getSource()==allEmployees)
        {
            setVisible(false);
            new employeesinfo();
        }
        if(a.getSource()==customerInfo)
        {
            setVisible(false);
            new customerinfo();
        }
        if (a.getSource()==logout)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        reception obj = new reception();
    }
}
