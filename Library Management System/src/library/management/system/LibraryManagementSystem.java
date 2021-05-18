package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener{

        JLabel l1;
        JPanel h;
        JButton b1;
        JButton b2;
        public static int student = 0;
        public LibraryManagementSystem() {
		super("My Library");
                setSize(766,390);
                setLayout(null);
                setLocation(300,300);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/aaa.png"));
                this.setIconImage(icon.getImage());
                JLabel head = new JLabel("My Library");
		l1 = new JLabel("");
                b1 = new JButton("Librarian Login");
                b2 = new JButton("Student Login");
                b1.setBackground(new Color(97, 137, 47));
                b1.setForeground(Color.WHITE);
		b2.setBackground(new Color(97, 137, 47));
                b2.setForeground(Color.WHITE);	
                h = new JPanel();
                h.add(head);
                this.add(h);
                
                l1 = new JLabel();
                l1.setBounds(350,150,850,433);
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/aaa.png"));
                Image i3 = i1.getImage().getScaledInstance(110, 110,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l2 = new JLabel("    My Library");
                l2.setForeground(Color.WHITE);
                l2.setBounds(150,0,450,190);
                l2.setFont(new Font("Segoe UI Semilight", Font.BOLD, 50));
                l2.setIcon(i2);
                add(l2);
                b1.setBounds(170,200,120,60);
		l1.setBounds(0, 0, 1366, 390);
                b2.setBounds(440,200,120,60);
                l1.add(b1);
                l1.add(b2);
		add(l1);
                b1.addActionListener(this);
                b2.addActionListener(this);
                
                getContentPane().setBackground(new Color(34, 38, 41));
                h.setBackground(Color.WHITE);
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==b1){
                this.setVisible(false);
                this.student = 0;
                System.out.println("teacher");
                System.out.println(student);
                new Login_user().setVisible(true);
            }
            else {
                this.setVisible(false);
                this.student = 1;
                System.out.println("student");
                new StudentLogin().setVisible(true);
            }
        }
        
        public static void main(String[] args) {
                LibraryManagementSystem window = new LibraryManagementSystem();
                window.setVisible(true);			
	}
}
