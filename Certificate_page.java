package Exam_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Certificate_page extends JFrame{
	
	int marks;
	Certificate_page(int marks)
	{
		
		JLabel l1,l2,l3;
		JPanel p1,p2;
		
		setTitle("Ceriticate of course");
		setLayout(null);
		
		add(l1=new JLabel(""));
		l1.setText(marks+"");
		
		add(p1=new JPanel());
		p1.setBounds(15,15,960,730);
		p1.setBackground(Color.white);
		
		p1.add(l3=new JLabel("CERTIFICATE"));
		l3.setBounds(200,100,200,500);
		
		p1.add(l1=new JLabel(marks+""));
		
		
		
		Container c=getContentPane();
		c.setBackground(Color.black);
		setBounds(300,20,1000,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);				
		
	}		
	public static void main(String[] args)
	{
		//new Certificate_page(20);
		
	}
}
