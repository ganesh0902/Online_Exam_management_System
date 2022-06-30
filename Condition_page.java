package Exam_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Condition_page extends JFrame implements ActionListener{
	
	JPanel p1;
	JLabel l1,l2,l3,l4,l5;
	JButton b1;
	
	Condition_page()
	{
		setTitle("Condition page");
		setBounds(300,50,900,670);
		setLayout(null);
		
		add(p1=new JPanel());
		p1.setBounds(40,50,800,450);
		p1.setBackground(Color.red);
		
		add(l1=new JLabel("fjfjf"));
	
		add(b1=new JButton("Start Exim"));
		b1.setBounds(250,540,400,50);
		b1.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
	}	
	public void actionPerformed(ActionEvent e)
	{
		JButton b=(JButton)e.getSource();
		
		if(b==b1)
		{
			new Exam_home_page();
			
			
		}
	}
	
	public static void main(String[] args)
	{
	
		new Condition_page();
		
	}
}
