package Exam_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class add_data extends JFrame{
	
	static JLabel i;
	JLabel l1,l2,l3,l4,l5,l6,image;
	
	JTextField t2;
	JTextField t3;
	JTextField t4;
	JTextField t5;
	JTextField t6;
	JButton b1,back;
	
	Font f=new Font("Serief",Font.BOLD,15);
	Font l=new Font("Serief",Font.BOLD,17);
	
	public static int id;
     add_data()
	{
    	setTitle("Add new  Question");
		setBounds(400,20,800,700);
		setLayout(null);
		

		ImageIcon icon=new ImageIcon("C://Users/Sangita/eclipse-workspace/Class_programs/src/Exam_Management_System/Image/add_question1.jpg");
		image=new JLabel(icon);
		image.setBounds(0,0,800,700);
		add(image);
		
		image.add(l1=new JLabel("Question Id"));
		l1.setBounds(80,50,120,90);
		l1.setFont(l);
		image.add(i=new JLabel());
		i.setBounds(200,85,120,25);
	    i.setFont(f);
		
		image.add(l2=new JLabel("Question"));
		l2.setBounds(100,120,120,90);
		l2.setFont(l);
		add(t2=new JTextField(20));
		t2.setBounds(220,150,200,25);
		t2.setFont(f);
		
		image.add(l3=new JLabel("Option 1"));
		l3.setBounds(100,180,120,90);
		l3.setFont(l);
		add(t3=new JTextField(20));
		t3.setBounds(220,215,200,25);
		t3.setFont(f);
		
		image.add(l4=new JLabel("Option 2"));
		l4.setBounds(100,250,120,90);
		l4.setFont(l);
		add(t4=new JTextField(20));
		t4.setBounds(220,290,200,25);
		t4.setFont(f);
		
		image.add(l5=new JLabel("Option 3"));
		l5.setBounds(100,320,120,90);
		l5.setFont(l);
		add(t5=new JTextField(20));
		t5.setBounds(220,350,200,25);
		t5.setFont(f);
		
		image.add(l6=new JLabel("Write Answer"));
		l6.setBounds(80,390,120,90);
		l6.setFont(l);
		add(t6=new JTextField(20));
		t6.setBounds(220,426,200,25);
		t6.setFont(f);
		
		image.add(b1=new JButton("Submit"));
		b1.setBounds(110,480,120,40);
		
		image.add(back=new JButton("Back"));
		back.setBounds(650,20,120,30);
		
		
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				try {
						Class.forName("com.mysql.jdbc.Driver");
						String url="jdbc:mysql://localhost:3306/exam_management_system";
						String username="root";
						String password="";
						
						String q1=id+"";
						String q2=t2.getText();
						String q3=t3.getText();
						String q4=t4.getText();
						String q5=t5.getText();
						String q6=t6.getText();
												
						Connection con=DriverManager.getConnection(url,username,password);
					
						if(con!=null) 
						{
							if(q1.equals("") || q2.equals("") || q3.equals("") || q4.equals("") || q5.equals("") || q6.equals(""))
							{
								JOptionPane.showMessageDialog(null,"All Field are Mandatory","Error",JOptionPane.ERROR_MESSAGE);
							}
							else
							{

								PreparedStatement pr=con.prepareStatement("INSERT INTO question_save VALUES(?,?,?,?,?,?,?)");
								pr.setString(1,q1+"");
								pr.setString(2,q2);
								pr.setString(3,q3);
								pr.setString(4,q4);
								pr.setString(5,q5);
								pr.setString(6,q6);
								pr.setString(7,0+"");
								pr.executeUpdate();
								JOptionPane.showMessageDialog(null,"data inserted successfully");
								add_data.id_update();
								
								
								t2.setText("");
								t3.setText("");
								t4.setText("");
								t5.setText("");
								t6.setText("");
								
							
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"database not connected");
							
						}					
				}
				catch(Exception d)
				{
					JOptionPane.showMessageDialog(null,d);
					System.out.println(d);
				}
				
			}
			
			
		});
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				dispose();
				new Admin_home();
				
			}
			
		});
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	public static  void id_update()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/exam_management_system";
			String username="root";
			String password="";
						
			Connection con=DriverManager.getConnection(url,username,password);			
			Statement sr=con.createStatement();
			
			String srt="SELECT * FROM question_save WHERE q_id";
			ResultSet result=sr.executeQuery(srt);
			while(result.next())
			{
				id=Integer.parseInt(result.getString(1));
			}
				id=id+1;
				i.setText(id+"");
				con.close();
			
		}
		catch(Exception d)
		{
			System.out.println(d);
		}
		
	}
		
	public static void main(String[] args)
	{
		add_data ob=new add_data();
		ob.id_update();
	}

}
