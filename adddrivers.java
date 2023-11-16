package hotelproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class adddrivers extends JFrame implements ActionListener{
    JLabel heading,name,age,gender,carcompany,carmodel,available,location;
    JTextField txtname,txtage,txtcarcompany,txtcarmodel,txtlocation;
    JButton Adddriver,cancel;
    JComboBox jcgender,jcavailable;

    adddrivers() {

        setTitle("adddriver page");
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(300,100,1050,600);
        setVisible(true);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/cardriverimg.jpg"));
        Image i2=i1.getImage().getScaledInstance(1400,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1050, 600);
        add(image);

        heading=new JLabel("ADD DRIVER");
        heading.setBounds(450,30,180,30);
        heading.setForeground(Color.black);
        heading.setFont(new Font("ARIEL",Font.BOLD,20));
        image.add(heading);


        name=new JLabel("NAME");
        name.setBounds(750,80,100,30);
        name.setFont(new Font("ARIEL",Font.BOLD,17));
        name.setForeground(Color.ORANGE);
        image.add(name);

        txtname=new JTextField();
        txtname.setBounds(850,85,150,30);
        image.add(txtname);

        age=new JLabel("AGE");
        age.setBounds(750,140,100,30);
        age.setForeground(Color.orange);
        image.add(age);

        txtage=new JTextField();
        txtage.setBounds(850,140,150,30);
        image.add(txtage);

        gender=new JLabel("GENDER");
        gender.setBounds(750,185,100,30);
        gender.setForeground(Color.orange);
        image.add(gender);

        String availableoptions[]={"MALE","FEMALE"};
        jcgender=new JComboBox(availableoptions);
        jcgender.setBounds(850,185,100,30);
        jcgender.setBackground(Color.white);
        jcgender.setForeground(Color.black);
        image.add(jcgender);

        carcompany=new JLabel("CAR COMPANY");
        carcompany.setBounds(750,260,100,30);
        carcompany.setForeground(Color.orange);
        image.add(carcompany);

        txtcarcompany=new JTextField();
        txtcarcompany.setBounds(850,260,100,30);
        image.add(txtcarcompany);

        carmodel=new JLabel("CAR MODEL");
        carmodel.setBounds(750,310,100,30);
        carmodel.setForeground(Color.orange);
        image.add(carmodel);

        txtcarmodel=new JTextField();
        txtcarmodel.setBounds(850,310,100,30);
        image.add(txtcarmodel);

        available=new JLabel("AVAILABLE");
        available.setBounds(750,360,100,30);
        available.setForeground(Color.orange);
        image.add(available);

        String driveravailableoptions[]={"AVAILABLE","NOT AVAILABLE"};
        jcavailable=new JComboBox(driveravailableoptions);
        jcavailable.setBounds(850,360,100,30);
        jcavailable.setBackground(Color.white);
        jcavailable.setForeground(Color.black);
        image.add(jcavailable);

        location=new JLabel("LOCATION");
        location.setBounds(750,410,100,30);
        location.setForeground(Color.orange);
        image.add(location);

        txtlocation=new JTextField();
        txtlocation.setBounds(850,410,100,30);
        image.add(txtlocation);


        Adddriver=new JButton("Add driver");
        Adddriver.setBounds(700,460,100,30);
        Adddriver.setBackground(Color.BLACK);
        Adddriver.setForeground(Color.white);
        Adddriver.addActionListener(this);
        image.add(Adddriver);

        cancel=new JButton("cancel");
        cancel.setBounds(850,460,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        image.add(cancel);





    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Adddriver) {
            String drivername = name.getText();
            String driverage = age.getText();
            String drivergender = (String) jcgender.getSelectedItem();
            String drivercarcompany = carcompany.getText();
            String drivercarmodel = carmodel.getText();
            String driveravailable = (String) jcavailable.getSelectedItem();
            String driverlocation = location.getText();


            try {
                conn Conn = new conn();
                String query = "insert into adddriver values('" + drivername + "','" + driverage + "','" + drivergender + "','" +drivercarcompany+ "','" + drivercarmodel+"','"+driveravailable+"','"+driverlocation+"')";

                Conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "DRIVER DETAILS ADDED SUCCESSFULLY");
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
        adddrivers obj=new adddrivers();
    }
}
