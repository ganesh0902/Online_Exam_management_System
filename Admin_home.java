package Exam_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.sql.*;

public class Admin_home extends JFrame{
	
	JButton b1,b2,b3,b4,b5,b6,b7;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,image;
	JTextField t1,t2,t3,t4,t6,t7,t8,t9,t10,t11;
	
	
	public static int id=1;
	JPanel p1;
	Admin_home()
	{
		setTitle("Admin Home Page");
		
		setLayout(null);
		//setBounds(200,10,);
		setSize(1600,800);
		
		ImageIcon icon=new ImageIcon("C://Users/Sangita/eclipse-workspace/Class_programs/src/Exam_Management_System/Image/admin_home1.jpg");
		image=new JLabel(icon);
		image.setBounds(0,0,1700,800);
		add(image);
				
		image.add(b1=new JButton("add question"));
		b1.setBounds(10,10,150,50);
		
		image.add(b2=new JButton("Update question"));
		b2.setBounds(230,10,150,50);
				
		image.add(b3=new JButton("delete question"));
		b3.setBounds(450,10,150,50);
		
		image.add(b4=new JButton("All Question "));
		b4.setBounds(690,10,150,50);
		
		image.add(b5=new JButton("All Student Result"));
		b5.setBounds(940,10,150,50);
		
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
						
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
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
					add_data ob=new add_data();
					ob.id_update();
				}
				if(b==b2)
				{

					String id=JOptionPane.showInputDialog("Enter the question ID ");
					PreparedStatement pr=con.prepareStatement("SELECT * FROM question_save WHERE q_id=?");
					pr.setString(1,id);
					ResultSet result=pr.executeQuery();
				
					if(result.next())
					{
						dispose();
						Update_page ud=new Update_page();
						ud.display(id);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"ID is not avaialable");
					}
					
				}
				if(b==b3)
				{			
						String id=JOptionPane.showInputDialog("Enter the question ID ");	
						PreparedStatement pr=con.prepareStatement("SELECT * FROM question_save WHERE q_id=?");
						pr.setString(1,id);
						ResultSet res=pr.executeQuery();
					
						if(res.next())
						{
							dispose();
							delete_page ob=new delete_page();
							ob.delete(id);
					 }
					else
					{
							JOptionPane.showMessageDialog(null,"Id is  not FOund");
					}
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
			}
			catch(Exception d)
			{
				JOptionPane.showMessageDialog(null,d);
				System.out.println(d);
			}
			
		}
		
	}
	public static void main(String[] args)
	{		
		new Admin_home();
	}
}
