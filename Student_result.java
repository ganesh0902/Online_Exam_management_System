package Exam_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.Vector;

	
public class Student_result extends JFrame implements ActionListener{
	
	DefaultTableModel model;
	JTable table;
	JButton b1;
	Student_result()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost/exam_management_system";
			String username="root";
			String password="";
			
			add(b1=new JButton("Back"));
			b1.setBounds(750,630,120,30);
			b1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					dispose();
					new Admin_home();
					
				}																
			});
			
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			model=new DefaultTableModel();
			model.addColumn("roll_number");
			model.addColumn("forst_name");
			model.addColumn("middle_name");
			model.addColumn("last_name");
			model.addColumn("email id");
			model.addColumn("Password");
			model.addColumn("college");
			model.addColumn("Result");
			
			table = new JTable(model);			
			add(new JScrollPane(table));
			
			PreparedStatement st=con.prepareStatement("select * from student_data");
			
			ResultSet result=st.executeQuery();
			
			while(result.next())
			{
				Vector ob=new Vector();
				ob.add(result.getInt(1));
				ob.add(result.getString(2));
				ob.add(result.getString(3));
				ob.add(result.getString(4));
				ob.add(result.getString(5));
				ob.add(result.getString(6));
				ob.add(result.getString(7));
				ob.add(result.getInt(8));
				
				model.addRow(ob);
				
			}					
		}
		catch(Exception d)
		{
			JOptionPane.showMessageDialog(null,d);
		}
		setTitle("data display");
		
		setBounds(100,20,1300,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
	}	
	public static void main(String[] args)
	{
		
		
		new Student_result();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
		new Admin_home();
		
	}
}

		