package Exam_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Example extends JFrame implements ActionListener{
	
	JMenuBar m;
	JMenu m1,m2,m3,m4,m5,m6;
	JMenuItem m11,m12,m13;
	JMenuItem m21,m22,m23;
	JMenuItem m31,m32,m33;
	JTextField t;
	
	JButton b1;
	
	Example()
	{
		setTitle("");
		setSize(500,560);
		setLayout(new FlowLayout());
		
		add(m=new JMenuBar());
		
		m.add(m1=new JMenu("File"));
		m1.add(m11=new JMenuItem("Opne File"));
		m1.add(m12=new JMenuItem("Save File"));
		m1.add(m13=new JMenuItem("new File"));
		
		m.add(m2=new JMenu("Edit"));
		m2.add(m21=new JMenuItem("delete file"));
		m2.add(m22=new JMenuItem("Edit File"));
		m2.add(m23=new JMenuItem("Cute file"));
		
		m.add(m3=new JMenu("Source"));
		m3.add(m31=new JMenuItem("Taggle comment"));
		m3.add(m32=new JMenuItem("remove Taggle comment"));
		m3.add(m33=new JMenuItem("format comment"));
		
		add(b1=new JButton("Color"));
		b1.addActionListener(this);
		add(t=new JTextField(20));
	
		//listener
		
		m11.addActionListener(this);
		m12.addActionListener(this);
		m13.addActionListener(this);
		m21.addActionListener(this);
		m22.addActionListener(this);
		m23.addActionListener(this);
		m31.addActionListener(this);
		m32.addActionListener(this);
		m33.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}	
	public void actionPerformed(ActionEvent e)
	{
			String f=e.getActionCommand();
			JButton b=(JButton)e.getSource();
			Container c=getContentPane();
			
			t.setText("You click on "+f);
			
			if(b==b1)
			{
				c.setBackground(Color.red);
				
			}
		
	}
	
	public static void main(String[] args)
	{
		
		new Example();
	}

}
