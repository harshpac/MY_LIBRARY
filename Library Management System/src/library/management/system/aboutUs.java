package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;


public class aboutUs extends JFrame implements ActionListener{

	private JPanel contentPane;
        private JButton b4;
        public static void main(String[] args) {
            new aboutUs().setVisible(true);			
	}
    
        public aboutUs() {
            super("About Us");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ico = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/aaa.png"));
        this.setIconImage(ico.getImage());
            setBackground(new Color(34, 38, 41));
            setBounds(500, 250, 700, 500);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/icon.png"));
            this.setIconImage(icon.getImage());
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel l1 = new JLabel("New label");
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/icon.png"));
            Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            l1 = new JLabel(i3);
            l1.setBounds(500, 40, 100, 100);
            contentPane.add(l1);


            JLabel l3 = new JLabel("Library Management");
            l3.setForeground(new Color(97, 137, 47));
            l3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l3.setBounds(80, 60, 750, 55);
            contentPane.add(l3);

            JLabel l4 = new JLabel("Automated Software");
            l4.setForeground(new Color(97, 137, 47));
            l4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
            l4.setBounds(70, 110, 405, 40);
            contentPane.add(l4);
            
            
            JLabel l5 = new JLabel("Using this, we can manage the library issue-return process");
            l5.setForeground(new Color(97, 137, 47));
            l5.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
            l5.setBounds(70, 180, 405, 40);
            contentPane.add(l5);
            
            JLabel l6 = new JLabel("very easily. It's easy to use and can manage accounts for ");
            l6.setForeground(new Color(97, 137, 47));
            l6.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
            l6.setBounds(70, 200, 405, 40);
            contentPane.add(l6);
            
            JLabel l7 = new JLabel("student and librarian separately.");
            l7.setForeground(new Color(97, 137, 47));
            l7.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
            l7.setBounds(70, 220, 405, 40);
            contentPane.add(l7);
            
           
            JLabel l9 = new JLabel("Follow us on Instagram : harshp54");
            l9.setForeground(new Color(97, 137, 47));
            l9.setFont(new Font("Trebuchet MS", Font.BOLD , 20));
            l9.setBounds(70, 320, 600, 34);
            contentPane.add(l9);
            
            b4 = new JButton("Back");
	    b4.addActionListener(this);
	    b4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	    b4.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
	    b4.setBounds(20, 20, 50, 33);
	    b4.setForeground(Color.WHITE);
	    b4.setBackground(new Color(97, 137, 47));
            contentPane.add(b4);
                
            contentPane.setBackground(new Color(34, 38, 41));
        }
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b4){
                this.setVisible(false);
                new Home().setVisible(true);
            }
        }
        

}

