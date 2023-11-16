package hotelproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hotelprojectpgm extends JFrame implements ActionListener{
    hotelprojectpgm() {
        getContentPane().setBackground(Color.white);
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hotelfrontpage.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,565,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 565);
        add(image);

        JLabel text = new JLabel("HOTEL MANAGMENT SYSTEM");
        text.setBounds(180, 20, 600, 40);
        text.setFont(new Font("Ariel", Font.BOLD, 35));
        text.setForeground(Color.white);
        image.add(text);


        JButton button = new JButton("next");
        button.setBounds(650, 450, 150, 50);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.addActionListener(this);
        image.add(button);

        setVisible(true);
        setSize(900, 565);
        setLocation(300, 50);



      /*  while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch (Exception e){

            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch (Exception e){

            }
        } */

        }
        public void actionPerformed(ActionEvent ae)
        {
            setVisible(false);
            new Loginpage();

        }
        public static void main(String [] args){
            new hotelprojectpgm();
        }

}