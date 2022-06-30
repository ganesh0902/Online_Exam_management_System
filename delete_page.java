package Exam_Management_System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.sql.*;

public class delete_page extends JFrame{
	
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1,t2,t3,t5,t4,t6,t7,t8,t9,t10,t11;
	
	public static int id=1;
	JPanel p1;
	Font f=new Font("Serief",Font.BOLD,15);
	
	delete_page()
	{
		setTitle("delete Page");
		
		setLayout(null);
		//setBounds(200,10,);
		setSize(1600,800);

		add(l1=new JLabel("Question Id"));
		l1.setBounds(100,50,120,90);
		add(t1=new JTextField(20));
		t1.setBounds(220,85,120,25);
		t1.setFont(f);
		
		add(l2=new JLabel("Question"));
		l2.setBounds(100,120,120,90);
		add(t2=new JTextField(20));
		t2.setBounds(220,150,200,25);
		t2.setFont(f);
		
		
		add(l3=new JLabel("Option 1"));
		l3.setBounds(100,180,120,90);
		add(t3=new JTextField(20));
		t3.setBounds(220,215,200,25);
		t3.setFont(f);
		
		add(l4=new JLabel("Option 2"));
		l4.setBounds(100,250,120,90);
		add(t4=new JTextField(20));
		t4.setBounds(220,290,200,25);
		t4.setFont(f);
		
		add(l5=new JLabel("Option 3"));
		l5.setBounds(100,320,120,90);
		add(t5=new JTextField(20));
		t5.setBounds(220,350,200,25);
		t5.setFont(f);
		
		add(l6=new JLabel("Option 4"));
		l6.setBounds(100,390,120,90);
		add(t6=new JTextField(20));
		t6.setBounds(220,426,200,25);
		t6.setFont(f);
		
							
		add(b1=new JButton("add question"));
		b1.setBounds(10,10,150,50);
		
		add(b2=new JButton("Update question"));
		b2.setBounds(220,10,150,50);
				
		add(b3=new JButton("delete question"));
		b3.setBounds(460,10,150,50);
		
		add(b4=new JButton("All Question "));
		b4.setBounds(720,10,150,50);
		
		add(b5=new JButton("All Student Result"));
		b5.setBounds(960,10,150,50);
		
		add(b8=new JButton("Add new Student"));
		b8.setBounds(1170,10,150,50);
		
		add(b6=new JButton("Exit"));
		b6.setBounds(1370,10,150,50);
		
		add(b7=new JButton("Delete Record")); //when user click delete record button then record will be delete
		b7.setBounds(110,480,120,60);
		
		//ActionListener();
		btn_all ob= new btn_all();
		b1.addActionListener(ob);
		b2.addActionListener(ob);
		b3.addActionListener(ob);
		b4.addActionListener(ob);
		b5.addActionListener(ob);
		b6.addActionListener(ob);
		b7.addActionListener(ob);
		b8.addActionListener(ob);
						
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
	}
	public void delete(String id)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/exam_management_system";
			String username="root";
			String password="";
			
				Connection con=DriverManager.getConnection(url,username,password);
				
				PreparedStatement srt=con.prepareStatement("SELECT * FROM question_save WHERE q_id=?");
				srt.setString(1,id);
				ResultSet res=srt.executeQuery();
				
				while(res.next())
				{
					t1.setText(res.getString(1));
					t2.setText(res.getString(2));
					t3.setText(res.getString(3));
					t4.setText(res.getString(4));
					t5.setText(res.getString(5));
					t6.setText(res.getString(6));										
				}
			
		}
		catch(Exception d)
		{
			System.out.println(d);
		}
		
		
		
		
	}
	class btn_all implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
			
			if(b==b1)
			{
				dispose();
				add_data ob=new add_data();
				ob.id_update();
				
			}
			if(b==b2)
			{
				dispose();
				new Update_page();
			}
			if(b==b3)
			{
				JOptionPane.showMessageDialog(null,"You are in delete page");
			}
			if(b==b4)
			{
				dispose();
				new display_data();
			}
			if(b==b5)
			{
				dispose();
				new Student_result();
			}
			if(b==b6)
			{
				
				System.exit(0);
			}
			if(b==b8)
			{
				dispose();
				new Student_result();
				
			}
			if(b==b7)
			{
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/exam_management_system";
				String username="root";
				String password="";
				
				Connection con=DriverManager.getConnection(url,username,password);
				Statement st=con.createStatement();
				
				String id=t1.getText();
				
				String del="delete from question_save where q_id='"+id+"'";
				st.executeUpdate(del);
											
				JOptionPane.showMessageDialog(null,"Record deleted successfully");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				dispose();
				new Admin_home();
				add_data.id_update();
			}
			catch(Exception d)
			{
				
				System.out.println(d);
			}
			
			}		
		}
		
	}
	public static void main(String[] args)
	{
		
		new delete_page();
	}
}


