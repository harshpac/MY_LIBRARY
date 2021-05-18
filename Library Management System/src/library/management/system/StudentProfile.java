/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

/**
 *
 * @author Harshit
 */
public class StudentProfile extends JFrame implements ActionListener  {
    
    private JPanel panel;
    private JButton b1, b2, b3;
    // personal info
    public static String course, branch, year, semester, name, fetchedId;
    private int idd;
    
    public StudentProfile(){
        
    }
     
    public StudentProfile(String id, String name, String course, String branch, String semester, String year){
        super("Profile");
        this.fetchedId = id;
        this.name = name;
        this.course = course;
        this.branch = branch;
        this.semester = semester;
        this.year = year;
        // now all values are filled;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/aaa.png"));
        this.setIconImage(icon.getImage());

        setBackground(new Color(34, 38, 41));	
        setBounds(600, 300, 600, 400);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        panel = new JPanel();
	panel.setBackground(new Color(34, 38, 41));
       	setContentPane(panel);
      	panel.setLayout(null);
        
	JLabel l1 = new JLabel("ID :  " + fetchedId);
	l1.setBounds(210, 0, 200, 34);
        l1.setFont(new Font("Sans Serif", Font.BOLD, 12));
        l1.setForeground(new Color(97, 137, 47));
	panel.add(l1);

  
	JLabel l2 = new JLabel("NAME :  "+ name);
	l2.setBounds(210, 20, 206, 34);
        l2.setFont(new Font("Sans Serif", Font.BOLD, 12));
        l2.setForeground(new Color(97, 137, 47));
	panel.add(l2);


  
	JLabel l3 = new JLabel("COURSE :  "+course);
       	l3.setBounds(210, 40, 206, 34);
        l3.setFont(new Font("Sans Serif", Font.BOLD, 12));
        l3.setForeground(new Color(97, 137, 47));
        panel.add(l3);
  
       	JLabel l4 = new JLabel("BRANCH :  "+branch);
       	l4.setBounds(210, 60, 206, 34);
        l4.setFont(new Font("Sans Serif", Font.BOLD, 12));
        l4.setForeground(new Color(97, 137, 47));
      	panel.add(l4);
        


  
	JLabel l5 = new JLabel("YEAR :  "+year);
       	l5.setBounds(210, 80, 206, 34);
        l5.setFont(new Font("Sans Serif", Font.BOLD, 12));
        l5.setForeground(new Color(97, 137, 47));
	panel.add(l5);

  
	JLabel l6 = new JLabel("SEMESTER :  "+semester);
       	l6.setBounds(210, 100, 206, 34);
        l6.setFont(new Font("Sans Serif", Font.BOLD, 12));
        l6.setForeground(new Color(97, 137, 47));
      	panel.add(l6);
        
        b1 = new JButton("Books in Library");
        b1.setBackground(new Color(97, 137, 47));
        b1.setForeground(Color.WHITE);
      	b1.setBounds(80, 241, 130, 39);
        b1.addActionListener(this);
      	panel.add(b1);
        
        
        b2 = new JButton("Books Issued");
        b2.setBackground(new Color(97, 137, 47));
        b2.setForeground(Color.WHITE);
      	b2.setBounds(350, 241, 130, 39);
        b2.addActionListener(this);
      	panel.add(b2);
        
        b3 = new JButton("Logout");
        b3.setBackground(new Color(97, 137, 47));
        b3.setForeground(Color.WHITE);
      	b3.setBounds(10, 10, 85, 39);
        b3.addActionListener(this);
      	panel.add(b3);
        
          // System.out.println(myId);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
          this.setVisible(false);
          new BookDetails().setVisible(true);
        }
        if(ae.getSource() == b2){
            this.setVisible(false);
            new MyIssuedBooks().setVisible(true);
        } 
        if(ae.getSource() == b3){
            this.setVisible(false);
            new StudentLogin().setVisible(true);
        }
    }
    
    public static void main(String []args){
      new StudentProfile(fetchedId, name, course, branch, semester, year).setVisible(true);
    }   
}
