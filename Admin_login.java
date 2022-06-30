package Exam_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.io.*;


public class Admin_login extends JFrame{
	
	JButton b1;
	JLabel l1,l2,image;
	JTextField t1,t2;
	Font f=new Font("Serief",Font.BOLD,15);
	
	Admin_login()
	{		
			setTitle("Login page");
			
			setBounds(380,20,800,500);
			setLayout(null);
			
			ImageIcon icon=new ImageIcon("C://Users/Sangita/eclipse-workspace/Class_programs/src/Exam_Management_System/Image/admin.jpg");
			image=new JLabel(icon);
			image.setBounds(0,0,900,700);
			add(image);
			Font f=new Font("Sans-serief",15,18);
			
			
			
			image.add(l1=new JLabel("Enter ID "));
			l1.setBounds(120,125,150,30);
			l1.setFont(f);
			
			add(t1=new JTextField(20));
			t1.setBounds(280,130,200,26);
			t1.setFont(f);
			
			image.add(l2=new JLabel("Enter password"));
			l2.setBounds(120,200,130,30);
			l2.setFont(f);
			add(t2=new JTextField(20));
			t2.setBounds(280,200,200,26);
			t2.setFont(f);
			
			image.add(b1=new JButton("Submit"));
			b1.setBounds(120,270,100,40);
			
			//actionlistener
			btn_submit ob=new btn_submit();
			b1.addActionListener(ob);
			
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	class btn_submit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
			if(b==b1)
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/exam_management_system";
					String username="root";
					String password="";
					
					String id=t1.getText();
					String pass=t2.getText();
					
					Connection con=DriverManager.getConnection(url,username,password);
															
					if(con!=null)
					{
						PreparedStatement st=con.prepareStatement("SELECT * FROM admin_login WHERE admin_id=?");
						st.setString(1,id);
						
						ResultSet result=st.executeQuery();
						if(result.next())
						{	
								String pas=result.getString("Password");
								if(pas.equals(t2.getText()))
								{
									dispose();							
									new Admin_home();
								}
								else
								{
									JOptionPane.showMessageDialog(null,"password is incurrect");
								}
							  
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Admin id is not found");
						}						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"database not connected");
					}
				}
				catch(Exception d)
				{
					
					
				}
			}
				
		}				
	} 
	public static void main(String[] args)
	{
		new Admin_login();
		
	}

}
