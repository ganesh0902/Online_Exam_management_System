package Exam_Management_System;


import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.sql.*;

public class Update_page extends JFrame{
	
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,image;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	
	public static int id=1;
	JPanel p1;
	
	Font f=new Font("Serief",Font.BOLD,15);
	Container c=getContentPane();
	
	
	Update_page()
	{
		setTitle("Update Page");
		
		setLayout(null);
		//setBounds(200,10,);
		setSize(1600,800);
		
		ImageIcon icon=new ImageIcon("C://Users/Sangita/eclipse-workspace/Class_programs/src/Exam_Management_System/Image/addStudent.jpg");
		image=new JLabel(icon);
		image.setBounds(0,0,1600,800);
		add(image);
						
		image.add(l1=new JLabel("Question Id"));
		l1.setBounds(100,50,120,90);
		l1.setFont(f);				
		l1.setForeground(Color.black);
		
		image.add(l12=new JLabel());
		l12.setBounds(220,85,120,25);
		l12.setFont(f);
		
		image.add(l2=new JLabel("Question"));
		l2.setBounds(100,120,120,90);
		l2.setFont(f);
		l2.setForeground(Color.black);
		add(t2=new JTextField(20));
		t2.setBounds(220,150,200,25);
		t2.setFont(f);
		
		image.add(l3=new JLabel("Option 1"));
		l3.setBounds(100,180,120,90);
		l3.setFont(f);
		l3.setForeground(Color.black);
		
		add(t3=new JTextField(20));
		t3.setBounds(220,215,200,25);
		t3.setFont(f);
		
		image.add(l4=new JLabel("Option 2"));
		l4.setBounds(100,250,120,90);
		l4.setFont(f);
		l4.setForeground(Color.black);
		add(t4=new JTextField(20));
		t4.setBounds(220,290,200,25);
		t4.setFont(f);
		
		image.add(l5=new JLabel("Option 3"));
		l5.setBounds(100,320,120,90);
		l5.setFont(f);
		l5.setForeground(Color.black);
		add(t5=new JTextField(20));
		t5.setBounds(220,350,200,25);
		t5.setFont(f);
		
		image.add(l6=new JLabel("Write Answer"));
		l6.setBounds(100,390,120,90);
		l6.setFont(f);
		l6.setForeground(Color.black);
		add(t6=new JTextField(20));
		t6.setBounds(220,426,200,25);
		t6.setFont(f);
		
		image.add(b8=new JButton("Update Record"));
		b8.setBounds(110,480,120,60);
						
		image.add(b1=new JButton("add question"));
		b1.setBounds(10,10,150,50);
		
		image.add(b2=new JButton("Update question"));
		b2.setBounds(225,10,150,50);
				
		image.add(b3=new JButton("delete question"));
		b3.setBounds(440,10,150,50);
		
		image.add(b4=new JButton("All Question "));
		b4.setBounds(660,10,150,50);
		
		image.add(b5=new JButton("All Student Result"));
		b5.setBounds(900,10,150,50);
		
		image.add(b6=new JButton("Add new Student"));
		b6.setBounds(1150,10,150,50);
		
		image.add(b7=new JButton("Exit"));
		b7.setBounds(1350,10,150,50);
		
		
		
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
	public void display(String id2)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/exam_management_system";
			String username="root";
			String password="";
			
				Connection con=DriverManager.getConnection(url,username,password);
				
				PreparedStatement srt=con.prepareStatement("SELECT * FROM question_save WHERE q_id=?");
				srt.setString(1,id2);
				ResultSet rs=srt.executeQuery();
				while(rs.next())
				{
					
					l12.setText(rs.getString(1));
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					t4.setText(rs.getString(4));
					t5.setText(rs.getString(5));
					t6.setText(rs.getString(6));
															
				}
			
		}
		catch(Exception d)
		{}
		
	}
	class btn_all implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/exam_management_system";
			String username="root";
			String password="";
			
			Connection con=DriverManager.getConnection(url,username,password);
			if(b==b1)
			{
				dispose();
				add_data ob	=new add_data();
				ob.id_update();
								
			}
			if(b==b2)
			{
				JOptionPane.showMessageDialog(null,"You are in update page");
			}
			if(b==b3)
			{
				dispose();
				new delete_page();
				
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
				dispose();
				new Student_account();
 				
			}
			if(b==b7)
			{
				System.exit(0);
			}
			if(b==b8)
			{
				//String q=t1.getText();
				String q=l12.getText();
				String q1=t2.getText();
				String q2=t3.getText();
				String q3=t4.getText();
				String q4=t5.getText();
				String q5=t6.getText();
			
				Statement st=con.createStatement();
			String udate="UPDATE question_save  set question='"+q1+"',option_1='"+q2+"',option_2='"+q3+"',option_3='"+q4+"',right_ans='"+q5+"' WHERE q_id='"+q+"'";
			int i=st.executeUpdate(udate);
							
			if(i==0)
			{
				JOptionPane.showMessageDialog(null,"Data does not update successfully");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Data update successfully");
			}
			
			//t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			dispose();
			new Admin_home();						
			}
	
		}	
		catch(Exception d)
		{
			
			JOptionPane.showMessageDialog(null,d);
		}
		
		}
		
	}
	public static void main(String[] args)
	{
		
		new Update_page();
	}
}

