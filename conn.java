package hotelproject;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
  public class conn {
      Connection c;
      Statement s;
    conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","Sasidhar@123");
            s =c.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

