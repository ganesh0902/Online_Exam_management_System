package Exam_Management_System;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.Timer;
//import java.util.Timer;
import java.awt.event.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;


public class Exam_home_page extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3;
	static JLabel l4;
	JLabel l5;
	static JLabel l6;
	JLabel l7;
	JLabel l8;
	JLabel l9;
	static JLabel l10;
	JLabel l11;
	static JLabel l12;
	static JLabel l13;
	JLabel l14;
	static JLabel l15;
	static JLabel l16;
	JLabel l17;
	static JLabel l18;
	JLabel l19;
	JLabel lsec;
	static JLabel question;
	static JLabel question1;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	
	static JRadioButton r1;
	static JRadioButton r2;
	static JRadioButton r3;
	JRadioButton r4;
	CheckboxGroup cbg;
	static int qid=1;
	String student_answer="";
	String answer="";
	int student_marks=00;
	static int student_id;
	JButton b1,b2;
	Timer time;
	int min=0,sec=0;
	
	JLabel image;
	Font f=new Font("Serief",Font.BOLD,17);
	Exam_home_page()
	{
		setTitle("Exam home page");
		//setSize(1400,900);
		setBounds(00,00,1600,900);
		setLayout(null);
		ImageIcon icon=new ImageIcon("C://Users/Sangita/eclipse-workspace/Class_programs/src/Exam_Management_System/Image/exams1.png");
		image=new JLabel(icon);
		image.setBounds(0,0,1600,900);
		add(image);
		
	
		
		image.add(l1=new JLabel("Welcome"));
		l1.setBounds(100,10,120,50);
		l1.setFont(f);
		
		image.add(l3=new JLabel("Roll Number"));
		l3.setBounds(10,100,120,50);
		l3.setFont(f);
		image.add(l4=new JLabel("Take roll number"));
		l4.setBounds(200,100,100,50);
		l4.setFont(f);
		
		image.add(l5=new JLabel("User Name"));
		l5.setBounds(10,160,100,50);
		l5.setFont(f);
		
		image.add(l6=new JLabel("take user"));
		l6.setBounds(200,160,100,50);
		l6.setFont(f);
		
		image.add(l7=new JLabel("Total question"));
		l7.setBounds(10,220,150,50);
		l7.setFont(f);
		
		image.add(l8=new JLabel(" 10 "));
		l8.setBounds(200,220,100,50);
		l8.setFont(f);
		
		image.add(l9=new JLabel("Question Id"));
		l9.setBounds(10,280,150,50);
		l9.setFont(f);
		
		image.add(l10=new JLabel(""));
		l10.setBounds(200,280,200,50);
		l10.setFont(f);
		
		image.add(l11=new JLabel("Your Marks"));
		l11.setBounds(10,350,100,50);
		l11.setFont(f);
		
		image.add(l12=new JLabel("00"));
		l12.setBounds(200,350,100,50);
		l12.setFont(f);
		
		image.add(l13=new JLabel("Total time"));
		l13.setBounds(1200,10,80,30);
		l13.setFont(f);
		
		image.add(l14=new JLabel("10 Minute"));
		l14.setBounds(1300,10,80,30);
		l14.setFont(f);
		
		image.add(l15=new JLabel("take time"));
		l15.setBounds(1210,60,80,30);
		l15.setFont(f);
		
		image.add(l16=new JLabel("min"));
		l16.setBounds(1300,60,80,30);
		l16.setFont(f);
		
		image.add(lsec=new JLabel("sec"));
		lsec.setBounds(1350,60,80,30);
		lsec.setFont(f);
		
		image.add(question1=new JLabel(""));
		question1.setBounds(400,80,400,50);
		question1.setFont(f);
		
		image.add(l17=new JLabel("date"));
		l17.setBounds(400,20,120,30);
		l17.setFont(f);
		
	    image.add(l18=new JLabel("take date"));
		l18.setBounds(470,20,120,30);
		l18.setFont(f);
		
		image.add(r1=new JRadioButton("Option 1"));
		r1.setBounds(480,150,300,50);
		r1.setFont(f);
		
		image.add(r2=new JRadioButton("Option 2"));
		r2.setBounds(480,250,300,50);
		r2.setFont(f);
		
		image.add(r3=new JRadioButton("Option 3"));
		r3.setBounds(480,350,300,50);
		r3.setFont(f);
		
		image.add(b2=new JButton("Submit"));
		b2.setBounds(550,500,80,40);
		b2.setVisible(false);
		
		image.add(b1=new JButton("Next"));
		b1.setBounds(650,500,80,40);
		
		
	       			
		//listener add
				r1.addActionListener(this);
				r2.addActionListener(this);
				r3.addActionListener(this);
				
				b1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					//JRadioButton r=(JRadioButton)e.getSource();					
					qid=qid+1;					
					Exam_home_page.set_question();
					
					
					if(r1.isSelected() || r2.isSelected() || r3.isSelected() )
					{
						
					if(answer.equals(student_answer))
					{
						student_marks=student_marks+1;
						l12.setText(student_marks+"");																								
					}
					
					}
					if(qid==10)
					{
					
						JOptionPane.showMessageDialog(null,"This is the last question");
					}
					if(qid==11)
					{
						b1.setVisible(false);
						b2.setVisible(true);
					}
					r1.setSelected(false);					
					r2.setSelected(false);
					r3.setSelected(false);
				}
			});
							
			b2.addActionListener(new ActionListener() 
			{
				
				public void actionPerformed(ActionEvent e)
				{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/exam_management_system";
					String username="root";
					String password="";
					
					Connection con=DriverManager.getConnection(url,username,password);
					
					Statement st=con.createStatement();
					String update="update student_data set Result='"+student_marks+"' where Roll_number='"+student_id+"'";										
					st.executeUpdate(update);
					JOptionPane.showMessageDialog(null,"Total marks is "+student_marks);
					
					dispose();
					//new Certificate_page(student_marks);
					JOptionPane.showMessageDialog(null,"Total marks is "+student_marks);
					//new Index_page();					
				}
				catch(Exception d)
				{
					JOptionPane.showMessageDialog(null,d);
				}									
				}				
			});
			
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
	}	
	
	static public void  Dated() //this is the date function
	{
				 	
		SimpleDateFormat f=new SimpleDateFormat("dd-MM-yyyy");
		Date dd=new Date();
		//System.out.println(f.format(dd));
		l18.setText(f.format(dd));
		
	}
	
	public void Time()
	{
	
		time =new Timer();
		
		
	}
	
	public void data_display(int id) //student dada display
	{
		try {
				student_id=id;
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/exam_management_system";
				String username="root";
				String password="";
				Exam_home_page.Dated();//call to the date method
				Exam_home_page o=new Exam_home_page();
				o.Time();
				Connection con=DriverManager.getConnection(url,username,password);											
				
				if(con!=null)
				{
					
						PreparedStatement st=con.prepareStatement("select * from student_data where Roll_number=?");
						st.setString(1,id+"");
						ResultSet result=st.executeQuery();
					
						while(result.next())
						{
									
									l4.setText(result.getString(1));
									l6.setText(result.getString(2));
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
	
	static public void  set_question() //add question to screen
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/exam_management_system";
			String username="root";
			String password="";
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			PreparedStatement st=con.prepareStatement("select * from question_save where q_id=?");
			st.setString(1,qid+"");
			l10.setText(qid+"");
			ResultSet result=st.executeQuery();
			
			while(result.next())
			{
					question1.setText(result.getString(2));
					r1.setText(result.getString(3));
					r2.setText(result.getString(4));
					r3.setText(result.getString(5));
			}
			
		}
		catch(Exception d)
		{
				
			JOptionPane.showMessageDialog(null,d);
			
		}
	}
	public void actionPerformed(ActionEvent e)
	{
			JRadioButton r=(JRadioButton)e.getSource();
					
			if(r==r1)
			{
			
				student_answer=r1.getText();
				r2.setSelected(false);
				r3.setSelected(false);
				
			}
			if(r==r2)
			{
				student_answer=r2.getText();
				r1.setSelected(false);
				r3.setSelected(false);
				
			}
			if(r==r3)
			{			
				student_answer=r3.getText();
				r1.setSelected(false);
				r2.setSelected(false);
			}			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/exam_management_system";
				String username="root";
				String password="";				
				Connection con=DriverManager.getConnection(url,username,password);
				
				PreparedStatement st=con.prepareStatement("select * from question_save where q_id=?");
				st.setString(1,qid+"");
				ResultSet result=st.executeQuery();
				while(result.next())
				{
					answer=result.getString(6);
				}																												
			}
			catch(Exception d)
			{
				JOptionPane.showMessageDialog(null,d);
			}			
	}	
	public static void std_id(int id)
	{
		student_id=id;
				
	}
	public static void main(String[] args)
	{
		Exam_home_page on=	new Exam_home_page();
		on.Dated();
		
		
	
	}
}
