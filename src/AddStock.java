import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddStock  extends JFrame implements ActionListener {


    JFrame frame;
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1;


    public AddStock(){

        frame=new JFrame("AddStock Page");
        frame.setLayout(null);

        frame.setSize(500,500);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.blue);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        l1=new JLabel("Enter Stock : ");
        l2=new JLabel("Enter Quantity : ");
        l3=new JLabel("Enter Price : ");

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();


        b1=new JButton("AddStock");
       b1.addActionListener(this);

        l1.setBounds(120,100,120,25);
        l2.setBounds(100,140,120,25);
        l3.setBounds(100,180,120,25);
        t1.setBounds(220,100,120,25);
        t2.setBounds(220,140,120,25);
        t3.setBounds(220,180,120,25);
        b1.setBounds(200,250,120,25);


        frame.add(l1);
        frame.add(t1);

        frame.add(l2);
        frame.add(t2);
        frame.add(l3);
        frame.add(t3);

        frame.add(b1);

    }

    public static void main(String[] args) {
        new AddStock();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b1){
            String stockname=t1.getText().toString();
            int qty= Integer.parseInt(t2.getText().toString());
            int  price=Integer.parseInt(t3.getText().toString());

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
                System.out.println("Connection Established");
                Statement st=cn.createStatement();
                String qry = "insert into stock(stockName,qty,price) VALUES ('"+stockname+"','"+qty+"','"+price+"')";
                int x = st.executeUpdate(qry);

                if (x>0){
                    JOptionPane.showMessageDialog(this, "Stock Added",
                            "MSG",
                            JOptionPane.INFORMATION_MESSAGE);
                    new HomePage();
                    frame.dispose();
                }
                cn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            t1.setText("");
            t2.setText("");
            t3.setText("");

        }

    }
}
