package Exam_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
public class Student_account extends JFrame implements ActionListener{
	
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,image;
	JTextField tf0,tf1,tf2,tf3,tf4,tf5,tf6;
	JButton b1,b2;
	Font f=new Font("Serief",Font.BOLD,16);
	
	Student_account()
	{
		setTitle("Account Page");		
		setBounds(300,30,900,700);
		setLayout(null);
		
		//Container c=getContentPane();
		//c.setBackground(Color.cyan);
		
		ImageIcon icon=new ImageIcon("C://Users/Sangita/eclipse-workspace/Class_programs/src/Exam_Management_System/Image/addStudent.jpg");
		image=new JLabel(icon);
		image.setBounds(0,0,900,700);
		add(image);
		
		image.add(l0=new JLabel("Student roll number"));
		l0.setBounds(150,15,160,30);
		l0.setFont(f);
		
		add(tf0=new JTextField(20));
		tf0.setBounds(380,25,200,25);
		tf0.setFont(f);
		
		image.add(l1=new JLabel("Student first name"));
		l1.setBounds(150,65,160,50);
		l1.setFont(f);
		add(tf1=new JTextField(20));
		tf1.setBounds(380,85,200,25);
		tf1.setFont(f);
		
		image.add(l2=new JLabel("Student middle name"));
		l2.setBounds(150,130,160,50);
		l2.setFont(f);
		add(tf2=new JTextField(20));
		tf2.setBounds(380,145,200,25);
		tf2.setFont(f);
		
		image.add(l3=new JLabel("Student last name"));
		l3.setBounds(150,200,160,50);
		l3.setFont(f);
		add(tf3=new JTextField(20));
		tf3.setBounds(380,215,200,25);
		tf3.setFont(f);
		
		image.add(l4=new JLabel("Student email id"));
		l4.setBounds(150,280,160,50);
		l4.setFont(f);
		
		add(tf4=new JTextField(20));
		tf4.setBounds(380,295,200,25);
		tf4.setFont(f);
		
		image.add(l5=new JLabel("Student password"));
		l5.setBounds(150,360,160,50);
		l5.setFont(f);
		add(tf5=new JTextField(20));
		tf5.setBounds(380,375,200,25);
		tf5.setFont(f);
		
		image.add(l6=new JLabel("Student college name"));
		l6.setBounds(150,440,180,50);
		l6.setFont(f);
		add(tf6=new JTextField(20));
		tf6.setBounds(380,455,200,25);
		tf6.setFont(f);
		
		image.add(b1=new JButton("Submit"));
		b1.setBounds(150,560,90,30);
		b1.addActionListener(this);
		
		image.add(b2=new JButton("Back"));
		b2.setBounds(280,560,90,30);
		b2.addActionListener(this);
			
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		try {
				JButton b=(JButton)e.getSource();
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/exam_management_system";
				String username="root";
				String password="";
				Connection con=DriverManager.getConnection(url,username,password);
				
			if(b==b1)
			{
				String id=tf0.getText();
				String fname=tf1.getText();
				String mname=tf2.getText();
				String lname=tf3.getText();
				String email=tf4.getText();
				String pass=tf5.getText();
				String cname=tf6.getText();
				
				if(id.equals("") || fname.equals("") || mname.equals("") || lname.equals("") || email.equals("") || pass.equals("") || cname.equals(""))
				{
				
					JOptionPane.showMessageDialog(null,"All field are mandatory");
				}
				else
				{
						PreparedStatement pr=con.prepareStatement("insert into student_data values(?,?,?,?,?,?,?,?)");
						pr.setString(1,id);
						pr.setString(2,fname);
						pr.setString(3,mname);
						pr.setString(4,lname);
						pr.setString(5,email);
						pr.setString(6,pass);
						pr.setString(7,cname);
						pr.setString(8,0+"");
						pr.executeUpdate();
						
						JOptionPane.showMessageDialog(null,"data inserted successfully");
						tf0.setText("");
						tf1.setText("");
						tf2.setText("");
						tf3.setText("");
						tf4.setText("");
						tf5.setText("");
						tf6.setText("");						
				}				
			}	
			if(b==b2)
			{
				dispose();
				new Admin_home();
			}
		}
		catch(Exception d)
		{
			//JOptionPane.showMessageDialog(null,d);
			System.out.print(d);
		}
	}
	
	public static void main(String[] args)
	{
		new Student_account();
	}
}
