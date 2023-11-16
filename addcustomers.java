package hotelproject;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

class addcustomers extends JFrame implements ActionListener {

    JLabel ID,Number,Name,Gender,Country,CheckInTime,Deposit;

    JTextField txtNumber,txtName,txtCountry,txtDeposite;

    JRadioButton rmale,rfemale;

    JButton Add,Back;

    JComboBox Card;

    Choice croom;


    addcustomers() {

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setLocation(400, 400);
        setBounds(350, 100, 900, 600);
        setVisible(true);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(350, 20, 400, 40);
        text.setFont(new Font("Ariel", Font.BOLD, 15));
        text.setForeground(Color.black);
        add(text);

        ID = new JLabel("ID");
        ID.setBounds(70, 70, 150, 30);
        ID.setFont(new Font("ariel", Font.BOLD, 17));
        add(ID);

        String availableoptions[] = {"Aadhar Card", "PAN Card", "Driving License"};
        Card = new JComboBox(availableoptions);
        Card.setBounds(300, 70, 150, 20);
        Card.setBackground(Color.white);
        Card.setForeground(Color.black);
        add(Card);

        Number = new JLabel("Number");
        Number.setBounds(70, 120, 150, 30);
        Number.setFont(new Font("ariel", Font.BOLD, 17));
        add(Number);

        txtNumber = new JTextField();
        txtNumber.setBounds(300, 120, 150, 30);
        add(txtNumber);

        Name = new JLabel("Name");
        Name.setBounds(70, 170, 150, 30);
        Name.setFont(new Font("ariel", Font.BOLD, 17));
        add(Name);

        txtName = new JTextField();
        txtName.setBounds(300, 170, 150, 30);
        add(txtName);

        Gender = new JLabel("Gender");
        Gender.setBounds(70, 220, 150, 30);
        Gender.setFont(new Font("ariel", Font.BOLD, 17));
        add(Gender);

        rmale = new JRadioButton("MALE");
        rmale.setBounds(300, 220, 75, 18);
        rmale.setFont(new Font("ariel", Font.BOLD, 10));
        add(rmale);

        rfemale = new JRadioButton("FEMALE");
        rfemale.setBounds(375, 220, 75, 18);
        rfemale.setFont(new Font("ariel", Font.BOLD, 10));
        add(rfemale);

        Country = new JLabel("Country");
        Country.setBounds(70, 270, 150, 30);
        Country.setFont(new Font("ariel", Font.BOLD, 17));
        add(Country);

        txtCountry = new JTextField();
        txtCountry.setBounds(300, 270, 150, 30);
        add(txtCountry);



        Date date = new Date();

        CheckInTime=new JLabel("CheckIn Time");
        CheckInTime.setBounds(70,370,150,30);
        CheckInTime.setFont(new Font("ariel",Font.BOLD,17));
        add(CheckInTime);

        JLabel time = new JLabel(""+date);
        time.setBounds(300,370,450,30);
        time.setFont(new Font("Raleway",Font.PLAIN,17));
        add(time);

        Deposit=new JLabel("Deposit");
        Deposit.setBounds(70,420,150,30);
        Deposit.setFont(new Font("ariel",Font.BOLD,17));
        add(Deposit);

        txtDeposite=new JTextField();
        txtDeposite.setBounds(300,420,150,30);
        add(txtDeposite);

        Add=new JButton("Add");
        Add.setBounds(90,500,70,30);
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.white);
        Add.addActionListener(this);
        add(Add);

        Back=new JButton("Back");
        Back.setBounds(220,500,70,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/customerpic.jpg"));
        Image i2=i1.getImage().getScaledInstance(300,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(540, 100, 300, 300);
        add(image);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==Add)
        {
            String customerid = (String) Card.getSelectedItem();
            String customernumber = txtNumber.getText();
            String customername = txtName.getText();
            String customergender = null;
            if(rmale.isSelected())
            {
                customergender="male";
            }
            else {
                customergender="female";
            }
            String customercountry = txtCountry.getText();
            String customerdeposit = txtDeposite.getText();

            try {
                conn Conn = new conn();
                String query = "insert into addcustomers values('"+ customerid +"','" + customernumber + "','" + customername + "','" + customergender+ "','" + customercountry +"','"+customerdeposit+"')";

                Conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "CUSTOMER DETAILS ADDED SUCCESSFULLY");
                setVisible(true);
            }
            catch (Exception a) {
                a.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new reception();}

        }
    public static void main(String[] args) {
        new addcustomers();
    }
}
