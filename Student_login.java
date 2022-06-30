package Exam_Management_System;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;

public class Student_login extends JFrame{
	
	JLabel l1,l2,image;
	JTextField t1,t2;
	JButton b1;
	Font f=new Font("Serief",Font.BOLD,15);
	Student_login()
	{
		setTitle("Student Login");
		setBounds(400,50,900,700);
		setLayout(null);
		
		Container c=getContentPane();
		c.setBackground(Color.cyan);
		
		ImageIcon icon=new ImageIcon("C://Users/Sangita/eclipse-workspace/Class_programs/src/Exam_Management_System/Image/result2.jpg");
		image=new JLabel(icon);
		image.setBounds(0,0,900,700);
		add(image);
		
		
		image.add(l1=new JLabel("Enter the Student Id"));
		l1.setBounds(100,140,160,90);
		l1.setFont(f);
		add(t1=new JTextField(20));
		t1.setBounds(300,160,200,30);
		t1.setFont(f);
		
		image.add(l2=new JLabel("Enter the password"));
		l2.setBounds(100,220,160,90);
		l2.setFont(f);
		add(t2=new JTextField(20));
		t2.setBounds(300,250,200,30);
		t2.setFont(f);
		
		image.add(b1=new JButton("Submit"));
		b1.setBounds(120,340,120,40);
		
		btn_click ob =new btn_click();
		b1.addActionListener(ob);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
	}		
	class btn_click implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
			
			String id=t1.getText();			
			int idd=Integer.parseInt(id);			
													
			if(b==b1)
			{
			try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost/exam_management_system";
					String username="root";
					String password="";
						
					Connection con=DriverManager.getConnection(url,username,password);
					
					if(con!=null)
					{
							PreparedStatement query=con.prepareStatement("select * from student_data where Roll_number=?");							
							query.setString(1,idd+"");
							//query.setString(2,pass+"");
							ResultSet result=query.executeQuery();

							if(t1.getText().isEmpty() || t2.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null,"Id and password both are mandatory");
							}
							else
							{
							if(result.next())
							{
								int d_pass=result.getInt("Password");
								String p=d_pass+"";
								
								if(p.equals(t2.getText()))
								{
									dispose();																
									Exam_home_page ob=new Exam_home_page();
									ob.data_display(idd);								
									Exam_home_page.set_question();
										
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Password is wrong ");
								}
								
															
							}
							else
							{								
								   JOptionPane.showMessageDialog(null,"Id is not found");								
							}
					}	
					}
					else
					{
						JOptionPane.showMessageDialog(null,"database is not connected");
					}
					
			}
			catch(Exception d)
			{
				JOptionPane.showMessageDialog(null,d);
			}								
			}		
		}
		
	}
	public static void main(String[] args)
	{
		new Student_login();
		
	}
}
