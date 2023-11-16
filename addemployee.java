package hotelproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 class addemployee extends JFrame implements ActionListener{

     JLabel labelname,labelage,labelgender,job,salary,phone,email,aadhar;
     JTextField txtname,txtage,txtsalary,txtphone,txtemail,txtaadhar;
     JRadioButton rbmale,rbfemale;
     JButton submit;
     JComboBox jcbox;
    addemployee()
    {

        getContentPane().setBackground(Color.white);
        setLayout(null);


        labelname=new JLabel("NAME");
        labelname.setBounds(70,70,150,30);
        labelname.setFont(new Font("ariel",Font.BOLD,17));
        add(labelname);

        txtname = new JTextField();
        txtname.setBounds(200,70,150,30);
        add(txtname);

         labelage=new JLabel("AGE");
        labelage.setBounds(70,120,150,30);
        labelage.setFont(new Font("ariel",Font.BOLD,17));
        add(labelage);

        txtage = new JTextField();
        txtage.setBounds(200,120,150,30);
        add(txtage);

         labelgender=new JLabel("GENDER");
        labelgender.setBounds(70,180,150,30);
        labelgender.setFont(new Font("ariel",Font.BOLD,17));
        add(labelgender);

         rbmale=new JRadioButton("MALE");
        rbmale.setBounds(200,180,70,18);
        rbmale.setFont(new Font("ariel",Font.BOLD,10));
      rbmale.addActionListener(this);
        add(rbmale);

        rbfemale=new JRadioButton("FEMALE");
        rbfemale.setBounds(270,180,70,18);
        rbfemale.setFont(new Font("ariel",Font.BOLD,10));
       rbfemale.addActionListener(this);
        add(rbfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        job=new JLabel("JOB");
        job.setBounds(70,230,150,30);
        job.setFont(new Font("ariel",Font.BOLD,17));
        add(job);

        String str[]={"Receptionist","Front desk clerks","porter","cleaner","room service"};
        jcbox=new JComboBox(str);
        jcbox.setBounds(200,230,150,18);
       jcbox.setFont(new Font("opensans",Font.BOLD,15));
        add(jcbox);

        salary=new JLabel("SALARY");
        salary.setBounds(70,280,150,30);
        salary.setFont(new Font("ariel",Font.BOLD,17));
        add(salary);

         txtsalary = new JTextField();
        txtsalary.setBounds(200,280,150,30);
        add(txtsalary);

        phone=new JLabel("PHONE");
        phone.setBounds(70,330,150,30);
        phone.setFont(new Font("ariel",Font.BOLD,17));
        add(phone);

         txtphone = new JTextField();
        txtphone.setBounds(200,330,150,30);
        add(txtphone);

        email=new JLabel("EMAIL");
        email.setBounds(70,380,150,30);
        email.setFont(new Font("ariel",Font.BOLD,17));
        add(email);

         txtemail = new JTextField();
        txtemail.setBounds(200,380,150,30);
        add(txtemail);

        aadhar=new JLabel("AADHAR");
        aadhar.setBounds(70,430,150,30);
        aadhar.setFont(new Font("ariel",Font.BOLD,17));
        add(aadhar);

         txtaadhar = new JTextField();
        txtaadhar.setBounds(200,430,150,30);
        add(txtaadhar);

         submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setBounds(270,480,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/employeesimg.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,455,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 700, 400);
        add(image);


        setSize(1000,600);
        setTitle("addemployee");
        setLocation(250,100);
        setVisible(true);

    }
   public void actionPerformed(ActionEvent ae) {
       String name = txtname.getText();
       String age = txtage.getText();
       String salary = txtsalary.getText();
       String phone = txtphone.getText();
       String email = txtemail.getText();
       String aadhar = txtaadhar.getText();
       String gender = null;
       if(rbmale.isSelected())
       {
           gender="male";
       } else if (rbfemale.isSelected()) {
           gender="female";
       }
       String job = (String) jcbox.getSelectedItem();



       if (ae.getSource() == submit) {
           try {
               conn Conn = new conn();
               String query = "insert into addemployee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "')";

               Conn.s.executeUpdate(query);

               JOptionPane.showMessageDialog(null, "EMPLOYEE ADDED SUCCESSFULLY");
               setVisible(true);
           }
           catch (Exception a) {
               a.printStackTrace();
           }

       }
   }

    public static void main(String[] args) {
        addemployee obj=new addemployee();
    }
}
