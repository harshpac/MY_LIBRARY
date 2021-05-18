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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import net.proteanit.sql.DbUtils;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.text.*;
import java.util.Date;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;

/**
 *
 * @author Harshit
 */
public class MyIssuedBooks extends JFrame{
    private JPanel contentPane;
    private JTable table;
    private JTable table_1;
    
     public static void main(String []args){
        new MyIssuedBooks().setVisible(true);
            Date today=new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
            //LocalDateTime now = LocalDateTime.now();  
          // System.out.println(dtf.format(now)); 
           // long ltime=today.getTime()+10*24*60*60*1000;
           // Date today8=new Date(ltime);
            //today8 =  sdformat.format(today8)
           // System.out.println(sdformat.format(today8));
           try{
	   //Setting the date to the given date
	   String dd = "18-05-2021";
            Date d1 = sdf.parse(dd);
            System.out.println(d1);
	  }catch(ParseException e){
		e.printStackTrace();
	    } 
            
            
            
    }
    public void checkIssued(){
        try {
            StudentProfile pp = new StudentProfile();
            conn con = new conn();
            String sql = "select * from issuebook where student_id = ?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, pp.fetchedId);
            ResultSet rs = st.executeQuery();
           // while(rs.next()){
            table.setModel(DbUtils.resultSetToTableModel(rs));
         //   }
            rs.close();
            st.close();
            con.c.close();
	} catch (Exception e) {
	JOptionPane.showMessageDialog(null, "Network Error");
	}
    }
    
    public void checkReturn() {
        
        try {
            SimpleDateFormat sdformat = new SimpleDateFormat("dd-MMM-yyyy");
            StudentProfile pp = new StudentProfile();
            conn con = new conn();
            String sql = "select * from issuebook where student_id = ?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, pp.fetchedId);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
            String d = rs.getString("dateOfIssue");
            Date today=new Date();
            Date xx = sdformat.parse(d);
            long ltime=xx.getTime()+10*24*60*60*1000;
            Date today8 = new Date(ltime);
            if(today8.compareTo(today)<0){
                System.out.println(today8);
                System.out.println(today);
                table_1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            }
            rs.close();
            st.close();
            con.c.close();
	} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Network Error");
	   System.out.println(e);
	}
        
    }
    
    public MyIssuedBooks() {
        super("My Books");
        setBounds(400, 200, 810, 594);
	contentPane = new JPanel();
        contentPane.setBackground(new Color(34, 38, 41));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/aaa.png"));
        this.setIconImage(icon.getImage());
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(40, 51, 708, 217);
	contentPane.add(scrollPane);

        table = new JTable();
	table.setBackground(new Color(224, 255, 255));
	table.setForeground(new Color(128, 128, 0));
	table.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	scrollPane.setViewportView(table);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(97, 137, 47), 1, true), "Books Issued by You",
	TitledBorder.LEADING, TitledBorder.TOP, null, new Color(97, 137, 47)));
	panel.setForeground(new Color(0, 128, 128));
	panel.setBounds(26, 36, 737, 240);
        panel.setBackground(new Color(34, 38, 41));
	contentPane.add(panel);

	JLabel l1 = new JLabel("Back");
	l1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
		setVisible(false);
		StudentProfile sp = new StudentProfile();
		new StudentProfile(sp.fetchedId, sp.name, sp.course, sp.branch, sp.semester, sp.year).setVisible(true);
            }
	});
	l1.setForeground(new Color(97, 137, 47));
	l1.setFont(new Font("Tahoma", Font.BOLD, 18));
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/tenth.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1.setIcon(i3);
	l1.setBounds(10, 5, 96, 27);
	contentPane.add(l1);

	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(40, 316, 717, 217);
	contentPane.add(scrollPane_1);

	table_1 = new JTable();
	table_1.setBackground(new Color(204, 255, 255));
	table_1.setForeground(new Color(153, 51, 0));
	table_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
	scrollPane_1.setViewportView(table_1);

	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new TitledBorder(new LineBorder(new Color(97, 137, 47), 1, true), "Passed Due Date",
	TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(97, 137, 47)));
	panel_1.setBounds(22, 299, 741, 240);
        panel_1.setBackground(new Color(34, 38, 41));
	contentPane.add(panel_1);
        

	checkIssued();
        checkReturn();
    }
}
