package hotelproject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

import net.proteanit.sql.*;

class departmentpage extends JFrame implements ActionListener {
    JTable table;

    JButton back;

    departmentpage() {

        getContentPane().setBackground(Color.white);
        setVisible(true);
        setLayout(null);
        setLocation(50, 100);
        setSize(1000,700);



       table = new JTable();
        table.setBounds(10, 50, 400, 400);
        add(table);

        back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(100,450,100,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bedimg.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 40, 200, 200);
        add(image);

        conn C=new conn();


        try {

            String query = "select * from department";
            ResultSet rs = C.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception a) {
            a.printStackTrace();

        }


    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new reception();
        }
    }
    public static void main(String[] args) {
        new departmentpage();
    }
}