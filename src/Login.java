import javax.naming.Context;
import javax.security.auth.login.LoginContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JFrame frame;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1;
    public Login(){
        frame=new JFrame("Login Form");
        frame.setLayout(null);

        frame.setSize(500,500);
        frame.setVisible(true);
    frame.getContentPane().setBackground(Color.blue);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    l1=new JLabel("Enter Username : ");
    l2=new JLabel("Enter Password : ");

    t1=new JTextField();
    p1=new JPasswordField();

    b1=new JButton("Login");
        b1.addActionListener(Login.this);

    l1.setBounds(100,100,120,25);
    t1.setBounds(220,100,120,25);
    l2.setBounds(100,130,120,25);
    p1.setBounds(220,130,120,25);

    b1.setBounds(180,180,120,25);


    frame.add(l1);
    frame.add(t1);

    frame.add(l2);
    frame.add(p1);

    frame.add(b1);

    }


    public static void main(String[] args) {

        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String username=t1.getText().toString();
            String password=p1.getText().toString();
            if (username.equals("admin") && password.equals("admin")){

                frame.dispose();
                new HomePage();
            }else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials ",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                t1.setText("");
                p1.setText("");
            }
        }
    }
}
