package hotelproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Loginpage extends JFrame implements ActionListener {

    JTextField username,password;
    JButton login,cancel;
    Loginpage()
    {
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setBounds(300,100,1000,500);
        setTitle("login page");
       // setSize(1366,500);

        JLabel user =new JLabel("username");
        user.setForeground(Color.black);
        //user.setSize(200,200)
        user.setBounds(200,110,100,30);
        user.setFont(new Font("Ariel", Font.ITALIC, 20));
        add(user);

        JLabel pass =new JLabel("password");
        pass.setForeground(Color.BLACK);

        pass.setBounds(200,200,100,30);
        pass.setFont(new Font("Ariel",Font.ITALIC,20));
        add(pass);

         username=new JTextField();
        username.setBounds(350,110,200,30);

        add(username);

         password=new JTextField();
        password.setBounds(350,200,200,30);

        add(password);





         login=new JButton("Login");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.setBounds(250,300,100,30);

        login.addActionListener(this);
        add(login);

         cancel=new JButton("cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setBounds(400,300,100,30);

        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icon/loginicon.jpg"));
        Image i3=i2.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i4=new ImageIcon(i3);
        JLabel loginimage=new JLabel(i4);
       // loginimage.setBounds(1000,250,100,100);
        loginimage.setBounds(650,80,250,250);
        add(loginimage);


    }
    public void actionPerformed(ActionEvent ae){
    try
            {
                String user=username.getText();
                String pass=password.getText();

                conn c=new conn();
                String query="select * from login where username = '"+user+"' and password = '"+pass+"'";

                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new dashboard().setVisible(true);
                }
                else if(ae.getSource()==cancel) {
                    setVisible(false);
                    new hotelprojectpgm().setVisible(true);
                }else{

                    JOptionPane.showMessageDialog(null,"Invalid username or password");

                }

            }

            catch(Exception e) {
                e.printStackTrace();
            }


    }
    public static void main(String[] args) {
        new Loginpage();


    }
}
