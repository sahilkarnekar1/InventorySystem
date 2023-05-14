import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage implements ActionListener {

    JFrame frame;
    JMenuBar bar;
    JMenu stock;
    JMenuItem addstock;


    public  HomePage(){
        frame=new JFrame("Home Page");
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.setSize(500,500);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.blue);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addstock=new JMenuItem("AddStock");
        stock=new JMenu("Stock");
        stock.add(addstock);
        bar=new JMenuBar();
        bar.add(stock);
        addstock.addActionListener(this);
        frame.add(bar);


    }

    public static void main(String[] args) {
        new HomePage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addstock){
            frame.dispose();
            new AddStock();
        }
    }
}
