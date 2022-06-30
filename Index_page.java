package Exam_Management_System;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Index_page extends JFrame{
	
	JButton b1,b2,b3;
	JLabel l1;
	Index_page()
	{
		setTitle("Exam Management System");		
		setLayout(null);
		
		ImageIcon icon=new ImageIcon("C://Users/Sangita/eclipse-workspace/Class_programs/src/Exam_Management_System/Image/exams2.png");
			
		Container c=getContentPane();
		c.setBackground(Color.red);
		setBounds(400,20,800,750);
				
		add(l1=new JLabel(icon));
		l1.setBounds(0,0,800,800);
		
		//l1.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		l1.add(b1=new JButton("Student Login"));		
		b1.setBounds(150,80,150,50);		
				
		l1.add(b2=new JButton("Admin Login"));
		b2.setBounds(350,80,150,50);
		
		l1.add(b3=new JButton("Exit"));
		b3.setBounds(550,80,150,50);
				
		btn ob=new btn();
		b1.addActionListener(ob);
		b2.addActionListener(ob);
		b3.addActionListener(ob);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
	}
	class btn implements ActionListener
	{		
		public void actionPerformed(ActionEvent e)
		{			
			JButton b=(JButton)e.getSource();
			
				if(b==b1)
				{
					dispose();
					new Student_login();						
				}
				if(b==b2)
				{
					dispose();
					new Admin_login();				
				}
				if(b==b3)
				{					
					System.exit(0);
				}
		}		
	}
	public static void main(String[] args)
	{
		
		new Index_page();
				
	}
	}
