/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

/**
 *
 * @author Harshit
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class StudentLogin extends JFrame implements ActionListener{
    
        private JPanel panel;
	private JTextField textField;
        private JButton b1, b2;
        private static String myId;
        String name, course, year, branch, semester;
        public String getId() {
            return this.myId;
        }
        
        public StudentLogin() {
        super("Student Login");    
        setBackground(new Color(34, 38, 41) );	
        setBounds(600, 300, 600, 400);
		
        panel = new JPanel();
	panel.setBackground(new Color(34, 38, 41));
	setContentPane(panel);
	panel.setLayout(null);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/aaa.png"));
        this.setIconImage(icon.getImage());
        

	JLabel l1 = new JLabel("Enter your ID ");
        l1.setForeground(Color.WHITE);
	l1.setBounds(124, 89, 95, 24);
	panel.add(l1);
        

	textField = new JTextField();
	textField.setBounds(210, 93, 157, 20);
	panel.add(textField);


	JLabel l3 = new JLabel("");
	l3.setBounds(377, 79, 46, 34);
	panel.add(l3);

	JLabel l4 = new JLabel("");
	l4.setBounds(377, 124, 46, 34);
	panel.add(l3);

	b1 = new JButton("Login");
	b1.addActionListener(this);
        
        b2 = new JButton("Back");
        
        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new LibraryManagementSystem().setVisible(true);
            }
	});
        
        b2.setForeground(Color.WHITE);
	b2.setBackground(new Color(97, 137, 47));
	b2.setBounds(10, 10, 70, 39);
	panel.add(b2);
        
        b1.setForeground(Color.WHITE);
	b1.setBackground(new Color(97, 137, 47));
	b1.setBounds(240, 121, 100, 39);
	panel.add(b1);
        
        
          // System.out.println(myId);
	

		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(34, 38, 41) );
		panel2.setBounds(24, 40, 434, 263);
		panel.add(panel2);
        }
        
        
        public void actionPerformed(ActionEvent ae){
           myId = textField.getText();
           
           try {
                    conn con = new conn();
                    String sql = "select * from student where student_id = ?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, myId);

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.name = (rs.getString("name"));
                        this.course = (rs.getString("course"));
                        this.branch = (rs.getString("branch"));
                        this.year = (rs.getString("year"));
                        this.semester = (rs.getString("semester"));
                        this.setVisible(false);
                        new StudentProfile(myId, name, course, branch, semester, year).setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "ID Not Found, Please contact the Librarian!");
                       
		} catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "Network Error");
                    e2.printStackTrace();
		} 
        }
        
        public static void main(String[] args) {
                new StudentLogin().setVisible(true);
	}
}
