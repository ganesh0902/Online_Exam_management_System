package Exam_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class display_data extends JFrame{

		
		JTable table;
		DefaultTableModel model;
		JButton b1;
	
	display_data()
	{
		try {
			//setLayout(new FlowLayout());
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/exam_management_system";
			String username="root";
			String password="";
			
			add(b1=new JButton("Back"));
			b1.setBounds(780,570,90,30);
			b1.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e)
				{
					dispose();
					new Admin_home();
					
				}
				
			});
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			 model=new DefaultTableModel();
			 model.addColumn("id");
			 model.addColumn("question");
			 model.addColumn("option_1");
			 model.addColumn("option_2");
			 model.addColumn("option_3");
			 model.addColumn("ans");
			 model.addColumn("Marks");
			 
			 table=new JTable(model);
			 add(table);
			
			 add(new JScrollPane(table));
			 			
			String query="select * from question_save";
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet result=ps.executeQuery();
			
			while(result.next())
			{
								
				Vector ob=new Vector();
				ob.add(result.getInt(1));
				ob.add(result.getString(2));
				ob.add(result.getString(3));
				ob.add(result.getString(4));
				ob.add(result.getString(5));
				ob.add(result.getString(6));
				ob.add(result.getInt(7));
			
				model.addRow(ob);
				
			}
			//setSize(800,800);
			setBounds(370,50,900,700);
			setVisible(true);
			setLayout(null);
			
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		catch(Exception e)
		{
			
			System.out.println(e);
		}
		
	}		
	public static void main(String[] args)
	{
			new display_data();
	}

}
